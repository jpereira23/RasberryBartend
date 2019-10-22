
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
// Main Robot Project


interface APIDelegate{
    public void finishedAPICall(Drink d);
}

public class MainRobot implements APIDelegate{ 
  
  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Robot r = new Robot();
    API a = new API();
    /*
    g.b1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        //r.makeDrink(intArray);
      }
    });
    */
  }
  @Override
  public void finishedAPICall(Drink d){
    GUI g = new GUI(d);
  } 
}
