package com.example.geektrust.model.command;

import com.example.geektrust.model.aparment.AparmentWrapper;

public interface Command {

      void runCommand(String[] args, AparmentWrapper apartment) ;
}
