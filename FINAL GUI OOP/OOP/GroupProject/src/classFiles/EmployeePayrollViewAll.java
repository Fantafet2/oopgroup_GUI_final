package classFiles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EmployeePayrollViewAll extends EmployeePayroll {

	private JLabel veiwAlMessage;
	private JFrame frame;
	private JButton button;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;

	private int labelCount = 0;
	private int y = 80; 

		
	public EmployeePayrollViewAll() {
		frame = new JFrame("Get All Records");
		
		int x = 50;
		
		
		frame.setBounds(0,0,775,823);
		frame.setPreferredSize(new Dimension(800, 800));		 
		frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		button = new JButton("add label");
		button.setBounds(50,50,190,20);
		//frame.getContentPane().add(button);
		
        JPanel panel = new JPanel();
        
        Scanner scannerRead = null;
		try {
			scannerRead = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String fileLine = "";
        
        JLabel label = new JLabel(scannerRead.nextLine());
		label.setBounds(100,y,400,20);
		panel.add(label);	
		 y += 30;
		 
        frame.getContentPane().add(label);
        
     // Refresh the frame to reflect changes
       frame.revalidate();
       frame.repaint();

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();
            
            JLabel recordlabel = new JLabel(fileLine);
            recordlabel.setBounds(100,y,400,20);
			panel.add(recordlabel);
			
			 y += 30;
			 labelCount += 1;			
			 
            frame.getContentPane().add(recordlabel);
            
         // Refresh the frame to reflect changes
            frame.revalidate();
            frame.repaint();   
        }

        scannerRead.close();
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Scanner scannerRead = null;
				try {
					scannerRead = new Scanner(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        String fileLine = "";
		        
		        JLabel label = new JLabel(scannerRead.nextLine());
				label.setBounds(100,y,400,20);
				panel.add(label);	
				 y += 30;
				 
	            frame.getContentPane().add(label);
	            
	         // Refresh the frame to reflect changes
               frame.revalidate();
               frame.repaint();

		        while (scannerRead.hasNextLine()) {
		            fileLine = scannerRead.nextLine();
		            
		            JLabel recordlabel = new JLabel(fileLine);
		            recordlabel.setBounds(100,y,400,20);
					panel.add(recordlabel);
					
					 y += 30;
					 labelCount += 1;			
					 
		            frame.getContentPane().add(recordlabel);
		            
		         // Refresh the frame to reflect changes
	                frame.revalidate();
	                frame.repaint();   
		        }

		        scannerRead.close();
			}
				
		});
		
		backToMainMenue = new JButton("Main  Menue");
		backToMainMenue.setBounds(50, 550, 130, 20);
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
		backToSelectedMenue.setBounds(210, 550, 180, 20);
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
}
