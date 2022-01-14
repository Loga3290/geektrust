package com.example.geektrust.factories;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.water.BorewellWater;
import com.example.geektrust.model.water.CorporationWater;
import com.example.geektrust.model.water.TankerWater;
import com.example.geektrust.model.water.WaterType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WaterFactory {

    static Map<Double, Double> slabMap = Stream.of(new Double[][] {
            { 3000d, 8d },
            { 1500d, 5d },
            { 500d, 3d },
            { 0d, 2d },
    }).collect(Collectors.toMap(o -> o[0], o -> o[1], (r, integers) -> null, LinkedHashMap::new));


    public static WaterType getWaterType(String waterType) throws WaterManagementException {
        switch (waterType){
            case "CORPORATION_WATER" : return new CorporationWater(1);
            case "BOREWELL_WATER" : return new BorewellWater(1.5);
            case "TANKER_WATER" : return new TankerWater(slabMap);
            default: throw new WaterManagementException("invalid water type");
        }
    }
}
