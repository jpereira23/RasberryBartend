package com.bartend.app;

import java.awt.Component; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.table.*; 

public class CDPAbstractTableRenderer implements TableCellRenderer{
  public CDPAbstractTableRenderer(){
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
    JButton button = (JButton)value; 
    return button;
  }
}
