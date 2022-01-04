package com.example.geektrust.factories.water;

import com.example.geektrust.exception.WaterManagementException;

public class WaterFactory {

    public static WaterType getWaterType(String waterType) throws WaterManagementException {
        switch (waterType){
            case "CORPORATION_WATER" : return new CorporationWater();
            case "BOREWELL_WATER" : return new BorewellWater();
            case "TANKER_WATER" : return new TankerWater();
            default: throw new WaterManagementException("invalid water type");
        }
    }
}
