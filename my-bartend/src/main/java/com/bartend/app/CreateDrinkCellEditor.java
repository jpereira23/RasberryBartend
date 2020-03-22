package com.bartend.app;

import java.awt.*; 
import java.awt.event.*; 
import java.io.IOException; 
import javax.swing.*; 
import java.util.List; 
import javax.swing.table.TableCellEditor; 
import javax.swing.event.CellEditorListener;

public class CreateDrinkCellEditor extends AbstractCellEditor implements TableCellEditor
{
  CreateDrinkComboBoxCellComponent comboBoxComponent;
  CreateDrinkPercentageCellComponent percentageComponent; 
  public CreateDrinkCellEditor(){
    comboBoxComponent = new CreateDrinkComboBoxCellComponent();
    percentageComponent = new CreateDrinkPercentageCellComponent();
  }     

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
    if(column == 1){
      return comboBoxComponent;
    }
    //percentageComponent.updateData(value, isSelected, table);
    return percentageComponent;
  }

  public Object getCellEditorValue(){
    return null;
  }

}
