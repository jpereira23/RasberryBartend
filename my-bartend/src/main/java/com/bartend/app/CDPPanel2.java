package com.bartend.app; 

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList; 
import java.util.List;
import java.util.Hashtable;

public class CDPPanel2 implements ItemListener{
  public JPanel component;
  private JLabel drinkName; 
  private JComboBox alcoholMixers; 
  private JSlider percentage; 
  private JTable table; 
  private JButton doneEditing; 
  public JButton done; 
  public JButton prev; 
  private JScrollPane somePane;
  private CDPAbstractTableModel tableModel;
  private int aNum;

  public CDPPanel2(){
    component = new JPanel();
    aNum = 0;
    component.setBounds(0, 0, 350, 400);
    component.setLayout(null);    
    String[] itemList = {"Coke", "Sprite", "Lemonade"};

    drinkName = new JLabel("Some Drink"); 

    alcoholMixers = new JComboBox(itemList);
    alcoholMixers.setFont(new Font("Tahoma", Font.PLAIN, 10));
    alcoholMixers.setVisible(true);
    alcoholMixers.setLightWeightPopupEnabled(false);
    alcoholMixers.addItemListener(this);

    percentage = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
    percentage.setPaintTicks(true); 
    percentage.setPaintLabels(true);
    Hashtable position = new Hashtable();
    position.put(0, new JLabel("0"));
    position.put(10, new JLabel("10")); 
    position.put(20, new JLabel("20")); 
    position.put(30, new JLabel("30")); 
    position.put(40, new JLabel("40")); 
    position.put(50, new JLabel("50")); 
    position.put(60, new JLabel("60")); 
    position.put(70, new JLabel("70")); 
    position.put(80, new JLabel("80")); 
    position.put(90, new JLabel("90")); 
    
    percentage.setLabelTable(position);
     
    List<AlcMixer> ams = new ArrayList<>(); 
    tableModel = new CDPAbstractTableModel(ams);
    table = new JTable(tableModel); 
    table.setDefaultRenderer(JButton.class, new CDPAbstractTableRenderer());
    //table.setDefaultEditor(JButton.class, new CDPAbstractTableEditor());
    somePane = new JScrollPane(table);
    doneEditing = new JButton("Add"); 

    done = new JButton("Done"); 
    prev = new JButton("Prev"); 

    setBoundsForComponents();

    doneEditing.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        AlcMixer alc = new AlcMixer(String.valueOf(alcoholMixers.getSelectedItem()), percentage.getValue());
        tableModel.insertObject(alc);     
      }
    });


    component.add(drinkName); 
    component.add(alcoholMixers);
    component.add(percentage); 
    component.add(doneEditing); 
    component.add(somePane); 
    component.add(done); 
    component.add(prev);
    
  }

  public void itemStateChanged(ItemEvent e){
   
  }

  public void setDrinkValue(String value){
    drinkName.setText(value);
  }

  private void setBoundsForComponents(){
    drinkName.setBounds(110, 10, 350, 20);  
    alcoholMixers.setBounds(50, 40, 100,30);
    percentage.setBounds(20, 80, 250, 40);
    doneEditing.setBounds(120, 125, 100, 20);
    somePane.setBounds(40, 150, 220, 200);
    done.setBounds(225, 360, 50, 20); 
    prev.setBounds(40, 360, 50, 20);
  }

}
