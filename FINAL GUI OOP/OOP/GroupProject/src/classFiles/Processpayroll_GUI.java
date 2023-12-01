package classFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Processpayroll_GUI extends ProcessedPayroll implements ActionListener{
	private JFrame frame;
	private JTextField searchCodeIn;
	private JLabel searchCodeLabel;
	
	private JButton submit;
	
	public Processpayroll_GUI() {
		
		JFrame frame = new JFrame("Update Specific");
		frame.setBounds(30,30,900,900);
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		searchCodeIn = new JTextField();
		searchCodeLabel = new JLabel("Enter the code for the record you want to update");
		submit = new JButton("Submit");
		
		searchCodeIn.setBounds(370,50,80,20);
		searchCodeLabel.setBounds(50,50,290,20);
		submit.setBounds(50,80,80,20);
		
		frame.getContentPane().add(searchCodeIn);
		frame.getContentPane().add(searchCodeLabel);
		frame.getContentPane().add(submit);
		
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		submit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
