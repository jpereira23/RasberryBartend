
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// Main Robot Project

public class MainRobot{ 
  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Robot r = new Robot();
    GUI g = new GUI();
    
    g.b1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        String s1 = g.t1.getText(); 
        String s2 = g.t2.getText(); 
        String s3 = g.t3.getText(); 
        String s4 = g.t4.getText(); 
        String s5 = g.t5.getText(); 
        String s6 = g.t6.getText(); 
        String s7 = g.t7.getText(); 
        String s8 = g.t8.getText(); 
        String s9 = g.t9.getText(); 
        String s10 = g.t10.getText(); 
        String s11 = g.t11.getText(); 
        String s12 = g.t12.getText(); 
        String s13 = g.t13.getText(); 
        String s14 = g.t14.getText(); 
        String s15 = g.t15.getText(); 
        String s16 = g.t16.getText(); 
        intArray[0] = Integer.parseInt(s1);
        intArray[1] = Integer.parseInt(s2);
        intArray[2] = Integer.parseInt(s3);
        intArray[3] = Integer.parseInt(s4);
        intArray[4] = Integer.parseInt(s5);
        intArray[5] = Integer.parseInt(s6);
        intArray[6] = Integer.parseInt(s7);
        intArray[7] = Integer.parseInt(s8);
        intArray[8] = Integer.parseInt(s9);
        intArray[9] = Integer.parseInt(s10);
        intArray[10] = Integer.parseInt(s11);
        intArray[11] = Integer.parseInt(s12);
        intArray[12] = Integer.parseInt(s13);
        intArray[13] = Integer.parseInt(s14);
        intArray[14] = Integer.parseInt(s15);
        intArray[15] = Integer.parseInt(s16);

        r.makeDrink(intArray);
      }
    });
  }
}
