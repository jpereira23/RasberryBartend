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
  private DefaultTableModel model;
	public JButton doneButton;
	public JButton createButton;
	public PleaseSelectDrinkPage(){
		super("Please Select Drink(s)");

		createButton = new JButton("Create");
		createButton.setBounds(340, 365, 100, 50);
		doneButton = new JButton("Done");
		doneButton.setBounds(500, 365, 100, 50);
    model = new DefaultTableModel();
		createTable();


		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 50, 800, 315); 


		component.add(contentPanel);
		component.add(createButton);
		component.add(doneButton);
	}

  public DefaultTableModel getTableModel(){
    return model;
  }

	private void createTable(){
		model.addColumn("Drink Name"); 

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setBounds(0, 0, 300, 200);

    String[] drinks = new SQLManager().getDrinks();

    for(int i = 0; i < drinks.length; i++){
      model.addRow(new Object[]{drinks[i]});
    }
	}
}
