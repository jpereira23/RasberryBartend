import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;

public class MainRobot{
  public static void main(String[] args){
  	Robot robot = new Robot();
    ClientSocket client = new ClientSocket();
    GUI gui = new GUI(client, robot);
    client.startConnection();
    client.print();
  }
}
