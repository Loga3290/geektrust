package com.example.geektrust.factories.command;

import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.factories.aparment.ApartmentAndRatio;
import com.example.geektrust.factories.aparment.ApartmentFactory;

public class AllotWaterCommandImpl extends Command {

    @Override
    public void runCommand(String[] args) {
        ApartmentAndRatio instance = ApartmentAndRatio.getInstance();
        instance.init(ApartmentFactory.getApartment(args), args[2]);
    }
}
