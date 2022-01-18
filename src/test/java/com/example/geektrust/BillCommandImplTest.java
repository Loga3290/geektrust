package com.example.geektrust;


import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.BillCommandImpl;
import com.example.geektrust.model.command.Command;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillCommandImplTest {

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

}