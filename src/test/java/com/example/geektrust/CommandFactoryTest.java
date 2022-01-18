package com.example.geektrust;


import com.example.geektrust.factories.CommandFactory;
import com.example.geektrust.model.command.AddGuestsCommandImpl;
import com.example.geektrust.model.command.AllotWaterCommandImpl;
import com.example.geektrust.model.command.BillCommandImpl;
import com.example.geektrust.model.command.Command;
import com.example.geektrust.util.ErrorMessgageConstant;
import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {



    @Test
    public void testAllotWaterCommand() {
        Command apartment = CommandFactory.getCommandImpl("ALLOT_WATER");
        Assert.assertTrue(apartment instanceof AllotWaterCommandImpl);
    }
    @Test
    public void testAddGuestCommand() {
        Command apartment = CommandFactory.getCommandImpl("ADD_GUESTS");
        Assert.assertTrue(apartment instanceof AddGuestsCommandImpl);
    }
    @Test
    public void testBillCommand() {
        Command apartment = CommandFactory.getCommandImpl("BILL");
        Assert.assertTrue(apartment instanceof BillCommandImpl);
    }
    @Test
    public void testInvalidCommand() {
        try{
            CommandFactory.getCommandImpl("XYZ");
            Assert.fail("Invalid command Type exception is not thrown");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_COMMAND, e.getMessage());
        }
    }



}