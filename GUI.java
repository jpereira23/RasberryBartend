import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
  public JFrame frame;
  

  public GUI(){
    setupMainWindow();
  }


  private void setupMainWindow(){
    frame = new JFrame("Bartending Robot");
    frame.setSize(800, 500);
    frame.setLayout(null);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
