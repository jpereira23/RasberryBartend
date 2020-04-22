package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 

public class AlcMixer{
  private String drinkName; 
  private int percentage; 

  public AlcMixer(String dn, int perc){
    drinkName = dn; 
    percentage = perc;
  }

  public String getDrinkName(){
    return drinkName;
  }

  public int getPercentage(){
    return percentage;
  }
}
