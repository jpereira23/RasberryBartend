import java.awt.*;
import javax.swing.*;


import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
import java.io.IOException;



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

  public static void main(String[] args){
    final Console console = new Console();
    console.title("<--- Robot testing --->");
    console.promptForExit();
    final Serial serial = SerialFactory.createInstance();

    serial.addListener(new SerialDataEventListener() {
      @Override
      public void dataReceived(SerialDataEvent event){
        try{
          console.println("[HEX DATA]  " + event.getHexByteString());
	      } catch (IOException e) {
	      e.printStackTrace();
	      }
      }
    });

    /*
    try{
      SerialConfig config = new SerialConfig();
      config.device(SerialPort.getDefaultPort()).baud(Baud._38400).dataBits(DataBits._8).parity(Parity.NONE).stopBits(StopBits._1).flowControl(FlowControl.NONE);
      
      serial.open(config);
    } catch(IOException ex){
      ex.printStackTrace();
    }
    */
    createWindow();
  }
}
