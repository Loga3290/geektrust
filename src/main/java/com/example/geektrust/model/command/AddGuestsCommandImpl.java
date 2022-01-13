package com.example.geektrust.model.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.model.aparment.ApartmentWrapper;

public class AddGuestsCommandImpl implements Command {

    @Override
    public void runCommand(String[] args)  {
        Apartment apartment = ApartmentWrapper.getInstance();
        if(apartment == null){
            throw new WaterManagementException("Please run Allot_water command before running add_guest..");

        }
        apartment.addGuest(Integer.parseInt(args[1]));
    }
}
