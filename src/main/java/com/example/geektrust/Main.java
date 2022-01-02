package com.example.geektrust;

import com.example.geektrust.factories.command.Command;
import com.example.geektrust.factories.command.CommandFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(
                "sample_input/input1.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {

            String[] arguments = st.split(" ");
            Command commandImpl = CommandFactory.getCommandImpl(arguments);
            commandImpl.runCommand(arguments);
        }
    }
}
