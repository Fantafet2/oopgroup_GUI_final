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
import javax.swing.JTextField;

public class ProssedPayrollDepartment extends ProcessedPayroll{

	private JLabel veiwAlMessage;
	private JFrame frame;
	private JTextField input;
	private JButton button;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;

	private int labelCount = 0;
	private int y = 80; 

		
	public ProssedPayrollDepartment() {
		frame = new JFrame("Get All Records");
		
		int x = 50;
		
		
		frame.setBounds(0,0,775,823);
		frame.setPreferredSize(new Dimension(800, 800));		 
		frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		input = new JTextField();
		input.setBounds(50,50,100,20);

		
		button = new JButton("add label");
		button.setBounds(50,50,190,20);
		frame.getContentPane().add(button);
		
        JPanel panel = new JPanel();
		
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
		            
		            JLabel recordlabel = new JLabel(scannerRead.nextLine());
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
		
		backToSelectedMenue = new JButton("Process Payroll Menue");
		backToSelectedMenue.setBounds(210, 300, 180, 20);
		frame.getContentPane().add(backToSelectedMenue);
		backToSelectedMenue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] PayrollOptions = {"Process Payroll", "View Specific records", "View Department", "Cancel"};
    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, PayrollOptions, null);

    	        
    	        switch (n) {
    	            case 0:
					try {
						new ProcessedPayroll().processPayroll();
					    JOptionPane.showMessageDialog(frame, "The Payrolls have been proccessed.", "Payroll Status", JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
					    JOptionPane.showMessageDialog(frame, "There was an error processing the payrolls.", "Payroll Status", JOptionPane.INFORMATION_MESSAGE);
					}
    	                break;
    	                
    	            case 1:
					try {
						new ProcessedPayroll().getSpecificRecord();
    	    			frame.dispose();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
    	                break;
    	                
    	            case 2:
					new ProcessedPayroll().viewSameDepartment();
	    			frame.dispose();

    	                break;
    	                
    	            case 3:
    	            	try {
							new GUI();
							frame.dispose();

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	    	                break;
    	                
    	            default:
    	                System.out.println("Invalid selection");
    	        }
			}
				
		});
	}
}
