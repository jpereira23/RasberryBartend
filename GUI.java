import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Queue; 
import java.util.LinkedList;


interface ClientSocketDelegate{
  void dataReceived(JSONObject object);
}
public class GUI implements ClientSocketDelegate{
	private JFrame frame;
    private JTable table;
    private Queue<Drink> queue;
    private JButton pop;
    private Robot localRobot;
	public GUI(ClientSocket socket, Robot robot){
		socket.delegate = this;
		queue = new LinkedList<>();
		frame = new JFrame("Bartending Robot");
    	frame.setSize(800, 450);
    	makeTable();
    	makeButton();
    	frame.add(table);
    	frame.add(pop);
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

	private void makeButton(){

		//pop = new JButton("Simulate Drink Done");
		pop.setBounds(100, 400, 150, 20);

		pop.addActionListener(new ActionListener() {

			@Override 
			public void actionPerformed(ActionEvent e){

                if(!localRobot.busy()){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
    				queue.remove();
    				model.removeRow(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Robot is making drink, be patient");
                }

			}
		});
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
}