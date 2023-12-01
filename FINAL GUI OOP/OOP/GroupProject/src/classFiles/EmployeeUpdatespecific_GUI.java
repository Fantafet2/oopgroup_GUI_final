package classFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeUpdatespecific_GUI extends EmployeePayroll implements ActionListener{
	private JFrame frame;
	private JTextField searchCodeIn;
	private JLabel searchCodeLabel;
	private JButton backToSelectedMenue;
	private JButton backToMainMenue;
	
	private JButton submit;
	
	public EmployeeUpdatespecific_GUI() {
		
		JFrame frame = new JFrame("Update Specific");
		frame.setBounds(0,0,775,823);
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
		
		backToMainMenue = new JButton("Main  Menue");
		backToMainMenue.setBounds(50, 300, 130, 20);
		frame.getContentPane().add(backToMainMenue);
		backToMainMenue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new GUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			frame.dispose();
			}
				
		});
		
		backToSelectedMenue = new JButton("Employee Payroll Menue");
		backToSelectedMenue.setBounds(210, 300, 180, 20);
		frame.getContentPane().add(backToSelectedMenue);
		backToSelectedMenue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] PayrollOptions = {"Add", "Update", "View Specific", "View All", "Delete","Cancel"};
    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, PayrollOptions, null);

    	        switch (n) {
    	            case 0:
    	    	    	new EmployeePayroll().Add();
    	    			frame.dispose();
    	                break;
    	                
    	            case 1:
					try {
						new EmployeePayroll().UpdateSpecificRecord();
    	    			frame.dispose();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 2:
					try {
						new EmployeePayroll().getSpecificRecord();
    	    			frame.dispose();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 3:
					try {
						new EmployeePayroll().ViewAllRecord();
    	    			frame.dispose();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 4:
    	            	try {
							new EmployeePayroll().RemoveSpecificRecord();
	    	    			frame.dispose();

						} catch (Exception e1) {
							e1.printStackTrace();
						}	
    	            	break;
    	            case 5:
    	            	try {
							new GUI();
							frame.dispose();

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    	            	break;
    	            default:
    	                System.out.println("Invalid selection");
    	        }	
			}
				
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = searchCodeIn.getText();
		if(e.getSource() == submit) {
			
			try {
				int idNo = Integer.parseInt(input);
				if (idNo < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid ID entered", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
			        if (EmployeePayrollStore.containsKey(idNo)) {
			        	
			        }				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid ID entered", "Error", JOptionPane.ERROR_MESSAGE);
			}	
		}	
	}
	
	
}
