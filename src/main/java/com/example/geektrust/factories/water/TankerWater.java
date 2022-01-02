package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;

public class TankerWater implements WaterType {

    private static final int SLAB_3000 = 8;
    private static final int SLAB_1500 = 5;
    private static final int SLAB_500 = 3;
    private static final int SLAB_000 = 2;
    private Integer noOfDays = 30;

    @Override
    public Integer calculateLitres(Apartment apartment, String ratio) {
        return apartment.getNoOfGuests() * apartment.getLitrePerPerson() * noOfDays;
    }

    @Override
    public Double calculateCost(Integer totalLitres) {
        Integer totalCost = 0;
        if(totalLitres > 3000){
            totalCost += (totalLitres - 3000) * SLAB_3000;
            totalLitres = 3000;
        }
        if(totalLitres > 1500){
            totalCost += (totalLitres - 1500) * SLAB_1500;
            totalLitres = 1500;
        }
        if(totalLitres > 500){
            totalCost += (totalLitres - 500) * SLAB_500;
            totalLitres = 500;
        }
        totalCost += totalLitres * SLAB_000;
        return Double.valueOf(totalCost);
    }
}
