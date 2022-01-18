package com.example.geektrust;


import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.Command;
import org.junit.Assert;
import org.junit.Test;

public class AllotWaterCommandImplTest {

    @Test
    public void testAllotWaterCommand() {
        Command allotWaterCommand = new AllotWaterCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        allotWaterCommand.runCommand(new String[]{"ALLOT_WATER", "2", "3:5"}, aparmentWrapper);
        Assert.assertEquals("3:5", aparmentWrapper.getApartment().getAllotmentRatio());
        Assert.assertTrue(aparmentWrapper.getApartment() instanceof TwoBedRoomApartment);
    }


}