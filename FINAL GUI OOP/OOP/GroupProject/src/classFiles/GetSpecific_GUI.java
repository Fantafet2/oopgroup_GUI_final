package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class GetSpecific_GUI extends DepartmentRates implements ActionListener{
	
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
	
	public GetSpecific_GUI() {
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

	    if (e.getSource() == submitButton) {
	        String deptCodeInput = deptCodeIn.getText();
	        int num = 0;
	        
	        try {
			    num = Integer.parseInt(deptCodeInput);
				if (num < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
			        intdeptcode = Integer.parseInt(deptCodeInput);
				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.ERROR_MESSAGE);;

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
