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

  public AlcMixer[] getData(){
    AlcMixer[] amArray = new AlcMixer[alcoholMixers.size()];
    alcoholMixers.toArray(amArray);
    return amArray;
  }
  
  public Object getValueAt(final int row, int col){
    if(col == 1){
      return alcoholMixers.get(row).getPercentage();
    } else if(col == 2){
      return alcoholMixers.get(row).getDrinkName();
    } else if(col == 0){
      JButton button = new JButton("Remove");
      button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
          System.out.println(row);
          alcoholMixers.remove(row);
          fireTableRowsDeleted(row, row);
        }
      });
      return button;
    }

    return null;
  }

  public void insertObject(AlcMixer alc){
    alcoholMixers.add(alc);
    fireTableDataChanged();
  }

  public Class getColumnClass(int col){
    switch(col){
      case 0:
        return JButton.class; 
      case 1: 
        return Integer.class;
      case 2: 
        return String.class;
      default: 
        return null;
    }
  }

  public String getColumnName(int col){
    switch(col){
      case 0: 
        return "Remove";
      case 1: 
        return "Percentage";
      case 2: 
        return "Drink Name";
      default: 
        return "";
    }
  }
  
  public boolean isCellEditable(int row, int col) { return true; }

  

}
