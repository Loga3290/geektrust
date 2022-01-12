package com.example.geektrust.factories.command;

import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.factories.aparment.ApartmentFactory;
import com.example.geektrust.factories.aparment.ApartmentWrapper;

public class AllotWaterCommandImpl implements Command {

    @Override
    public void runCommand(String[] args)  {
        Apartment apartment = ApartmentFactory.getApartment(args);
        apartment.setAllotmentRatio(args[2]);

        ApartmentWrapper.init(apartment);
    }
}
