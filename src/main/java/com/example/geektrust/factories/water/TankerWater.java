package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TankerWater implements WaterType {

    Map<Double, Double> slabMap = Stream.of(new Double[][] {
            { 3000d, 8d },
            { 1500d, 5d },
            { 500d, 3d },
            { 0d, 2d },
    }).collect(Collectors.toMap(o -> o[0], o -> o[1], (r, integers) -> null, LinkedHashMap::new));
    private Integer noOfDays = 30;

    @Override
    public Double calculateLitres(Apartment apartment) {
        return Double.valueOf(apartment.getNoOfGuests() * apartment.getLitrePerPerson() * noOfDays);
    }

    @Override
    public Double calculateCost(Double totalLitres) {
        Double totalCost = 0d;
        //top down approach to find the cost
        for(Map.Entry<Double, Double> entry : slabMap.entrySet()){
            if(totalLitres > entry.getKey()){
                totalCost += (totalLitres - entry.getKey()) * entry.getValue();
                totalLitres = entry.getKey();
            }
        }
        return totalCost;
    }
}
