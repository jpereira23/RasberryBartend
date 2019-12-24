import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*; 
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;

public class AlcoholMixerPage{
	private JLabel headerLabel;
	private JPanel component;
	private JTable table;
	public JButton makeButton;
	public JButton createButton;
	public AlcoholMixerPage(){
		headerLabel = new JLabel("Please select Alcohol/Mixer");
		headerLabel.setBounds(0, 0, 800, 50);

		component = new JPanel();
		component.setBounds(0, 0, 800, 425);
		component.setLayout(null);

		makeButton = new JButton("Make");
		makeButton.setBounds(100, 365, 100, 50);
		createButton = new JButton("Create");
		createButton.setBounds(400, 365, 100, 50);



		createTable();

		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 50, 800, 315);

		component.add(contentPanel);

		component.add(headerLabel);
		component.add(makeButton);
		component.add(createButton);

	}

	private void createTable(){
		DefaultTableModel model = new DefaultTableModel(); 
    	model.addColumn("Mixer/Alcohol Name");

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setBounds(0, 0, 800, 330);
	}

	public JPanel getContentPanel(){
		return component;
	}
}