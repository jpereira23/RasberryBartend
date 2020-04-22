package com.bartend.app;

import java.awt.Component; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.table.*; 

public class CDPAbstractTableRenderer extends JButton implements TableCellRenderer{
  public CDPAbstractTableRenderer(){
    super("Edit");
    setSize(20, 20);
    addActionListener(new ActionListener(){ 
      public void actionPerformed(ActionEvent e){
        System.out.println("Fuck you");
      }
    });
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
    return this; 
  }
}
