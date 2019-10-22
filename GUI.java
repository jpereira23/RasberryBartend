import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
  public JFrame frame;
  public JTable j;   
 
  public JButton b1; 
  public JButton b2;
  private Drink aDrink;

  private String[] columnNames = {"Drink Name", "Slot 1", "Slot 2", "Slot 3", "Slot 4", "Slot 5", "Slot 6", "Slot 7", "Slot 8", "Slot 9", "Slot 10", "Slot 11", "Slot 12", "Slot 13", "Slot 14", "Slot 15"};
  private String[][] data;
  public GUI(Drink d){
    setupMainWindow();
    setupTextFields();
    setupButtons();
    frame.setLayout(null);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setUndecorated(true);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aDrink = d;
    data = { d.theDrink, Integer.toString(d.m_1), Integer.toString(d.m_2), Integer.toString(d.m_3), Integer.toString(d.m_4), Integer.toString(d.m_5), Integer.toString(d.m_6), Integer.toString(d.m_7), Integer.toString(d.m_8), Integer.toString(d.m_9), Integer.toString(d.m_10), Integer.toString(d.m_11), Integer.toString(d.m_12), Integer.toString(d.m_13), Integer.toString(d.m_14), Integer.toString(d.m_15);
  }


  private void setupMainWindow(){
    frame = new JFrame("Bartending Robot");
    frame.setSize(800, 500);
   	
  }

  private void setupButtons(){
    b1 = new JButton("Make Drink");
    b2 = new JButton("Reset");

    b1.setBounds(130, 250, 150, 30);
    b2.setBounds(300, 250, 100, 30);

    frame.add(b1);
    frame.add(b2);
  }
}
