package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*; 
import java.util.List;
import java.util.ArrayList; 

public class Mixer{
  public List percentages;
  public List aMixers;

  public Mixer(){
    percentages = new ArrayList();
    aMixers = new ArrayList();
  }
}
