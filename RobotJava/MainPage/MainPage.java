import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JScrollPane;

public class MainPage extends BartendPanel{
	//private JFrame frame;
	private JTable table;
	public JButton makeButton;
	public JButton adminButton;
	public MainPage(){
		super("Please Select Drink");
		makeButton = new JButton("Make");
		makeButton.setBounds(340, 365, 100, 50);
		adminButton = new JButton("Admin"); 
		adminButton.setBounds(600, 0, 200, 50);

		createTable();

		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 50, 800, 315);

		component.add(contentPanel);
		component.add(makeButton);
		component.add(adminButton); 
		
		
	}

	private void createTable(){
		DefaultTableModel model = new DefaultTableModel(); 
    	model.addColumn("Drink Name");

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setBounds(0, 0, 300, 200);
	}
}