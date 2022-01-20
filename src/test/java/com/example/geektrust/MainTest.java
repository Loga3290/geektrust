package com.example.geektrust;


import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.ApartmentFactory;
import com.example.geektrust.factories.CommandFactory;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.model.aparment.ThreeBedRoomApartment;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;
import com.example.geektrust.model.command.AddGuestsCommandImpl;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.BillCommandImpl;
import com.example.geektrust.model.command.Command;
import com.example.geektrust.util.ErrorMessgageConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testBillCommand() {

        Command billCommand = new BillCommandImpl(Arrays.asList("CORPORATION_WATER", "BOREWELL_WATER", "TANKER_WATER"));
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        aparmentWrapper.getApartment().setAllotmentRatio("2:1");
        billCommand.runCommand(new String[]{"BILL"}, aparmentWrapper);
        assertEquals("900 1050", outContent.toString()
                .trim());
    }

    @Test(expected = WaterManagementException.class)
    public void testBillCommandRunningBeforeAllotment() {

        Command billCommand = new BillCommandImpl(Arrays.asList("CORPORATION_WATER", "BOREWELL_WATER", "TANKER_WATER"));
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(null);
        billCommand.runCommand(new String[]{"BILL"}, aparmentWrapper);

    }
    @Test
    public void testAddGuestCommand() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "2"}, aparmentWrapper);
        addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "2"}, aparmentWrapper);
        Assert.assertEquals(java.util.Optional.of(4).get(), aparmentWrapper.getApartment().getNoOfGuests());
    }
    @Test
    public void testAddGuestCommandWithInvalidInteger() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        try {
            addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "test"}, aparmentWrapper);
            Assert.fail("Passing Invalid Integer for no of guest fails");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_ARGUMENT, e.getMessage());
        }

    }
    @Test
    public void testAddGuestCommandWithAddGuestCommandBeforeAllotWaterCommand() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        try {
            addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "test"}, aparmentWrapper);
            Assert.fail("Passing Invalid Integer for no of guest fails");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.PLEASE_RUN_ALLOT_WATER_COMMAND_BEFORE_RUNNING_ADD_GUEST, e.getMessage());
        }

    }
    @Test
    public void testAllotWaterCommand() {
        Command allotWaterCommand = new AllotWaterCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        allotWaterCommand.runCommand(new String[]{"ALLOT_WATER", "2", "3:5"}, aparmentWrapper);
        Assert.assertEquals("3:5", aparmentWrapper.getApartment().getAllotmentRatio());
        Assert.assertTrue(aparmentWrapper.getApartment() instanceof TwoBedRoomApartment);
    }
    @Test
    public void testTwobedroomApartment() throws IOException {
        Apartment apartment = ApartmentFactory.getApartment(new String[]{"Allot_Water", "2"});
        Assert.assertTrue(apartment instanceof TwoBedRoomApartment);
    }
    @Test
    public void testThreebedroomApartment() throws IOException {
        Apartment apartment = ApartmentFactory.getApartment(new String[]{"Allot_Water", "3"});
        Assert.assertTrue(apartment instanceof ThreeBedRoomApartment);
    }
    @Test
    public void testInvalidApartment() throws IOException {
        try{
            ApartmentFactory.getApartment(new String[]{"Allot_Water", "0"});
            Assert.fail("Invalid Apartment Type exception is not thrown");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_APARTMENT_ROOM_TYPE, e.getMessage());
        }
    }



    @Test
    public void testAllotWaterCommandFactory() {
        Command apartment = CommandFactory.getCommandImpl("ALLOT_WATER");
        Assert.assertTrue(apartment instanceof AllotWaterCommandImpl);
    }
    @Test
    public void testAddGuestCommandFactory() {
        Command apartment = CommandFactory.getCommandImpl("ADD_GUESTS");
        Assert.assertTrue(apartment instanceof AddGuestsCommandImpl);
    }
    @Test
    public void testBillCommandFactory() {
        Command apartment = CommandFactory.getCommandImpl("BILL");
        Assert.assertTrue(apartment instanceof BillCommandImpl);
    }
    @Test
    public void testInvalidCommand() {
        try{
            CommandFactory.getCommandImpl("XYZ");
            Assert.fail("Invalid command Type exception is not thrown");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_COMMAND, e.getMessage());
        }
    }

    @Test
    public void testSampleInput1() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 2 3:7",
                "ADD_GUESTS 2", "ADD_GUESTS 3", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("2400 5215", outContent.toString()
                .trim());

    }

    @Test
    public void testSampleInput2() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 3 2:1",
                "ADD_GUESTS 4", "ADD_GUESTS 1", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("3000 5750", outContent.toString()
                .trim());

    }

    @Test
    public void testSampleInput3() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 2 1:2", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("900 1200", outContent.toString()
                .trim());

    }

    @Test
    public void testExceptionInvalidCommand() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("test 4 1:2", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("Invalid command", outContent.toString()
                .trim());
    }

    @Test
    public void testExceptionInvalidAparmtmentType() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 4 1:2", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("Invalid Apartment Room type", outContent.toString()
                .trim());
    }

    @Test
    public void testExceptionInvalidRatio1() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 3 1:2:3", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("Invalid Ratio", outContent.toString()
                .trim());
    }

    @Test
    public void testExceptionInvalidRatio2() throws IOException {
        deleteFileContents();
        List<String> commandList = Arrays.asList("ALLOT_WATER 3 test:test", "BILL");
        addCommandToTheFile(commandList);
        new Main().main(new String[]{"sample_input/input1.txt"});
        assertEquals("Invalid Ratio", outContent.toString()
                .trim());
    }


    private void deleteFileContents() {
        try (FileWriter fw = new FileWriter("sample_input/input1.txt", false)) {


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addCommandToTheFile(List<String> commandList) {
        try (FileWriter fw = new FileWriter("sample_input/input1.txt")) {
            commandList.stream().forEach(s -> {
                try {
                    fw.write(s);
                    fw.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}