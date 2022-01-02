package com.example.geektrust.factories.water;

public class WaterFactory {

    public static WaterType getWaterType(String waterType){
        switch (waterType){
            case "CORPORATION_WATER" : return new CorporationWater();
            case "BOREWELL_WATER" : return new BorewellWater();
            case "TANKER_WATER" : return new TankerWater();
            default: throw new RuntimeException("invalid water type");
        }
    }
}
