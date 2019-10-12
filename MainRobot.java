import java.awt.*;
import javax.swing.*;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;



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

  public static void main(String[] args) throws InterruptedException{

    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "MyLed", PinState.HIGH);

    pin.setShutdownOptions(true, PinState.LOW);

    Thread.sleep(5000);

    gpio.shutdown();
    createWindow();
  }
}
