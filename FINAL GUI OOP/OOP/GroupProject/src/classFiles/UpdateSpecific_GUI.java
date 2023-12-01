package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;


public class UpdateSpecific_GUI extends DepartmentRates {

	private JFrame frame;
	private JTextField searchCodeIn;
	private JLabel searchCodeLabel;
	
	private JButton submit;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;
	
	public UpdateSpecific_GUI() {
		
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
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String getCode = searchCodeIn.getText();
				 int code = 0;

				try {
					code = Integer.parseInt(getCode);
					if (code < 1) {
				        JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.ERROR_MESSAGE);
		            }
					else {
						deptCode = code;
					}
				}catch(NumberFormatException e1){
			        JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (DepartmentRateStore.containsKey(code)) {
		            //Ask the User For the Updated Department Records
		            Add();
		            frame.dispose();
		            // Iterating over the HashMap
		            try {
						SaveDataToFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }else{
			        JOptionPane.showMessageDialog(null, "No Such User Found", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
			
		});
		
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
		
		backToSelectedMenue = new JButton("Department Rates Menue");
		backToSelectedMenue.setBounds(210, 300, 180, 20);
		frame.getContentPane().add(backToSelectedMenue);
		backToSelectedMenue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Add", "Update", "View Specific", "View All", "Cancel"};
    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

    	        switch (n) {
    	            case 0:
    	    	    	new DepartmentRates().Add();
    	    			frame.dispose();
    	                break;
    	                
    	            case 1:
					try {
						new DepartmentRates().UpdateSpecificRecord();
						frame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 2:
					try {
						new DepartmentRates().getSpecificRecord();
						frame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 3:
					try {
						new DepartmentRates().ViewAllRecord();
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	                
    	                break;
    	                
    	            case 4:
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
}
