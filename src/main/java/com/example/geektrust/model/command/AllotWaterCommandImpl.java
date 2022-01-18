package com.example.geektrust.model.command;

import com.example.geektrust.factories.ApartmentFactory;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.aparment.Apartment;

import java.util.List;

public class AllotWaterCommandImpl implements Command {

    @Override
    public void runCommand(String[] args, AparmentWrapper aparmentWrapper)  {
        Apartment apartment = ApartmentFactory.getApartment(args);
        apartment.setAllotmentRatio(args[2]);
        aparmentWrapper.setApartment(apartment);


    }
}
