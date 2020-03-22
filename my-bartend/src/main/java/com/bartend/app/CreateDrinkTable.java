package com.bartend.app; 

import java.awt.*;
import java.awt.event.*; 
import java.net.*;
import java.io.*; 
import javax.swing.*; 
import javax.swing.table.*; 
import java.util.ArrayList; 
import java.util.List;


public class CreateDrinkTable extends JTable
{
  public CreateDrinkTable(CreateDrinkTableModel model){
    super(model);
    setBounds(0, 0, 400, 200);    
    
    
  }
  
}
