package com.example.geektrust.factories.command;

import com.example.geektrust.factories.aparment.Apartment;

public abstract class Command {
     public Apartment apartment;
     public String allotmentRatio;
     public abstract void runCommand(String[] args);
}
