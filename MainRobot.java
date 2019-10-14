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
    JFrame frame = new JFrame("Bartending Robot");
    JButton b = new JButton("Press");

    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLed", PinState.HIGH);


  
    pin.setShutdownOptions(true, PinState.LOW);


   /*
    b.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          pin.toggle();
        }
    });
    */
    gpio.shutdown();
    createWindow(frame, b);
  }
}
