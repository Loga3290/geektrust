package com.example.geektrust;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.command.Command;
import com.example.geektrust.factories.command.CommandFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File(
                    "sample_input/input1.txt");

            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(" ");
                Command commandImpl = CommandFactory.getCommandImpl(arguments[0]);
                commandImpl.runCommand(arguments);
            }
        } catch (WaterManagementException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
