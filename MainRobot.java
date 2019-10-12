import java.awt.*;
import javax.swing.*;



public class MainRobot{ 
  private static void createWindow(){
    JFrame frame = new JFrame("Bartending Robot"); 
    JButton b = new JButton("Press");

    b.setBounds(100, 100, 140, 40);
    frame.add(b); 
    frame.setSize(300, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args){
    createWindow();
  }
}
