package com.bartend.app;

import java.awt.*; 
import java.awt.event.*; 
import java.io.IOException; 
import javax.swing.*; 
import java.util.List; 
import javax.swing.table.TableCellRenderer; 

public class CreateDrinkTableCellRenderer implements TableCellRenderer
{
  CreateDrinkComboBoxCellComponent comboBoxComponent;
  CreateDrinkPercentageCellComponent percentageComponent; 
  public CreateDrinkTableCellRenderer(){
    comboBoxComponent = new CreateDrinkComboBoxCellComponent();
    percentageComponent = new CreateDrinkPercentageCellComponent();
  }     

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
    if(column == 1){
      return comboBoxComponent;
    }
    percentageComponent.updateData(value, isSelected, table);
    return percentageComponent;
  }
}
