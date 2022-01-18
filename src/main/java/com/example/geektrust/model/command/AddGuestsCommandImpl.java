package com.example.geektrust.model.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.util.ErrorMessgageConstant;

public class AddGuestsCommandImpl implements Command {


    @Override
    public void runCommand(String[] args, AparmentWrapper aparmentWrapper)  {
        if(aparmentWrapper.getApartment() == null){
            throw new WaterManagementException(ErrorMessgageConstant.PLEASE_RUN_ALLOT_WATER_COMMAND_BEFORE_RUNNING_ADD_GUEST);
        }
        int guests = 0;
        try {
            guests = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new WaterManagementException(ErrorMessgageConstant.INVALID_ARGUMENT);
        }
        aparmentWrapper.getApartment().addGuest(guests);
    }
}
