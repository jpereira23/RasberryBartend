package com.bartend.app; 

import javax.swing.table.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.util.ArrayList; 
import java.util.List;

public class CDPButtonMouseListener extends MouseAdapter{
  private final JTable table;

  public CDPButtonMouseListener(JTable aTable){
    table = aTable;
  }

  @Override public void mouseClicked(MouseEvent e){
    int column = table.getColumnModel().getColumnIndexAtX(e.getX());
    int row = e.getY()/table.getRowHeight(); 

    if(row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0)
    {
      Object value = table.getValueAt(row, column); 
      if(value instanceof JButton){
        ((JButton)value).doClick();
      }
    }
  }
}
