package com.bartend.app;

import java.awt.*;   
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*; 
import javax.swing.table.*;
import javax.swing.JScrollPane;


public class MainPage extends BartendPanel
{
  private JTable table; 
  private JButton makeButton;
  final private GPIO gpio; 
  public JButton adminButton;
  private String[] drinks;
  public MainPage()
  {
    super("Please Select Drink");
    gpio = new GPIO();
    makeButton = new JButton("Make");
    makeButton.setBounds(340, 365, 100, 50);
    adminButton = new JButton("Admin");
    adminButton.setBounds(600, 0, 200, 50);
    
    makeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        int rowNum = table.getSelectedRow();
        Drink drink = new Drink(drinks[rowNum]); 
        gpio.makeDrink(drink.getAlcoholMixer());
        //String tmpString = drink.alcMixerString();
        //JOptionPane.showMessageDialog(component, drinks[rowNum] + " " + tmpString);
      }
    });
    createTable();
    
    JScrollPane contentPanel = new JScrollPane(table);
    contentPanel.setBounds(0, 50, 800, 315);
    
    component.add(contentPanel);
    component.add(makeButton);
    component.add(adminButton);
  }

  private void createTable()
  {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Drink Name");
    drinks = new SQLManager().getDrinks(); 

    table = new JTable(model);
    table.getColumnModel().getColumn(0).setPreferredWidth(300);
    table.setBounds(0, 0, 300, 200);
  
    for(int i = 0; i < drinks.length; i++){
      model.addRow(new Object[]{drinks[i]});
    }
    
  }
}
