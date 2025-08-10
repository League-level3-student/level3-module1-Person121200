package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton search;
	JButton display;
	JButton delete;
	HashMap<Integer, String> log;
	String id;
	String name;
	String ask;
	String removeWhich;
	String all;

	public void Setup() {
		frame = new JFrame("Log Search");
		panel = new JPanel();
		addEntry = new JButton("Add Entry");
		all = "";
		
		search = new JButton("Search");
		display = new JButton("Display");
		delete = new JButton("Delete");
		log = new HashMap<Integer, String>();
		frame.add(panel);
		addEntry.addActionListener(this);
		search.addActionListener(this);
		display.addActionListener(this);
		delete.addActionListener(this);
		panel.add(addEntry);
		panel.add(display);
		panel.add(search);
		panel.add(delete);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();

	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == addEntry) {
			id = JOptionPane.showInputDialog("Enter id: ");
			int idasInt = Integer.parseInt(id);
			name = JOptionPane.showInputDialog("Enter name: ");
			log.put(idasInt, name);
		}
		if(arg0.getSource() == display) {
			for(int i : log.keySet()) {
				all +="Name: " +log.get(i) + " ID: " + i + '\n';
			}
			JOptionPane.showMessageDialog(null, all);
		}
		if (arg0.getSource() == search) {
			ask = JOptionPane.showInputDialog("Enter an id to search: ");
			int askAsint = Integer.parseInt(ask);

			
				if (log.containsKey(askAsint)) {
					JOptionPane.showMessageDialog(null, log.get(askAsint));
				} else {
					JOptionPane.showMessageDialog(null, "name can't be found!");
				}
			}
		if(arg0.getSource() == delete) {
			removeWhich = JOptionPane.showInputDialog("Which ID do you want to remove: ");
			int removeasInt = Integer.parseInt(removeWhich);
			if(log.containsKey(removeasInt) == true) {
				log.remove(removeasInt);
				JOptionPane.showMessageDialog(null, removeasInt + " has been removed.");
				all = "";
			}
			else {
				JOptionPane.showMessageDialog(null, "ID does not exist!");
			}
		}
		
		}
	}


