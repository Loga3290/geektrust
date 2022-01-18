package com.example.geektrust;


import com.example.geektrust.factories.ApartmentFactory;
import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.model.aparment.ThreeBedRoomApartment;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;
import com.example.geektrust.util.ErrorMessgageConstant;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ApartmentFactoryTest {



    @Test
    public void testTwobedroomApartment() throws IOException {
        Apartment apartment = ApartmentFactory.getApartment(new String[]{"Allot_Water", "2"});
        Assert.assertTrue(apartment instanceof TwoBedRoomApartment);
    }
    @Test
    public void testThreebedroomApartment() throws IOException {
        Apartment apartment = ApartmentFactory.getApartment(new String[]{"Allot_Water", "3"});
        Assert.assertTrue(apartment instanceof ThreeBedRoomApartment);
    }
    @Test
    public void testInvalidApartment() throws IOException {
        try{
            ApartmentFactory.getApartment(new String[]{"Allot_Water", "0"});
            Assert.fail("Invalid Apartment Type exception is not thrown");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_APARTMENT_ROOM_TYPE, e.getMessage());
        }
    }



}