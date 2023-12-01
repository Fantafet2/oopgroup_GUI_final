package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class EmployeePayrollSpecific_GUI extends EmployeePayroll implements ActionListener {
	private JTextField deptCodeIn;
	private JLabel deptCodeframe;
	
	private JLabel deptcodeLabel;
	private JLabel deptcodeInfo;
	
	private JLabel deptnameLabel;
	private JLabel deptnameinfo;
	
	private JLabel  regularRateLabel;
	private JLabel regularRateInfo;
	
	private JLabel overtimeLabel;
	private JLabel overtimeInfo;
	
	public JButton submitButton;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;

	private JFrame frame;
	
	private int intdeptcode;
	
	public EmployeePayrollSpecific_GUI() {
		frame = new JFrame("Get Specific Record");
		
		deptCodeIn = new JTextField();
		deptCodeframe = new JLabel("Enter the department code: ");
		
		deptcodeLabel = new JLabel("Department Code");

		submitButton = new JButton("Submit");
		
		frame.setBounds(0,0,775,823);
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		 
		deptCodeframe.setBounds(50,50,190,20);
		deptCodeIn.setBounds(200,50,150,20);
		
        deptcodeLabel.setBounds(50, 250, 190, 20);
		
		submitButton.setBounds(120, 200, 90, 20);
		
		frame.getContentPane().add(deptCodeIn);
		
		frame.getContentPane().add(deptCodeframe);
		
		frame.getContentPane().setLayout(null); // Set the layout of the content pane

		frame.getContentPane().add(submitButton);
		
		submitButton.addActionListener(this);

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
	
	public void actionPerformed(ActionEvent e) {
		
        JPanel panel = new JPanel();

	    if (e.getSource() == submitButton) {
	        String deptCodeInput = deptCodeIn.getText();
	        try {
		        intdeptcode = Integer.parseInt(deptCodeInput);
				if (intdeptcode < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid Department Code entered", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
			        if (EmployeePayrollStore.containsKey(intdeptcode)) {
			        	
			        }				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid Department Code entered", "Error", JOptionPane.ERROR_MESSAGE);
			}

			Scanner scannerRead = null;

	        try {
				scannerRead = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
	        String fileLine = "";
	        
	        JLabel label = new JLabel(scannerRead.nextLine());
			label.setBounds(100,80,400,20);
			panel.add(label);
			
			frame.getContentPane().add(label);
	            
	         // Refresh the frame to reflect changes
               frame.revalidate();
               frame.repaint();
               
               while (scannerRead.hasNextLine()) {
                   fileLine = scannerRead.nextLine();

                   int userId = Integer.parseInt(fileLine.substring(0, 4)); 

                   if (userId == intdeptcode) {
                       JLabel specificRecord = new JLabel(fileLine);
                       
                       specificRecord.setBounds(100,120,400,20);
	           			panel.add(specificRecord);
	           			
	           			frame.getContentPane().add(specificRecord);
	           	            
	           	         // Refresh the frame to reflect changes
                          frame.revalidate();
                          frame.repaint();
                       break;
                   }
               }
               
               scannerRead.close();

	    }
	}

}
