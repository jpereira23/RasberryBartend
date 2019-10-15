import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

// Main Robot Project

public class MainRobot{ 
  private static void createWindow(JFrame frame, JButton b, JTextField t1, JTextField t2, JTextField t3, JTextField t4){
    b.setBounds(100, 100, 140, 40);
   t1.setBounds(100, 150, 200, 30);
    t2.setBounds(100, 200, 200, 30);
    t3.setBounds(100, 250, 200, 30);
    t4.setBounds(100, 300, 200, 30);
    
    frame.add(b); 
    frame.add(t1);
    frame.add(t2);
    frame.add(t3);
    frame.add(t4);
    frame.setSize(300, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{1,2,3,4};
    JFrame frame = new JFrame("Bartending Robot");
    JButton b = new JButton("Press");
    JTextField t1, t2, t3, t4;
    t1 = new JTextField("Pin 01");
    t2 = new JTextField("Pin 04");
    t3 = new JTextField("Pin 05");
    t4 = new JTextField("Pin 06");
    

    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLed", PinState.LOW);
    
    final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLed", PinState.LOW);

    final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLed", PinState.LOW);

    final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLed", PinState.LOW);

    pin1.setShutdownOptions(true, PinState.LOW);

    pin4.setShutdownOptions(true, PinState.LOW);

    pin5.setShutdownOptions(true, PinState.LOW);

    pin6.setShutdownOptions(true, PinState.LOW);


    b.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

          String s1 = t1.getText();
          String s2 = t2.getText();
          String s3 = t3.getText(); 
          String s4 = t4.getText();
          intArray[0] = Integer.parseInt(s1);
          intArray[1] = Integer.parseInt(s2);
          intArray[2] = Integer.parseInt(s3);
          intArray[3] = Integer.parseInt(s4);
          for(int i=0; i<4; i++){
            pin1.low();
            pin4.low();
            pin5.low();
            pin6.low();
            switch(i){
              case 0: 
                pin1.high();
                break; 
              case 1: 
                pin4.high();
                break;  
              case 2: 
                pin5.high();
                break;
              case 3:
                pin6.high();
                break;
              default: 
                break;
            } 
            try{
            Thread.sleep(intArray[i]*1000);
            } catch (InterruptedException error){
              System.out.println("Error");
            }
          }
        }
    });

    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        gpio.shutdown();
      }
    });
    createWindow(frame, b, t1, t2, t3, t4);
  }
}
