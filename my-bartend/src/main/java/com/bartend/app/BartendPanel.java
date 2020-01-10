package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import java.io.*; 
import javax.swing.*;

public class BartendPanel
{
  protected JPanel component;
  protected JLabel headerLabel;
  
  public BartendPanel(String title)
  {
    component = new JPanel(); 
    component.setBounds(0, 0, 800, 425);
    component.setLayout(null); 

    headerLabel = new JLabel(title, SwingConstants.CENTER);
    headerLabel.setBounds(0, 0, 800, 50); 
    
    component.add(headerLabel); 
  }

  public JPanel getContentPanel()
  {
    return component;
  }
}
    
