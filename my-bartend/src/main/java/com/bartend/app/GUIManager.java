package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import javax.swing.*;


public class GUIManager{
	JFrame mainFrame;
	MainPage page;
	AdminWizard page1;
	AlcoholMixerPage page2;
	AlcoholMixerCreate page3;
	DictateSlotsPage page4;
	PleaseSelectDrinkPage page5;
	CreateDrinkPage page6;
  CDPPanel1 page7;
	JPanel mainPage;
	JPanel adminWizard;
	JPanel alcoholMixerPage;
	JPanel dictateSlotsPage;
	JPanel pleaseSelectDrinkPage;
	public GUIManager(){
		page = new MainPage();
		page1 = new AdminWizard();
		page2 = new AlcoholMixerPage();
		page3 = new AlcoholMixerCreate();
		page4 = new DictateSlotsPage();
		page5 = new PleaseSelectDrinkPage();
		page6 = new CreateDrinkPage();
		
		mainPage = page.getContentPanel();
		adminWizard = page1.getContentPanel();
		alcoholMixerPage = page2.getContentPanel();
		dictateSlotsPage = page4.getContentPanel();
		pleaseSelectDrinkPage = page5.getContentPanel();
		mainFrame = new JFrame("Bartending Robot");  
		mainFrame.setBounds(0, 0, 800, 425);
		mainFrame.add(mainPage);
		
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpButtons();

		
	}

	private void refreshScreen(JPanel aPanel){
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
		mainFrame.add(aPanel);
	}

	private void setUpButtons(){
		configureButton(page.adminButton, adminWizard);
		configureButton(page1.nextButton, alcoholMixerPage);
		configureButton(page2.makeButton, dictateSlotsPage);
		configureButton(page4.doneButton, pleaseSelectDrinkPage);
		configureButton(page5.doneButton, mainPage);
    page4.doneButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        page4.getUpdatedChanges();
        refreshScreen(pleaseSelectDrinkPage);
      }
    });
		page2.createButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				page3.displayPopUp(page2.con);
			}
		});

		page5.createButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
        
				page6.displayPopUp(page5.getTableModel());
			}
		});

	}

	private void configureButton(JButton button, final JPanel thePanel){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refreshScreen(thePanel);
			}
		});
	}
}
