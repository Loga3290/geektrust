package com.example.geektrust.model.command;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.factories.WaterFactory;
import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.water.WaterType;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BillCommandImpl extends Command {

    public BillCommandImpl(List<String> waterTypes){
        super(waterTypes);

    }
    @Override
    public void runCommand(String[] args, AparmentWrapper aparmentWrapper)  {
        if(aparmentWrapper == null){
            throw new WaterManagementException("Invalid command. Allot_Water must be executed before Bill");
        }
        AtomicReference<Double> totalCost = new AtomicReference<>(0d);
        AtomicReference<Double> totalLitres = new AtomicReference<>(0d);
        waterTypes.stream().forEach(waterTypeString -> {
            WaterType waterType = WaterFactory.getWaterType(waterTypeString);
            Double litres = waterType.calculateLitres(aparmentWrapper.getApartment());
            totalLitres.updateAndGet(v -> v + litres);
            totalCost.updateAndGet(v -> v + waterType.calculateCost(litres));

        });
        System.out.print(totalLitres.get().intValue() + " " + ((Double) Math.ceil(totalCost.get())).intValue());
    }
}
