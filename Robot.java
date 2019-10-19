
import java.awt.*;
import java.awt.event.*; 

import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.*;


public class Robot {
  private GpioController gpio; 
  private GpioPinDigitalOutput pump1;
  private GpioPinDigitalOutput pump2;
  private GpioPinDigitalOutput pump3;
  private GpioPinDigitalOutput pump4;
  private GpioPinDigitalOutput pump5;
  private GpioPinDigitalOutput pump6;
  private GpioPinDigitalOutput pump7;
  private GpioPinDigitalOutput pump8;
  private GpioPinDigitalOutput pump9;
  private GpioPinDigitalOutput pump10;
  private GpioPinDigitalOutput pump11;
  private GpioPinDigitalOutput pump12;
  private GpioPinDigitalOutput pump13;
  private GpioPinDigitalOutput pump14;
  private GpioPinDigitalOutput pump15;
  private GpioPinDigitalOutput pump16;
  private GpioPinDigitalInput irSensor;    
  private GpioPinDigitalOutput[] GpioArray;

  public Robot(){
    gpio = GpioFactory.getInstance();
    pump1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "My Led", PinState.LOW);
    pump2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "My Led", PinState.HIGH);
    pump3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "My Led", PinState.HIGH);
    pump4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "My Led", PinState.HIGH);
    pump5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "My Led", PinState.HIGH);
    pump6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "My Led", PinState.HIGH);
    pump7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "My Led", PinState.HIGH);
    pump8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "My Led", PinState.HIGH);
    pump9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_31, "My Led", PinState.HIGH);
    pump10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "My Led", PinState.HIGH);
    pump11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "My Led", PinState.HIGH);
    pump12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "My Led", PinState.HIGH);
    pump13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "My Led", PinState.HIGH);
    pump14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "My Led", PinState.HIGH);
    pump15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "My Led", PinState.HIGH);
    pump16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "My Led", PinState.HIGH);
    irSensor = gpio.provisionDigitalInputPin(RaspiPin.GPIO_17, PinPullResistance.PULL_DOWN);
    
    GpioArray = new GpioPinDigitalOutput[]{pump1, pump2, pump3, pump4, pump5, pump6, pump7, pump8, pump9, pump10, pump11, pump12, pump13, pump14, pump15, pump16};

    pump1.setShutdownOptions(true, PinState.LOW);
    pump2.setShutdownOptions(true, PinState.LOW);
    pump3.setShutdownOptions(true, PinState.LOW);
    pump4.setShutdownOptions(true, PinState.LOW);
    pump5.setShutdownOptions(true, PinState.LOW);
    pump6.setShutdownOptions(true, PinState.LOW);
    pump7.setShutdownOptions(true, PinState.LOW);
    pump8.setShutdownOptions(true, PinState.LOW);
    pump9.setShutdownOptions(true, PinState.LOW);
    pump10.setShutdownOptions(true, PinState.LOW);
    pump11.setShutdownOptions(true, PinState.LOW);
    pump12.setShutdownOptions(true, PinState.LOW);
    pump13.setShutdownOptions(true, PinState.LOW);
    pump14.setShutdownOptions(true, PinState.LOW);
    pump15.setShutdownOptions(true, PinState.LOW);
    pump16.setShutdownOptions(true, PinState.LOW);

  }

  public void makeDrink(int[] a){
    for(int i = 0; i < 16; i++){
      try{
        GpioArray[i].low();
        Thread.sleep(a[i]*1000);
        GpioArray[i].high();
      } catch (InterruptedException error){
        System.out.println("Error");
      }
    }
  }

  public void shutdownProtocol(){
    gpio.shutdown();
  }
} 

