package com.example.geektrust.model.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.AparmentWrapper;

import java.util.List;

public class AddGuestsCommandImpl extends Command {

    public AddGuestsCommandImpl(List<String> waterTypes) {
        super(waterTypes);
    }

    @Override
    public void runCommand(String[] args, AparmentWrapper aparmentWrapper)  {
        if(aparmentWrapper.getApartment() == null){
            throw new WaterManagementException("Please run Allot_water command before running add_guest..");

        }
        aparmentWrapper.getApartment().addGuest(Integer.parseInt(args[1]));
    }
}
