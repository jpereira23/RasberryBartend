
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
// Main Robot Project


public class MainRobot{ 
  
  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Robot r = new Robot();
    GUI g = new GUI();
    API a = new API(g);
    /*
    g.b1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        //r.makeDrink(intArray);
      }
    });
    */
  }
}
