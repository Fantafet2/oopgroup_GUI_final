package classFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeePayrollAdd_GUI extends EmployeePayroll implements ActionListener{
	private JFrame frame;
	
	private JLabel idInLabel;
	private JTextField idInput;
	
	private JLabel firstInLabel;
	private JTextField firstInput;
	
	private JLabel lastInLabel;
	private JTextField lastInput;

	private JLabel deptcodeInLabel;
	private JTextField deptcodeInput;
	
	private JLabel positionInLabel;
	private JTextField positionInput;
	
	private JLabel trnInLabel;
	private JTextField trnInput;
	
	private JLabel nisInLabel;
	private JTextField nisInput;
	
	private JLabel dobInLabel;
	private JTextField dobInput;
	
	private JLabel hireDateInLabel;
	private JTextField hireDateInput;
	
	private JLabel hoursWorkedInLabel;
	private JTextField hoursWorkedInput;
	
	private JButton submit;
	private JButton backToMainMenue;
	private JButton backToSelectedMenue;
	
	public EmployeePayrollAdd_GUI() {
		frame = new JFrame("Add Employee to Payroll");
		frame.setBounds(0,0,775,823);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		idInLabel = new JLabel("Enter ID#: ");
		idInput = new JTextField();
		idInLabel.setBounds(50,50,240,20);
		idInput.setBounds(250,50,90,20);
		
		firstInLabel = new JLabel("Enter First Name: ");
		firstInput = new JTextField();
		firstInLabel.setBounds(50,80,240,20);
		firstInput.setBounds(250,80,90,20);
		
		lastInLabel = new JLabel("Enter Last Name: ");
		lastInput = new JTextField();
		lastInLabel.setBounds(50,110,240,20);
		lastInput.setBounds(250,110,90,20);
		
		deptcodeInLabel = new JLabel("Enter Department Code: ");
		deptcodeInput = new JTextField();
		deptcodeInLabel.setBounds(50,140,240,20);
		deptcodeInput.setBounds(250,140,90,20);
		
		positionInLabel = new JLabel("Enter Positon held: ");
		positionInput = new JTextField();
		positionInLabel.setBounds(50,170,240,20);
		positionInput.setBounds(250,170,90,20);
		
		trnInLabel = new JLabel("Enter TRN#: ");
		trnInput = new JTextField();
		trnInLabel.setBounds(50,200,240,20);
		trnInput.setBounds(250,200,90,20);
		
		nisInLabel = new JLabel("Enter NIS#: ");
		nisInput = new JTextField();
		nisInLabel.setBounds(50,230,240,20);
		nisInput.setBounds(250,230,90,20);
		
		dobInLabel = new JLabel("Enter Date of Birth: ");
		dobInput = new JTextField();
		dobInLabel.setBounds(50,260,240,20);
		dobInput.setBounds(250,260,90,20);
		
		hireDateInLabel = new JLabel("Enter Date of Hire: ");
		hireDateInput = new JTextField();
		hireDateInLabel.setBounds(50,290,240,20);
		hireDateInput.setBounds(250,290,90,20);
		
		hoursWorkedInLabel = new JLabel("Enter Amount of hours worked: ");
		hoursWorkedInput = new JTextField();		
		hoursWorkedInLabel.setBounds(50,320,240,20);
		hoursWorkedInput.setBounds(250,320,90,20);
		
		submit = new JButton("submit");
		submit.setBounds(80,350,90,20);
		
		frame.getContentPane().add(idInLabel);
		frame.getContentPane().add(idInput);
		frame.getContentPane().add(firstInLabel);
		frame.getContentPane().add(firstInput);
		frame.getContentPane().add(lastInLabel);
		frame.getContentPane().add(lastInput);
		frame.getContentPane().add(deptcodeInLabel);
		frame.getContentPane().add(deptcodeInput);
		frame.getContentPane().add(positionInLabel);
		frame.getContentPane().add(positionInput);
		frame.getContentPane().add(trnInLabel);
		frame.getContentPane().add(trnInput);
		frame.getContentPane().add(nisInLabel);
		frame.getContentPane().add(nisInput);
		frame.getContentPane().add(dobInLabel);
		frame.getContentPane().add(dobInput);
		frame.getContentPane().add(hireDateInput);
		frame.getContentPane().add(hireDateInLabel);
		frame.getContentPane().add(hoursWorkedInLabel);
		frame.getContentPane().add(hoursWorkedInput);
		frame.getContentPane().add(submit);
		
		submit.addActionListener(this);
		
		backToMainMenue = new JButton("Main  Menue");
		backToMainMenue.setBounds(50, 500, 130, 20);
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
		backToSelectedMenue.setBounds(210, 500, 180, 20);
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

		if(e.getSource()==submit) {
			String getId = idInput.getText();
			
			try {
			    int num = Integer.parseInt(getId);
				if (IdNo < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid ID entered", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					IdNo = num;
				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid ID entered", "Error", JOptionPane.ERROR_MESSAGE);
			}
						
			firstName = firstInput.getText();
			lastName = lastInput.getText();
			
			String getdeptcode = deptcodeInput.getText();
			try {
			    int num = Integer.parseInt(getdeptcode);
				if (num < 1) {
			        JOptionPane.showMessageDialog(null, "Invalid Department Code entered", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					deptCode = num;
				}
			} catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Invalid Department Code entered", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			position = positionInput.getText();
			TRN = trnInput.getText();
			NIS = nisInput.getText();
			DOB = dobInput.getText();
			employeeHiredDate = hireDateInput.getText();
			
			String getHours = hoursWorkedInput.getText();
			hoursWorked = Double.parseDouble(getHours);
					
			EmployeePayroll employeePayroll = new EmployeePayroll(IdNo, firstName, lastName, deptCode, position, TRN, NIS, DOB, employeeHiredDate, hoursWorked);
	        EmployeePayrollStore.put(employeePayroll.IdNo, employeePayroll);
	        
	        try {
				new EmployeePayroll().SaveDataToFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}
	}
}
