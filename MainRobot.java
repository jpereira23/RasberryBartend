import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;

public class MainRobot{
  public static void main(String[] args){

    ClientSocket client = new ClientSocket();
    GUI gui = new GUI(client);
    client.startConnection();
    client.print();
  }
}
