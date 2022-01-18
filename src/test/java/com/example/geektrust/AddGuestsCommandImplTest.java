package com.example.geektrust;


import com.example.geektrust.model.aparment.AparmentWrapper;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;
import com.example.geektrust.model.command.AddGuestsCommandImpl;
import com.example.geektrust.model.command.Command;
import com.example.geektrust.util.ErrorMessgageConstant;
import org.junit.Assert;
import org.junit.Test;

public class AddGuestsCommandImplTest {

    @Test
    public void testAddGuestCommand() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "2"}, aparmentWrapper);
        addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "2"}, aparmentWrapper);
        Assert.assertEquals(java.util.Optional.of(4).get(), aparmentWrapper.getApartment().getNoOfGuests());
    }
    @Test
    public void testAddGuestCommandWithInvalidInteger() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        aparmentWrapper.setApartment(new TwoBedRoomApartment(3, 10, 30));
        try {
            addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "test"}, aparmentWrapper);
            Assert.fail("Passing Invalid Integer for no of guest fails");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.INVALID_ARGUMENT, e.getMessage());
        }

    }
    @Test
    public void testAddGuestCommandWithAddGuestCommandBeforeAllotWaterCommand() {
        Command addguestCommandImpl = new AddGuestsCommandImpl();
        AparmentWrapper aparmentWrapper = new AparmentWrapper();
        try {
            addguestCommandImpl.runCommand(new String[]{"ADD_GUEST", "test"}, aparmentWrapper);
            Assert.fail("Passing Invalid Integer for no of guest fails");
        }catch (Exception e){
            Assert.assertEquals(ErrorMessgageConstant.PLEASE_RUN_ALLOT_WATER_COMMAND_BEFORE_RUNNING_ADD_GUEST, e.getMessage());
        }

    }

}