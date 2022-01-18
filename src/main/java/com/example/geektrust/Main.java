package com.example.geektrust;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.CommandFactory;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.command.Command;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            AparmentWrapper aparmentWrapper = new AparmentWrapper();
            File file = new File(
                    args[0]);

            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(" ");
                Command commandImpl = CommandFactory.getCommandImpl(arguments[0]);
                commandImpl.runCommand(arguments, aparmentWrapper);
            }
        } catch (WaterManagementException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
