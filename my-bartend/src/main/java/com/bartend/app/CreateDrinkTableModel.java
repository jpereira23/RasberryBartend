package com.bartend.app;
import java.awt.*; 
import java.awt.event.*; 
import java.io.IOException; 
import javax.swing.*; 
import javax.swing.table.AbstractTableModel; 
import java.util.List; 
public class CreateDrinkTableModel extends AbstractTableModel {
  List mixers; 

  public CreateDrinkTableModel(List mixers){
    this.mixers = mixers;
  }  

  public Class getColumnClass(int columnIndex){
      return String.class; 
  }
  
  public int getColumnCount(){
    return 2;
  }

  public String getColumnName(int columnIndex){
    if(columnIndex == 1){
      return "Alcohol/Mixer";
    }

    return "Percentage";
  }
  
  public int getRowCount() { return (mixers == null) ? 0 : mixers.size(); }
  public Object getValueAt(int rowIndex, int columnIndex) 
  { 
      return (mixers == null) ? null : mixers.get(rowIndex); 
  }
  public boolean isCellEditable(int columnIndex, int rowIndex) { return true; }
  
}
