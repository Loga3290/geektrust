package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

public interface WaterType {

    Integer calculateLitres(Apartment apartment, String ratio);

    Double calculateCost(Integer litres);
}
