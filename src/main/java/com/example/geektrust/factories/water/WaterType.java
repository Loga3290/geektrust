package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

public interface WaterType {

    Double calculateLitres(Apartment apartment);

    Double calculateCost(Double litres);
}
