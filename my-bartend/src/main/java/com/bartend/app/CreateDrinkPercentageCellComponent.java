package com.bartend.app;

import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*; 


public class CreateDrinkPercentageCellComponent extends JPanel
{
  int percentage; 
  JLabel label;
  JButton addButton;
  JButton subtractButton;
  public CreateDrinkPercentageCellComponent(){
    addButton = new JButton("+"); 
    subtractButton = new JButton("-"); 
    label = new JLabel();
    label.setText("" + percentage + "");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0){
        percentage += 5;  
        label.setText("" + percentage + "");
      }
    }); 

    subtractButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0){
        percentage -= 5; 
        label.setText("" + percentage + "");
      }
    });

    add(addButton); 
    add(subtractButton); 
    add(label); 
  }

  public void updateData(Object value, boolean isSelected, JTable table){
    
    label.setText("" + this.percentage + "");
    
    
  }
}
