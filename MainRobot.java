
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
// Main Robot Project


interface APIDelegate{
    public void finishedAPICall();
}

public class MainRobot implements APIDelegate{ 
  
  public API a = new API();    
  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Robot r = new Robot();
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
  public void finishedAPICall(){
    GUI g = new GUI(a.drink1);
  } 
}
