import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


interface ClientSocketDelegate{
  void dataReceived(JSONObject object);
}
public class GUI implements ClientSocketDelegate{
	private JFrame frame;
	String[] columnNames = {"Random shit"};
	Object[][] data = {
    {"Kathy"}
    };
    JTable table;
	public GUI(ClientSocket socket){
		socket.delegate = this;
		frame = new JFrame("Bartending Robot");
    	frame.setSize(800, 500);
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

    	

    	table.setBounds(10, 10, 750, 400);
    	frame.add(table);
    	frame.setLayout(null);
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	    

	}

	@Override 
	public void dataReceived(JSONObject object){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{object.get("drinkName"), object.get("slot1"), object.get("slot2"), object.get("slot3"), object.get("slot4"), object.get("slot5"), object.get("slot6"), object.get("slot7"), object.get("slot8"), object.get("slot9"), object.get("slot10"), object.get("slot11"), object.get("slot12"), object.get("slot13"), object.get("slot14"), object.get("slot15")});
	}
}