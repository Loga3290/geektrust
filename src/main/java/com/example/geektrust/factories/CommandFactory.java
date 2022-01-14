package com.example.geektrust.factories;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.command.AddGuestsCommandImpl;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.BillCommandImpl;
import com.example.geektrust.model.command.Command;

import java.util.Arrays;
import java.util.List;

public class CommandFactory {

    private static List<String> waterTypes = Arrays.asList("CORPORATION_WATER", "BOREWELL_WATER", "TANKER_WATER");

    public static Command getCommandImpl(String commandType){

        switch(commandType){
            case "ALLOT_WATER" : return new AllotWaterCommandImpl(waterTypes);
            case "ADD_GUESTS" : return new AddGuestsCommandImpl(waterTypes);
            case "BILL" : return new BillCommandImpl(waterTypes);
            default: throw new WaterManagementException("Invalid command");
        }
    }
}
