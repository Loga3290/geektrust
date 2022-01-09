package com.example.geektrust.factories.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.aparment.ApartmentAndRatio;
import com.example.geektrust.factories.water.WaterFactory;
import com.example.geektrust.factories.water.WaterType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BillCommandImpl implements Command {

    private List<String> waterTypes = Arrays.asList("CORPORATION_WATER", "BOREWELL_WATER", "TANKER_WATER");
    @Override
    public void runCommand(String[] args)  {
        ApartmentAndRatio apartmentAndRatio = ApartmentAndRatio.getInstance();
        if(apartmentAndRatio.getApartment() == null){
            throw new WaterManagementException("Invalid command. Allot_Water must be executed before Bill");
        }
        AtomicReference<Integer> totalCost = new AtomicReference<>(0);
        AtomicReference<Integer> totalLitres = new AtomicReference<>(0);
        waterTypes.stream().forEach(waterTypeString -> {
            WaterType waterType = WaterFactory.getWaterType(waterTypeString);
            Integer litres = waterType.calculateLitres(apartmentAndRatio.getApartment(), apartmentAndRatio.getAllotmentRatio());
            totalLitres.updateAndGet(v -> v + litres);
            totalCost.updateAndGet(v -> v + waterType.calculateCost(litres).intValue());

        });
        System.out.print(totalLitres.get() + " " + totalCost.get());
    }
}
