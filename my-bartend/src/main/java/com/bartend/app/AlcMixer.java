package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 

public class AlcMixer{
  private String drinkName; 
  private int percentage; 
  private int slot;
  public AlcMixer(String dn, int perc){
    drinkName = dn; 
    percentage = perc;
    slot = 0;
  }

  public AlcMixer(String dn, int perc, int sl){
    drinkName = dn; 
    percentage = perc; 
    slot = sl;
  }

  public String getDrinkName(){
    return drinkName;
  }

  public int getPercentage(){
    return percentage;
  }

  public int getSlot(){
    return slot;
  }
}
