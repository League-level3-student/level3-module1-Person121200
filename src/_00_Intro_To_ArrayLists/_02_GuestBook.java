package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton addName;
	JButton viewName;
	ArrayList<String> names;
	String result;
	String s;
	
	_02_GuestBook(){
		setup();
	}

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		addName = new JButton("ADD NAME");
		viewName = new JButton("VIEW NAME");
		names = new ArrayList<String>();
		
		frame.add(panel);
		panel.add(addName);
		panel.add(viewName);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addName.addActionListener(this);
		viewName.addActionListener(this);
		frame.pack();

	}
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		s = "";
		if(addName == arg0.getSource()) {
			String input = JOptionPane.showInputDialog("Add a name please: ");
			names.add(input);
		}
		if(viewName == arg0.getSource()) {
			 for(int i = 0; i<names.size(); i++) {
				s += "Guest #"+ i + ": "+names.get(i) + '\n';


			 }
			JOptionPane.showMessageDialog(null, s);
		}
	}



}
