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
	public GUIManager(){
		page = new MainPage();
		page1 = new AdminWizard();
		page2 = new AlcoholMixerPage();
		page3 = new AlcoholMixerCreate();
		page4 = new DictateSlotsPage();
		
		JPanel mainPage = page.getContentPanel();
		JPanel adminWizard = page1.getContentPanel();
		JPanel alcoholMixerPage = page2.getContentPanel();
		JPanel dictateSlotsPage = page4.getContentPanel();
		mainFrame = new JFrame("Bartending Robot");  
		mainFrame.setBounds(0, 0, 800, 425);
		mainFrame.add(mainPage);
		
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		page.adminButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainFrame.getContentPane().removeAll();
				mainFrame.repaint();
				mainFrame.add(adminWizard);

			}
		});

		page1.nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainFrame.getContentPane().removeAll();
				mainFrame.repaint();
				mainFrame.add(alcoholMixerPage);
			}
		});

		page2.createButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				page3.displayPopUp();
			}
		});

		page2.makeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainFrame.getContentPane().removeAll();
				mainFrame.repaint();
				mainFrame.add(dictateSlotsPage);
			}
		});
	}
}