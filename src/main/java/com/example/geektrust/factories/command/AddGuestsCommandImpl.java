package com.example.geektrust.factories.command;

import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.factories.aparment.ApartmentAndRatio;

public class AddGuestsCommandImpl extends Command {

    @Override
    public void runCommand(String[] args) {
        if(ApartmentAndRatio.getInstance().getApartment() != null){
            ApartmentAndRatio.getInstance().getApartment().addGuest(Integer.parseInt(args[1]));
        }else{
            throw new RuntimeException("Please run Allot_water command before running add_guest..");
        }
    }
}
