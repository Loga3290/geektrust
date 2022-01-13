package com.example.geektrust.factories;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.command.AddGuestsCommandImpl;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.BillCommandImpl;
import com.example.geektrust.model.command.Command;

public class CommandFactory {

    public static Command getCommandImpl(String commandType){

        switch(commandType){
            case "ALLOT_WATER" : return new AllotWaterCommandImpl();
            case "ADD_GUESTS" : return new AddGuestsCommandImpl();
            case "BILL" : return new BillCommandImpl();
            default: throw new WaterManagementException("Invalid command");
        }
    }
}
