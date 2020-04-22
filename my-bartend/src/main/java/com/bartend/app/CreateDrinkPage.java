package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*; 
import java.util.List; 
import java.util.ArrayList;
import java.util.Hashtable;


public class CreateDrinkPage{
	private JFrame mainFrame;
	public JButton doneButton;
  public CDPPanel1 panel1;
  public CDPPanel2 panel2;
	public CreateDrinkPage(){
    panel1 = new CDPPanel1();
    panel2 = new CDPPanel2();
		doneButton = new JButton("Done");
		doneButton.setBounds(50, 380, 100, 50); 
    
		mainFrame = new JFrame(); 
		mainFrame.setBounds(300, 25, 300, 430);
    mainFrame.add(panel1.component);

	}

  public void displayPopUp(){
    mainFrame.setVisible(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);

    doneButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        mainFrame.dispose(); 
      }
    });

    panel1.nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        mainFrame.getContentPane().removeAll(); 
        mainFrame.repaint(); 
        panel2.setDrinkValue(panel1.getTextValue());
        mainFrame.add(panel2.component);
      }
    });

    panel1.cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        mainFrame.dispose();
      }
    });

    panel2.prev.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        mainFrame.getContentPane().removeAll(); 
        mainFrame.repaint(); 
        mainFrame.add(panel1.component);
      }
    });

    panel2.done.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        mainFrame.dispose();
      }
    });
  }
}
