package com.bartend.app;

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*; 


public class CDPPanel1{
  public JPanel component;
  private JLabel enterName;
  private JTextField nameField; 
  public JButton nextButton; 
  public JButton cancelButton;
  public CDPPanel1(){
    component = new JPanel();
    component.setBounds(0,0, 350, 400);
    component.setLayout(null);
    enterName = new JLabel("Enter Name"); 
    nameField = new JTextField();
    nextButton = new JButton("Next"); 
    cancelButton = new JButton("Cancel");
    setBoundsForComponents();
    component.add(enterName);
    component.add(nameField); 
    component.add(nextButton); 
    component.add(cancelButton);
  }

  private void setBoundsForComponents(){
    enterName.setBounds(110, 5, 350, 10);
    nameField.setBounds(50, 20, 200, 25);
    nextButton.setBounds(50, 300, 50, 20); 
    cancelButton.setBounds(200, 300, 50, 20);
  }

  public String getTextValue(){
    return nameField.getText();
  }

}
