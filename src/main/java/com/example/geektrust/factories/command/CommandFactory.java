package com.example.geektrust.factories.command;

public class CommandFactory {

    public static Command getCommandImpl(String[] args){

        switch(args[0]){
            case "ALLOT_WATER" : return new AllotWaterCommandImpl();
            case "ADD_GUESTS" : return new AddGuestsCommandImpl();
            case "BILL" : return new BillCommandImpl();
            default: throw new RuntimeException("Invalid command");
        }
    }
}
