package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*; 
import java.io.IOException; 
import javax.swing.*;

public class AdminWizard extends BartendPanel
{
  private JLabel headerLabel;
  public JButton nextButton;

  public AdminWizard()
  {
    super("Welcome To Admin Wizard");
    
    nextButton = new JButton("Next");
    nextButton.setBounds(300, 300, 100, 50);

    component.add(nextButton);
  }
}
