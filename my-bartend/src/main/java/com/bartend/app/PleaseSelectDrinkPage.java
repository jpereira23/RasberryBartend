package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JScrollPane;


public class PleaseSelectDrinkPage extends BartendPanel{
	private JTable table;
	public JButton doneButton;
	public JButton createButton;
	public PleaseSelectDrinkPage(){
		super("Please Select Drink(s)");

		createButton = new JButton("Create");
		createButton.setBounds(340, 365, 100, 50);
		doneButton = new JButton("Done");
		doneButton.setBounds(500, 365, 100, 50);

		createTable();


		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 50, 800, 315); 


		component.add(contentPanel);
		component.add(createButton);
		component.add(doneButton);
	}

	private void createTable(){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Drink Name"); 

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setBounds(0, 0, 300, 200);
	}
}
