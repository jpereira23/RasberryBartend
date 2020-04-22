package com.bartend.app;

import javax.swing.table.*;
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.util.ArrayList; 
import java.util.List;

public class CDPAbstractTableModel extends AbstractTableModel{
  
  //private AlcMixer[] alcoholMixers; 
  private List<AlcMixer> alcoholMixers;
  public CDPAbstractTableModel(List<AlcMixer> am){
    alcoholMixers = am;
  }

  public int getRowCount() { return alcoholMixers.size(); }
  public int getColumnCount() { return 3; }
  
  public Object getValueAt(int row, int col){
    if(col == 1){
      return alcoholMixers.get(row).getPercentage();
    } else if(col == 2){
      return alcoholMixers.get(row).getDrinkName();
    }

    return null;
  }

  public void insertObject(AlcMixer alc){
    alcoholMixers.add(alc);
    fireTableDataChanged();
  }

  public String getColumnName(int col){
    switch(col){
      case 0: 
        return "Edit?";
      case 1: 
        return "Percentage";
      case 2: 
        return "Drink Name";
      default: 
        return "";
    }
  }

  

}
