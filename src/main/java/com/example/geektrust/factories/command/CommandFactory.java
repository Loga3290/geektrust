package com.example.geektrust.factories.command;

import com.example.geektrust.exception.WaterManagementException;

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
