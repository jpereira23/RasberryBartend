import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*; 


public class CreateDrinkPage{
	private JTable table;
	private JFrame mainFrame;
	public JButton doneButton;
	private JButton addButton;
	private JTextField nameField; 
	private JLabel headerLabel;
	private JLabel subHeaderLabel; 
	public CreateDrinkPage(){
		doneButton = new JButton("Done");
		doneButton.setBounds(50, 380, 100, 50); 

		addButton = new JButton("Add Alc");
		addButton.setBounds(50, 110, 100, 50); 



		nameField = new JTextField();
		nameField.setBounds(50, 60, 100, 50); 
		headerLabel = new JLabel("Enter Name"); 
		headerLabel.setBounds(50, 5, 100, 50);
		createTable();
		JScrollPane contentPanel = new JScrollPane(table);
		contentPanel.setBounds(0, 175, 200, 190); 


		mainFrame = new JFrame(); 
		mainFrame.setBounds(300, 25, 200, 430);

		mainFrame.add(doneButton); 
		mainFrame.add(nameField);
		mainFrame.add(headerLabel); 
		mainFrame.add(contentPanel);
		mainFrame.add(addButton);

		mainFrame.setUndecorated(true);
		mainFrame.setLayout(null);
	}

	public void displayPopUp(){
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
    	//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    	doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				mainFrame.dispose();
			}
		});
	}

	private void createTable(){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mixer/Alcohol"); 

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Object obj[][] = {
					{"Honey Badger", ""}
				};
				model.addRow(obj[0]);
			}
		});	
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		setUpAlcMixerColumn(table, table.getColumnModel().getColumn(0));
		table.setBounds(0, 0, 300, 200);
	}

	private void setUpAlcMixerColumn(JTable table, TableColumn alcMixer){
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Honey Badger");
		comboBox.addItem("King Blues Tonic");
		comboBox.addItem("Bettys Ecstasy");
		
		alcMixer.setCellEditor(new DefaultCellEditor(comboBox));

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click For Combo Box");
		alcMixer.setCellRenderer(renderer);
	
	}



}