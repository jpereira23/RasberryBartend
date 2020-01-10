package com.bartend.app;

import java.awt.*; 
import java.awt.event.*;
import java.net.*; 
import java.io.*; 
import javax.swing.*; 
import javax.swing.table.*; 
import javax.swing.JScrollPane;

public class DictateSlotsPage extends BartendPanel{
  private JTable table; 
  public JButton doneButton;
  public DictateSlotsPage(){
    super("Dictate Slots Page"); 
    
    doneButton = new JButton("Done"); 
    doneButton.setBounds(340, 365, 100, 50); 
    
    createTable(); 
  
    JScrollPane contentPanel = new JScrollPane(table); 
    contentPanel.setBounds(0, 50, 800, 315); 

    component.add(contentPanel); 
    component.add(doneButton); 
  }

  private void createTable(){
    String[] data = {"Slot 1", "Slot 2", "Slot 3", "Slot 4", "Slot 5", "Slot 6", "Slot 7", "Slot 8", "Slot 9", "Slot 10", "Slot 11", "Slot 12", "Slot 13", "Slot 14", "Slot 15"}; 

    DefaultTableModel model = new DefaultTableModel(); 
    model.setRowCount(15); 
    model.addColumn("Slot[x]");
    model.addColumn("Alcohol Mixer"); 
    
    table = new JTable(model); 
    table.getColumnModel().getColumn(0).setPreferredWidth(300); 
    setUpAlcMixerColumn(table, table.getColumnModel().getColumn(1)); 
    table.setBounds(0, 0, 300, 200); 
    
    for(int i = 0; i < 15; i++)
    {
      table.setValueAt(data[i], i, 0); 
    }

  }

  private void setUpAlcMixerColumn(JTable table, TableColumn alcMixer){
    JComboBox comboBox = new JComboBox();
    
    comboBox.addItem("Honey Badger"); 
    comboBox.addItem("King Blues Tonic"); 
    comboBox.addItem("Bettys Ecstasy"); 
    
    alcMixer.setCellEditor(new DefaultCellEditor(comboBox)); 

    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); 
    renderer.setToolTipText("Click For Combo Box"); 
    alcMixer.setCellRenderer(renderer); 
  }
    
}
