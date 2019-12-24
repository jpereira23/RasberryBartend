import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JScrollPane;

public class MainPage{
	//private JFrame frame;
	private JTable table;
	private JLabel headerLabel;
	public JButton makeButton;
	public JButton adminButton;
	private JPanel component;
	public MainPage(){
		
		
		
		headerLabel = new JLabel("Please Select Drink");
		headerLabel.setBounds(0, 0, 600, 50);
		makeButton = new JButton("Make");
		makeButton.setBounds(340, 365, 100, 50);
		adminButton = new JButton("Admin"); 
		adminButton.setBounds(600, 0, 200, 50);
		component = new JPanel();
		component.setBounds(0, 0, 800, 425);
		component.setLayout(null);
		


		createTable();

		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 50, 800, 315);

		component.add(contentPanel);
		component.add(makeButton);
		component.add(adminButton); 
		component.add(headerLabel);
		
		
	}

	private void createTable(){
		DefaultTableModel model = new DefaultTableModel(); 
    	model.addColumn("Drink Name");

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setBounds(0, 0, 300, 200);


	}

	public JPanel getContentPanel(){
		return component;
	}
}