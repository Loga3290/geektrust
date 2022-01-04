package com.example.geektrust.factories.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.aparment.ApartmentAndRatio;

public class AddGuestsCommandImpl implements Command {

    @Override
    public void runCommand(String[] args)  {
        if(ApartmentAndRatio.getInstance().getApartment() != null){
            ApartmentAndRatio.getInstance().getApartment().addGuest(Integer.parseInt(args[1]));
        }else{
            throw new WaterManagementException("Please run Allot_water command before running add_guest..");
        }
    }
}
