package classFiles;
//working on the view all from department 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class GUI extends DepartmentRates{
	
	
	private JFrame frame;
	private JLabel welcomeUserLabel;
	private JLabel test;
	private final String options[] = {"Options","Department Rates","Employee Payroll","Prosseced Payroll","Cancel"};
	private final String departmentOptions[] = {"Add","Update","View Specific","View All","Cancel"};
	private JComboBox<String> optionsCombo;
	
	private final String PayrollOptions[] = {"Options","Department Rates","Employee Payroll","Processed Payroll","Exit"};
	private JComboBox<String> payrollOptionsCombo;
	
	public GUI() throws IOException {
	    new ProcessedPayroll().getAllFileRecords();

		frame = new JFrame("Company Payroll");
		
		frame.setBounds(0,0,775,823);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    try {
			new DepartmentRates().getAllFileRecords();
			new EmployeePayroll().getAllFileRecords();
			new ProcessedPayroll().getAllFileRecords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    welcomeUserLabel= new JLabel("Hello user, what would you like to do today");
	    optionsCombo = new JComboBox<String>(options);
	    
	    frame.add(welcomeUserLabel);
	    frame.add(optionsCombo);

	    welcomeUserLabel.setBounds(50,50,260,20);
	    optionsCombo.setBounds(310, 50, 200, 20);	
	    
	    optionsCombo.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    	    int comboselectedindex = optionsCombo.getSelectedIndex();

	    	    if(comboselectedindex == 1) {
	    	    	String[] options = {"Add", "Update", "View Specific", "View All", "Cancel"};
	    	    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, departmentOptions, null);

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
	    	    
	    	    else if(comboselectedindex == 2) {
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
		    	
	    	    else if(comboselectedindex == 3) {
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
	    	    else if(comboselectedindex == 4) {
                    try {
						new DepartmentRates().ViewAllRecord();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
	    	    
	    	}
	    });
	    
        
	    	

	}
	
}
