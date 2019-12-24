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
	public GUIManager(){
		page = new MainPage();
		page1 = new AdminWizard();
		JPanel mainPage = page.getContentPanel();
		JPanel adminWizard = page1.getContentPanel();
		mainFrame = new JFrame("Bartending Robot");  
		mainFrame.setBounds(0, 0, 800, 500);
		mainFrame.add(mainPage);
		
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		page.makeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainFrame.getContentPane().removeAll();
				mainFrame.repaint();
				mainFrame.add(adminWizard);

			}
		});
	}
}