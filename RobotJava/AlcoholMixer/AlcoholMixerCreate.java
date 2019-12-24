import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import java.io.*;
import javax.swing.*;

public class AlcoholMixerCreate{
	private JFrame mainFrame;
	private JButton doneButton;
	private JLabel nameLabel;
	private JTextField nameField;
	
	public AlcoholMixerCreate(){
		doneButton = new JButton("Done");
		doneButton.setBounds(50, 300, 100, 50);


		nameField = new JTextField();
		nameField.setBounds(50, 200, 100, 50);
		nameLabel = new JLabel("Enter Name");
		nameLabel.setBounds(50, 50, 100, 50);
		mainFrame = new JFrame();
		mainFrame.setBounds(300, 25, 200, 450);

		mainFrame.add(doneButton);
		mainFrame.add(nameLabel);
		mainFrame.add(nameField);
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(null);

	}

	public void displayPopUp(){
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
    	//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    	doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				mainFrame.dispose();
			}
		});
	}
}