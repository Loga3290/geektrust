package com.example.geektrust.factories.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.factories.aparment.ApartmentWrapper;
import com.example.geektrust.factories.water.WaterFactory;
import com.example.geektrust.factories.water.WaterType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BillCommandImpl implements Command {

    private List<String> waterTypes = Arrays.asList("CORPORATION_WATER", "BOREWELL_WATER", "TANKER_WATER");
    @Override
    public void runCommand(String[] args)  {
        Apartment apartment = ApartmentWrapper.getInstance();
        if(apartment == null){
            throw new WaterManagementException("Invalid command. Allot_Water must be executed before Bill");
        }
        AtomicReference<Double> totalCost = new AtomicReference<>(0d);
        AtomicReference<Double> totalLitres = new AtomicReference<>(0d);
        waterTypes.stream().forEach(waterTypeString -> {
            WaterType waterType = WaterFactory.getWaterType(waterTypeString);
            Double litres = waterType.calculateLitres(apartment);
            totalLitres.updateAndGet(v -> v + litres);
            totalCost.updateAndGet(v -> v + waterType.calculateCost(litres));

        });
        System.out.print(totalLitres.get().intValue() + " " + totalCost.get().intValue());
    }
}
