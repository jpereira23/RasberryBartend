import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;



public class MainRobot{ 
  private static void createWindow(JFrame frame, JButton b){
    b.setBounds(100, 100, 140, 40);
    frame.add(b); 
    frame.setSize(300, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) throws InterruptedException{
    int[] intArray = new int[]{1,2,3,4};
    JFrame frame = new JFrame("Bartending Robot");
    JButton b = new JButton("Press");

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
    createWindow(frame, b);
  }
}
