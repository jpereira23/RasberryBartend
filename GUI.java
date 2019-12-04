import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Queue; 
import java.util.LinkedList;

interface RobotDelegate{
    void isHigh();
    void isLow();
}

interface ClientSocketDelegate{
  void dataReceived(JSONObject object);
}
public class GUI implements ClientSocketDelegate, RobotDelegate{
	private JFrame frame;
    private JTable table;
    private Queue<Drink> queue;
    private JButton pop;
    private Robot localRobot;
	public GUI(ClientSocket socket, Robot robot){
		socket.delegate = this;
        robot.delegate = this;
		queue = new LinkedList<>();
		frame = new JFrame("Bartending Robot");
    	frame.setSize(800, 450);
    	makeTable();
    	frame.add(table);
    	frame.setLayout(null);
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      localRobot = robot;
	}

	private void makeTable(){
		DefaultTableModel model = new DefaultTableModel(); 
    	model.addColumn("Drink Name");
    	model.addColumn("Slot 1");
    	model.addColumn("Slot 2");
    	model.addColumn("Slot 3");
    	model.addColumn("Slot 4");
    	model.addColumn("Slot 5");
    	model.addColumn("Slot 6");
    	model.addColumn("Slot 7");
    	model.addColumn("Slot 8");
    	model.addColumn("Slot 9");
    	model.addColumn("Slot 10");
    	model.addColumn("Slot 11");
    	model.addColumn("Slot 12");
    	model.addColumn("Slot 13");
    	model.addColumn("Slot 14");
    	model.addColumn("Slot 15");
    	
    	table = new JTable(model);
    	table.getColumnModel().getColumn(0).setPreferredWidth(300);

    	table.setBounds(10, 10, 750, 350);
	}

	@Override 
	public void dataReceived(JSONObject object){
        Drink aDrink = new Drink(object);
        queue.add(aDrink);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(aDrink.getObject());
        
        if (!localRobot.busy()){
            localRobot.makeDrink(aDrink.getSlots());
        }
        
	}

    @Override
    public void isHigh(){
        localRobot.makeDrink(aDrink.getSlots());
    }

    @Override
    public void isLow(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
                    queue.remove();
                    model.removeRow(0);
       JOptionPane.showMessageDialog(null, "Please place cup for next Drink"); 
    }
}