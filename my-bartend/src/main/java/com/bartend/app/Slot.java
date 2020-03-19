package com.bartend.app;

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*; 


public class Slot{

  private String drinkName; 
  private int id;

  public Slot(String theDrinkName, int theId){
    drinkName = theDrinkName;
    id = theId;
  }

  public String getDrinkName(){
    return drinkName;
  }

  public int getId(){
    return id;
  }
}
