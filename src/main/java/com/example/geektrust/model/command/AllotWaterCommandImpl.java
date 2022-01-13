package com.example.geektrust.model.command;

import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.factories.ApartmentFactory;
import com.example.geektrust.model.aparment.ApartmentWrapper;

public class AllotWaterCommandImpl implements Command {

    @Override
    public void runCommand(String[] args)  {
        Apartment apartment = ApartmentFactory.getApartment(args);
        apartment.setAllotmentRatio(args[2]);

        ApartmentWrapper.init(apartment);
    }
}
