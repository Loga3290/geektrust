package com.example.geektrust.model.water;

import com.example.geektrust.model.aparment.Apartment;

public interface WaterType {

    Double calculateLitres(Apartment apartment);

    Double calculateCost(Double litres);
}
