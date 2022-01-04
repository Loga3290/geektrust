package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TankerWater implements WaterType {

    Map<Integer, Integer> slabMap = Stream.of(new Integer[][] {
            { 3000, 8 },
            { 1500, 5 },
            { 500, 3 },
            { 0, 2 },
    }).collect(Collectors.toMap(o -> o[0], o -> o[1], (r, integers) -> null, LinkedHashMap::new));
    private Integer noOfDays = 30;

    @Override
    public Integer calculateLitres(Apartment apartment, String ratio) {
        return apartment.getNoOfGuests() * apartment.getLitrePerPerson() * noOfDays;
    }

    @Override
    public Double calculateCost(Integer totalLitres) {
        Integer totalCost = 0;
        //top down approach to find the cost
        for(Map.Entry<Integer, Integer> entry : slabMap.entrySet()){
            if(totalLitres > entry.getKey()){
                totalCost += (totalLitres - entry.getKey()) * entry.getValue();
                totalLitres = entry.getKey();
            }
        }
        return Double.valueOf(totalCost);
    }
}
