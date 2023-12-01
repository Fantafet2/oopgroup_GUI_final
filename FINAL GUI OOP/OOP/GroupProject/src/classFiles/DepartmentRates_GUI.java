package classFiles; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class DepartmentRates_GUI {

	private JFrame frame;
	private JLabel headerLabel;
	private JButton addButton;
	private JButton UpdateButton;
	private JButton SpecificButton;
	private JButton allButton;
	private JButton cancelButton;
	
	DepartmentRates_GUI(){
		System.out.println("it at least gets here");
		frame = new JFrame("Department Rates Options");
	    frame.setBounds(30,30,900,900);
	    frame.setVisible(true);
	    frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		headerLabel = new JLabel("Please select the action you would lik to perform");
		
		addButton = new JButton("Add");
		UpdateButton = new JButton("Update");
		SpecificButton = new JButton("View specifc");
		allButton = new JButton("View All");
		cancelButton = new JButton("Cancel");
		
		headerLabel.setBounds(50,50,200,20);
		addButton.setBounds(50,80,80,20);
		UpdateButton.setBounds(160,50,80,20);
		SpecificButton.setBounds(240,50,80,20);
		allButton.setBounds(320,50,80,20);
		cancelButton.setBounds(400,50,80,20);
		
    	frame.getContentPane().add(headerLabel);
    	frame.getContentPane().add(addButton);
    	frame.getContentPane().add(UpdateButton);
    	frame.getContentPane().add(SpecificButton);
    	frame.getContentPane().add(allButton);
    	frame.getContentPane().add(cancelButton);

	}
}
