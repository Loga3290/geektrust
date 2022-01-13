package com.example.geektrust.factories;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.water.BorewellWater;
import com.example.geektrust.model.water.CorporationWater;
import com.example.geektrust.model.water.TankerWater;
import com.example.geektrust.model.water.WaterType;

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
