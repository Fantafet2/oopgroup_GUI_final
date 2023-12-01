package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Deptcode_GUI extends DepartmentRates implements ActionListener{
	
	private JTextField deptCodeIn;
	private JLabel deptCodeframe;
	private JTextField deptNameIn;
	private JLabel deptNameframe;
	private JTextField regularRateIn;
	private JLabel regularRateframe;
	private JTextField overtimeRateIn;
	private JLabel overtimeRateframe;
	
	private JButton submitButton;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;
	
	private int intsetdeptcode;
	private int intdeptcode;
	private String deptNameIninput;
	private double dubRegularRateIn;
	private double dubOvertimeIn;
	
	private JFrame frame;
	
	
	public Deptcode_GUI(int deptCode, String deptName, double regularRate, double overtimeRate) {
		
		super(deptCode, deptName, regularRate, overtimeRate);
		
		frame = new JFrame("Department Rates");
		
		deptCodeIn = new JTextField();
		deptCodeframe = new JLabel("Enter the department code: ");
		
		deptNameIn = new JTextField();
		deptNameframe = new JLabel("Enter the department name: ");
		
		regularRateIn = new JTextField();
		regularRateframe = new JLabel("Enter the regular rate: ");

		overtimeRateIn = new JTextField();
		overtimeRateframe = new JLabel("Enter the overtime rate: ");

		submitButton = new JButton("Submit");
		
		frame.setBounds(0,0,775,823);
		frame.setPreferredSize(new Dimension(800, 800));		 	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		deptCodeframe.setBounds(50,50,190,20);
		deptCodeIn.setBounds(230,50,150,20);
		
		deptNameframe.setBounds(50,80,190,20);
		deptNameIn.setBounds(230,80,150,20);
		
		regularRateframe.setBounds(50,110,190,20);
		regularRateIn.setBounds(230,110,150,20);
		
		overtimeRateframe.setBounds(50,140,190,20);
		overtimeRateIn.setBounds(230,140,150,20);
		
		submitButton.setBounds(120, 200, 90, 20);
		
		frame.getContentPane().add(deptCodeIn);
		frame.getContentPane().add(deptCodeframe);
		frame.getContentPane().add(deptNameIn);
		frame.getContentPane().add(deptNameframe);
		frame.getContentPane().add(regularRateframe);
		frame.getContentPane().add(regularRateIn);
		frame.getContentPane().add(overtimeRateframe);
		frame.getContentPane().add(overtimeRateIn);
		
		frame.getContentPane().add(submitButton);


		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel();
        int y = 50;

		if(e.getSource()== submitButton) {
			String deptCodeIninput = deptCodeIn.getText();
			
			try {
				if (!(deptCodeIninput instanceof String)) {
				    throw new NumberFormatException("deptCodeIninput is not a string");
				}
				
			    int num = Integer.parseInt(deptCodeIninput);
				deptCode = num;
				if (num < 1) {
			        JOptionPane.showMessageDialog(null, "The Department Code you entered is invalid", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Depearment Codes are Integers Only", "Error", JOptionPane.ERROR_MESSAGE);


                System.out.println("Option Not Vaild please try again");

			}
						
			deptNameIninput = deptNameIn.getText();
			deptName = deptNameIninput;
			
			String getratein = regularRateIn.getText();

			try {
			    double num = Double.parseDouble(getratein);
				if (num < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid Regular rate entered", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				    regularRate = num;
				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Rate Should be a monitary value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			String getovertime = overtimeRateIn.getText();
			
			try {
				double num = Double.parseDouble(getovertime);
					overtimeRate = num;
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid Entry for Overtime", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
			
			
			DepartmentRates department = new DepartmentRates(deptCode, deptName, regularRate, overtimeRate);
			System.out.println("======================");
			System.out.println(DepartmentRateStore);
			System.out.println("\n++++++++++++++++++++++");

	        DepartmentRateStore.put(department.deptCode, department);
			System.out.println("\n"+DepartmentRateStore);

			try {
				new DepartmentRates().SaveDataToFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	
	}
	
	private void performActionBeforeExit() throws IOException {
        // Perform actions before exiting the application
        System.out.println("Performing action before exit...");
        // Add your custom actions here
        new DepartmentRates().SaveDataToFile();

        // For example, simulating some cleanup or saving operation
        // File operations, database closing, etc.
    }

}
