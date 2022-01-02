package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BorewellWater implements WaterType {

    private Integer noOfDays = 30;
    private double costPerLitre = 1.5;

    @Override
    public Integer calculateLitres(Apartment apartment, String ratio) {
        int totalWaterConsumed = apartment.getNoOfPersons() * apartment.getLitrePerPerson() * noOfDays;
        List<Integer> ratios = Arrays.stream(ratio.split(":")).map(Integer::parseInt).collect(Collectors.toList());
        Integer sum = ratios.stream().collect(Collectors.summingInt(Integer::intValue));
        return (totalWaterConsumed / sum) * ratios.get(1);
    }

    @Override
    public Double calculateCost(Integer litres) {
        return litres * costPerLitre;
    }
}
