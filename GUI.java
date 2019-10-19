import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
  public JFrame frame;
  
  public JTextField t1;
  public JTextField t2;
  public JTextField t3;
  public JTextField t4; 
  public JTextField t5;
  public JTextField t6;
  public JTextField t7;
  public JTextField t8;
  public JTextField t9;
  public JTextField t10;
  public JTextField t11;
  public JTextField t12;
  public JTextField t13;
  public JTextField t14;
  public JTextField t15;
  public JTextField t16;
  
  public JButton b1; 
  public JButton b2;

  public GUI(){
    setupMainWindow();
    setupTextFields();
    setupButtons();
    frame.setLayout(null);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setUndecorated(true);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    

  }


  private void setupMainWindow(){
    frame = new JFrame("Bartending Robot");
    frame.setSize(800, 500);
  }

  private void setupTextFields(){
    t1 = new JTextField("Pump 1");
    t2 = new JTextField("Pump 2");
    t3 = new JTextField("Pump 3");
    t4 = new JTextField("Pump 4");
    t5 = new JTextField("Pump 5");
    t6 = new JTextField("Pump 6");
    t7 = new JTextField("Pump 7");
    t8 = new JTextField("Pump 8");
    t9 = new JTextField("Pump 9");
    t10 = new JTextField("Pump 10");
    t11 = new JTextField("Pump 11");
    t12 = new JTextField("Pump 12");
    t13 = new JTextField("Pump 13");
    t14 = new JTextField("Pump 14");
    t15 = new JTextField("Pump 15");
    t16 = new JTextField("Pump 16");

    t1.setBounds(10, 50, 100, 30);
    t2.setBounds(130, 50, 100, 30);
    t3.setBounds(250, 50, 100, 30);
    t4.setBounds(370, 50, 100, 30);

    t5.setBounds(10, 100, 100, 30);
    t6.setBounds(130, 100, 100, 30);
    t7.setBounds(250, 100, 100, 30);
    t8.setBounds(370, 100, 100, 30);

    t9.setBounds(10, 150, 100, 30);
    t10.setBounds(130, 150, 100, 30);
    t11.setBounds(250, 150, 100, 30);
    t12.setBounds(370, 150, 100, 30);
    
    t13.setBounds(10, 200, 100, 30);
    t14.setBounds(130, 200, 100, 30);
    t15.setBounds(250, 200, 100, 30);
    t16.setBounds(370, 200, 100, 30);

    frame.add(t1);
    frame.add(t2);
    frame.add(t3);
    frame.add(t4);
    frame.add(t5);
    frame.add(t6);
    frame.add(t7);
    frame.add(t8);
    frame.add(t9);
    frame.add(t10);
    frame.add(t11);
    frame.add(t12);
    frame.add(t13);
    frame.add(t14);
    frame.add(t15);
    frame.add(t16);
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
