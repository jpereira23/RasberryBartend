package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;


interface MySQLConnectionDelegate{
  void alcoholMixerData(Object[] array);
  void slotsData(Object[] array);
}
public class AlcoholMixerPage extends BartendPanel implements MySQLConnectionDelegate{
  private JLabel headerLabel;
  private JTable table; 
  public JButton makeButton; 
  public JButton createButton; 
  MySQLConnection con;
  private DefaultTableModel model;
  public AlcoholMixerPage(){
    super("Please select Alcohol/Mixer");
    model = new DefaultTableModel();

    con = new MySQLConnection();
    con.delegate = this;

    makeButton = new JButton("Make");
    makeButton.setBounds(100, 365, 100, 50);
    
    createButton = new JButton("Create"); 
    createButton.setBounds(400, 365, 100, 50); 

    createTable(); 
    con.getAlcoholMixers();
    JScrollPane contentPanel = new JScrollPane(table); 
    contentPanel.setBounds(0, 50, 800, 315); 
    
    component.add(contentPanel);
    component.add(makeButton); 
    component.add(createButton); 
  }

  private void createTable()
  {
    model.addColumn("Mixer/Alcohol Name"); 
    
    table = new JTable(model); 
    table.getColumnModel().getColumn(0).setPreferredWidth(300); 
    table.setBounds(0, 0, 800, 330); 
  }


  @Override
  public void alcoholMixerData(Object[] array){
    if(model.getRowCount() < array.length){
      if((array.length - model.getRowCount()) == 1){
        Slot s = (Slot)array[array.length-1];
        String aString = s.getDrinkName();
        model.addRow(new Object[]{aString});
      } else {
        for(int i = 0; i < array.length; i++) 
        {
          Slot s = (Slot)array[i];
          String aString = s.getDrinkName();
          model.addRow(new Object[]{aString});
        }
      }
    }
    model.fireTableDataChanged();
  }

  @Override
  public void slotsData(Object[] array){

  } 
}
