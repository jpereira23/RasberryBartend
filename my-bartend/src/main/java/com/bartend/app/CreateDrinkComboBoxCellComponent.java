package com.bartend.app;

import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*; 
import java.util.List;


public class CreateDrinkComboBoxCellComponent extends JPanel
{
  List alcoholMixers;
  JComboBox comboBox; 
  public CreateDrinkComboBoxCellComponent(){
    comboBox = new JComboBox(); 
    /*
    for(int i = 0; i < alcoholMixers.size(); i++){
      comboBox.addItem(alcoholMixers[i]);
    }
    */ 
    comboBox.addItem("Item 1"); 
    comboBox.addItem("Item 2");

    add(comboBox);
  }
}
