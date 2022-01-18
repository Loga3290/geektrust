package com.example.geektrust;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

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