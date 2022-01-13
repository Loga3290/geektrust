package com.example.geektrust.model.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.model.aparment.ApartmentWrapper;
import com.example.geektrust.factories.WaterFactory;
import com.example.geektrust.model.water.WaterType;

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
        System.out.print(totalLitres.get().intValue() + " " + ((Double) Math.ceil(totalCost.get())).intValue());
    }
}