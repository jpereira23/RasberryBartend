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
import java.util.Arrays;

public class DictateSlotsPage extends BartendPanel implements MySQLConnectionDelegate{
  private JTable table; 
  public JButton doneButton;
  private JComboBox comboBox;
  private MySQLConnection con; 
  private List<TableCellEditor> editors = new ArrayList<TableCellEditor>(15);
  private int[] intArray;
  public DictateSlotsPage(){
    super("Dictate Slots Page"); 
    con = new MySQLConnection();
    con.delegate = this;
    doneButton = new JButton("Done"); 
    doneButton.setBounds(340, 365, 100, 50); 
   
    con.getSlots(); 
    component.add(doneButton); 
  }

  public void getUpdatedChanges(){
    for(int i = 0; i < 15; i++){
      Object value =  editors.get(i).getCellEditorValue();
      if(value != ""){
        int id = con.getId((String)value);
        con.updateSlots(id, i);
      }
    } 
  }
  private void createTable(){
    String[] columnNames = {"Slot[x]", "Alcohol Mixers"};
    Object[][] data = {
      {"Slot 1", con.getDrinkName(intArray[0])},
      {"Slot 2", con.getDrinkName(intArray[1])},
      {"Slot 3", con.getDrinkName(intArray[2])},
      {"Slot 4", con.getDrinkName(intArray[3])},
      {"Slot 5", con.getDrinkName(intArray[4])},
      {"Slot 6", con.getDrinkName(intArray[5])},
      {"Slot 7", con.getDrinkName(intArray[6])},
      {"Slot 8", con.getDrinkName(intArray[7])},
      {"Slot 9", con.getDrinkName(intArray[8])},
      {"Slot 10", con.getDrinkName(intArray[9])},
      {"Slot 11", con.getDrinkName(intArray[10])},
      {"Slot 12", con.getDrinkName(intArray[11])},
      {"Slot 13", con.getDrinkName(intArray[12])},
      {"Slot 14", con.getDrinkName(intArray[13])},
      {"Slot 15", con.getDrinkName(intArray[14])},
    };
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    table = new JTable(model)
    {
      public TableCellEditor getCellEditor(int row, int column)
      {
        int modelColumn = convertColumnIndexToModel( column );
        
        if(modelColumn == 1 && row < 15)
          return editors.get(row);
        else 
          return super.getCellEditor(row, column);
      }
    };
    
/*
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
      //DefaultCellEditor cell = (DefaultCellEditor)table.getValueAt(i, 1);
      DefaultCellEditor cell = (DefaultCellEditor)table.getCellEditor(i, 1);
      JComboBox box = (JComboBox)cell.getComponent();
      comboBox.setSelectedItem("drink");
      cell = new DefaultCellEditor(comboBox);
      table.setValueAt(cell, i, 1);
    }
    */
  }

  private void setUpAlcMixerColumn(final JTable table, TableColumn alcMixer){
    comboBox = new JComboBox();
    System.out.println("Hello");
    con.getAlcoholMixers();
    alcMixer.setCellEditor(new DefaultCellEditor(comboBox)); 

    comboBox.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String drinkName = (String)comboBox.getSelectedItem();
        if(drinkName != null)
        {
          con.updateSlots(con.getId(drinkName),table.getSelectedRow());
        }
      }
    });
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); 
    renderer.setToolTipText("Click For Combo Box"); 
    alcMixer.setCellRenderer(renderer); 
  }

  @Override
  public void alcoholMixerData(Object[] array){
        
        for(int i = 0; i < 15; i++){
          JComboBox aComboBox = new JComboBox();
          aComboBox.addItem("");
          for(int j = 0; j < array.length; j++) 
          {
            Slot s = (Slot)array[j];
          
            aComboBox.addItem(s.getDrinkName());
          }
          DefaultCellEditor dce = new DefaultCellEditor(aComboBox);
          editors.add(dce);
        }
      createTable();
      JScrollPane contentPanel = new JScrollPane(table); 
      contentPanel.setBounds(0, 50, 800, 315); 

      component.add(contentPanel);

  }

  @Override 
  public void slotsData(Object[] array){
    intArray = new int[]{(int)array[0], (int)array[1], (int)array[2], (int)array[3], (int)array[4], (int)array[5], (int)array[6], (int)array[7], (int)array[8], (int)array[9], (int)array[10], (int)array[11], (int)array[12], (int)array[13], (int)array[14]}; 

    con.getAlcoholMixers();
  }
    
}
