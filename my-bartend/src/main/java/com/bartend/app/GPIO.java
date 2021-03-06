package com.bartend.app;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.*;

public class GPIO {
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
   private Boolean isBusy;
   public Boolean isIR;
   public Boolean breakLoop;

   

   public GPIO(){
     gpio = GpioFactory.getInstance();
     pump1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15);
     pump2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16);
     pump3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
     pump4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
     pump5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
     pump6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
     pump7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10);
     pump8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11);
     pump9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_31);
     pump10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
     pump11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
     pump12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
     pump13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);
     pump14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
     pump15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09);
     pump16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
     irSensor = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

     GpioArray = new GpioPinDigitalOutput[]{pump1, pump2, pump3, pump4, pump5, pump6, pump7, pump8, pump9, pump10, pump11, pump12, pump13, pump14, pump15};
     pump1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump8.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump9.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump10.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump11.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump12.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump13.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump14.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump15.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
     pump16.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
      pump16.setState(PinState.HIGH); 
      pump14.setState(PinState.HIGH);
      /*
     for(int i = 0; i < 16; i++){
       GpioArray[i].low();
     }
    */
    /*
     irSensor.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                // System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
              //JOptionPane.showMessageDialog(null, "IR Sensor is on");
              
              if(event.getState() == PinState.HIGH){
                delegate.isHigh();
                isIR = true;
              } else if(event.getState() == PinState.LOW){
                delegate.isLow();
                isIR = false; 
              }
              


              //isBusy = false;
            }

        });
      

    */
   }  
  public void makeDrink(AlcMixer[] am){
    try{
      for(int i = 0; i < am.length; i++){
        GpioArray[am[i].getSlot()].low(); 
        Thread.sleep(100*am[i].getPercentage());
        GpioArray[am[i].getSlot()].high();
      }
    } catch (InterruptedException error){
      System.out.println("Error");
    }
  }

  public void setAllLow(){
    isIR = true;
    for(int i = 0; i < 15; i++){
      GpioArray[i].high();
    }
  }

   public void shutdownProtocol(){
     gpio.shutdown();
   }

   public Boolean busy(){
      return this.isBusy;
   }
 } 
