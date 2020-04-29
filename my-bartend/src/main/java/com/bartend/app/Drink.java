package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*; 

public class Drink{
  private String drinkName; 
  private AlcMixer[] am; 

  public Drink(String aDrink, AlcMixer[] alc){
    drinkName = aDrink; 
    am = alc;
  }

  public Drink(String aDrink){
    drinkName = aDrink;
    int drinkId = new SQLManager().getDrinkID(drinkName); 
    am = new SQLManager().getAlcMixers(drinkId);   
  }

  public void shipOffToDatabase(){
    SQLManager sql = new SQLManager(); 
    sql.createDrink(drinkName); 
    int drinkNameId = sql.getDrinkID(drinkName);
    for(int i = 0; i < am.length; i++){ 
      int alcoholMixerID = sql.getAlcoholMixerID(am[i].getDrinkName());
      System.out.println(sql.getAlcoholMixerID(am[i].getDrinkName()));
      sql.addAlcoholMixerToDrink(am[i].getPercentage(), alcoholMixerID, drinkNameId);
    }
    
  }

  public AlcMixer[] getAlcoholMixer(){
    return am;
  } 

}
