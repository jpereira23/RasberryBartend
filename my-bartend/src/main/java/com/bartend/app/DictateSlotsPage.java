package com.bartend.app;

import java.awt.*; 
import java.awt.event.*;
import java.net.*; 
import java.io.*; 
import javax.swing.*; 
import javax.swing.table.*; 
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.List;

public class DictateSlotsPage extends BartendPanel implements MySQLConnectionDelegate{
  private JTable table; 
  public JButton doneButton;
  private JComboBox comboBox;
  private MySQLConnection con;
  public DictateSlotsPage(){
    super("Dictate Slots Page"); 
    con = new MySQLConnection();
    con.delegate = this;
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
    comboBox = new JComboBox();
    con.getAlcoholMixers();
    alcMixer.setCellEditor(new DefaultCellEditor(comboBox)); 

    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); 
    renderer.setToolTipText("Click For Combo Box"); 
    alcMixer.setCellRenderer(renderer); 
  }

  @Override
  public void alcoholMixerData(Object[] array){
        for(int i = 0; i < array.length; i++) 
        {
          String aString = array[i].toString();
          comboBox.addItem(aString);
        }
  }
    
}
