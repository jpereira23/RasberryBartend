import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
  public JFrame frame;
  public JTable j;   
 
  public JButton b1; 
  public JButton b2;
  private Drink aDrink; 
  public GUI(Drink d){
    setupMainWindow();
    setupButtons();
    frame.setLayout(null);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setUndecorated(true);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aDrink = d;
    setupTableView();
  }

  private void setupTableView(){
    String[][] data = {{aDrink.theDrink, aDrink.m_1, aDrink.m_2, aDrink.m_3, aDrink.m_4, aDrink.m_5, aDrink.m_6, aDrink.m_7, aDrink.m_8, aDrink.m_9, aDrink.m_10, aDrink.m_11, aDrink.m_12, aDrink.m_13, aDrink.m_14, aDrink.m_15}};
    String[] columns = {"Drink Name", "Slot 1", "Slot 2", "Slot 3", "Slot 4", "Slot 5", "Slot 6", "Slot 7", "Slot 8", "Slot 9", "Slot 10", "Slot 11", "Slot 12", "Slot 13", "Slot 14", "Slot 15"};
    j = new JTable(data, columns);
    j.setBounds(50, 50 700, 300);
    
    frame.add(j);
    
    
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
