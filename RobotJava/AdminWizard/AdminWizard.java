import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import javax.swing.*;

public class AdminWizard{
	private JLabel headerLabel;
	private JPanel component;
	public AdminWizard(){
		headerLabel = new JLabel("Welcome To Admin Wizard");
		headerLabel.setBounds(0, 0, 600, 400);

		component = new JPanel(); 
		component.setBounds(0, 0, 800, 500);
		component.setLayout(null);

		component.add(headerLabel);
	}

	public JPanel getContentPanel(){
		return component;
	}
}