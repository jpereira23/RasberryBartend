package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*; 

public class AlcoholMixer{
  private Slot slot; 
  private int percentage; 

  public AlcoholMixer(Slot s, int p){
    slot = s; 
    percentage = p;
  }
}
