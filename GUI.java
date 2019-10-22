import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
  public JFrame frame;
  public JTable j;   
 
  public JButton b1; 
  public JButton b2;
  private Drink aDrink;

  private String[][] data;
  public GUI(Drink d){
    setupMainWindow();
    setupButtons();
    frame.setLayout(null);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setUndecorated(true);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aDrink = d;
    //data = {{aDrink.theDrink, aDrink.m_1, aDrink.m_2, aDrink.m_3, aDrink.m_4, aDrink.m_5, aDrink.m_6, aDrink.m_7, aDrink.m_8, aDrink.m_9, aDrink.m_10, aDrink.m_11, aDrink.m_12, aDrink.m_13, aDrink.m_14, aDrink.m_15}};
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
