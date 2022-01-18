package com.example.geektrust;


import com.example.geektrust.factories.WaterFactory;
import com.example.geektrust.model.water.BorewellWater;
import com.example.geektrust.model.water.CorporationWater;
import com.example.geektrust.model.water.TankerWater;
import com.example.geektrust.model.water.WaterType;
import com.example.geektrust.util.ErrorMessgageConstant;
import org.junit.Assert;
import org.junit.Test;

public class WaterFactoryTest {

    @Test
    public void testCorporationWater() {
        WaterType waterType = WaterFactory.getWaterType("CORPORATION_WATER");
        Assert.assertTrue(waterType instanceof CorporationWater);
    }
    @Test
    public void testBorewellWater() {
        WaterType waterType = WaterFactory.getWaterType("BOREWELL_WATER");
        Assert.assertTrue(waterType instanceof BorewellWater);
    }
    @Test
    public void testTankerWater() {
        WaterType waterType = WaterFactory.getWaterType("TANKER_WATER");
        Assert.assertTrue(waterType instanceof TankerWater);
    }
    @Test
    public void testInvalidWaterType() {
        try{
            WaterFactory.getWaterType("XYZ");
            Assert.fail("Invalid water Type exception is not thrown");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_WATER_TYPE, e.getMessage());
        }
    }



}