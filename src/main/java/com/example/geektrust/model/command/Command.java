package com.example.geektrust.model.command;

import com.example.geektrust.model.aparment.AparmentWrapper;

import java.util.List;

public abstract class Command {
     public List<String> waterTypes;

     Command(List<String> waterTypes){
          this.waterTypes = waterTypes;
     }
     public abstract void runCommand(String[] args, AparmentWrapper apartment) ;
}
