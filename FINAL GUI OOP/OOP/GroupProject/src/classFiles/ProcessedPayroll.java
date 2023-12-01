package classFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.View;

/**
 * ProcessedPayroll
*/

public class ProcessedPayroll extends FileRate{
    //protected double regularPay, overtimePay, grossPay;

    static Scanner scanner = new Scanner(System.in);
    static File file = new File("lib/ProcessedPayrollFile");

    protected int IdNo;

    protected String firstName, lastName, position, payrollDate, chequeNumber;

    protected double hoursWorked, regularPay, overtimePay, grossPay;

    public static HashMap<Integer, ProcessedPayroll> ProcessedPayrollStore = new HashMap<>();

    // Define the format with placeholders for each part
    static String format = "%-15s : %-15s : %-20s : %-20s : %-20s : %-20s : %-20s : %-20s : %-20s : %-20s : %-20s";

    //This is an Default Constructors
    public ProcessedPayroll(){
        IdNo = 1;
        hoursWorked = 1;
        deptCode  = 1;
        firstName = "";
        lastName = "";
        position = "";
        regularPay = 0.0;
        overtimePay = 0.0;
        grossPay = 0.0;
        payrollDate = "12/34/2004";
        chequeNumber = "34549585";
        UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, hoursWorked, regularPay, overtimePay, grossPay, payrollDate, chequeNumber);

    }

    //This is an Pirmary Constructors
    public ProcessedPayroll(int IdNo, String firstName, String lastName, int deptCode, String position, double hoursWorked, double regularPay, double overtimePay, double grossPay, String payrollDate, String chequeNumber){
        this.IdNo = IdNo;
        this.hoursWorked = hoursWorked;
        this.deptCode  = deptCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.regularPay = regularPay;
        this.overtimePay = overtimePay;
        this.grossPay = grossPay;
        this.payrollDate = payrollDate;
        this.chequeNumber = chequeNumber;
        this.UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, hoursWorked, regularPay, overtimePay, grossPay, payrollDate, chequeNumber);
    }

    //This is an Copy Constructors
    public ProcessedPayroll(EmployeePayroll employeePayroll, DepartmentRates newDepartmentRates){
        this.IdNo = employeePayroll.IdNo;
        this.hoursWorked = employeePayroll.hoursWorked;
        this.deptCode  = employeePayroll.deptCode;
        this.firstName = employeePayroll.firstName;
        this.lastName = employeePayroll.lastName;
        this.position = employeePayroll.position;
        this.regularPay = newDepartmentRates.regularRate;
        this.overtimePay = newDepartmentRates.overtimeRate;
        this.grossPay = 0.0;
        this.payrollDate = "";
        this.chequeNumber = "";
        this.UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, hoursWorked, regularPay, overtimePay, grossPay, payrollDate, chequeNumber);
    }

    //Getters and Setters for HoursWorked
    public void setIdNo(int IdNo){
        this.IdNo = IdNo;
    }

    public int getIdNo(){
        return IdNo;
    }
    //Getters and Setters for DeptCode
    public void setfirstName(String firstName){
        this.firstName = firstName;
    }

    public String getfirstName(){
        return firstName;
    }

    //Getters and Setters for DeptCode
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    //Getters and Setters for Position
    public void setPayrollDate(String payrollDate){
        this.payrollDate = payrollDate;
    }

    public String getPayrollDate(){
        return payrollDate;
    }

    //Getters and Setters for Position
    public void setChequeNumber(String chequeNumber){
        this.chequeNumber = chequeNumber;
    }

    public String getChequeNumber(){
        return chequeNumber;
    }

    //Getters and Setters for Position
    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    //Getters and Setters for HoursWorked
    public void sethoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    public double gethoursWorked(){
        return this.hoursWorked;
    }
    //Getters and Setters for RegularRate
     public void setRegularPay(double regularPay){
        this.regularPay = regularPay;
    }

    public double getRegularPay(){
        return this.regularPay;
    }

    //Getters and Setters for OvertimePay
    public void setOvertimePay(double overtimePay){
        this.overtimePay = overtimePay;
    }

    public double getOvertimePay(){
        return overtimePay;
    }

    //Getters and Setters for GrossPay
    public void setGrossPay(double grossPay){
        this.grossPay = grossPay;
    }

    public double GrossPay(){
       return grossPay;
    }
    //Instalzing Class Methods

    public void getAllFileRecords() throws IOException{
        Scanner scannerRead = new Scanner(file);
        String fileLine = "";
        
        scannerRead.nextLine();

        try {
            while (scannerRead.hasNextLine()) {
                fileLine = scannerRead.nextLine();
                
                String[] userData = fileLine.split(":");

                // Trim leading and trailing spaces from each part
                for (int i = 0; i < userData.length; i++) {
                    userData[i] = userData[i].trim();
                }
                
                int userID = Integer.parseInt(userData[0]);
                int userDeptCode = Integer.parseInt(userData[1]);
                String userFname = userData[2];
                String userLname = userData[3];
                String userPosition = userData[4];
                Double HoursWorked = Double.parseDouble(userData[5]);
                Double regularPay = Double.parseDouble(userData[6]);
                Double overtimePay = Double.parseDouble(userData[7]);
                Double grossPay = Double.parseDouble(userData[8]);
                String payrollDate = userData[8];
                String chequeNumber = userData[9];

                ProcessedPayroll newProcessedPayroll = new ProcessedPayroll(userID, userFname, userLname, userDeptCode, userPosition, HoursWorked, regularPay, overtimePay, grossPay, payrollDate, chequeNumber);
                ProcessedPayrollStore.put(userID, newProcessedPayroll);
            }
        }finally{
            if (scannerRead != null) {
                scannerRead.close();
            }
        }   
    }

    public void processPayroll() throws Exception {
    	
        for (Integer key : EmployeePayroll.EmployeePayrollStore.keySet()) {
            EmployeePayroll neweEmployeePayroll = EmployeePayroll.EmployeePayrollStore.get(key);
            
            try {
                if (!DepartmentRates.DepartmentRateStore.containsKey(neweEmployeePayroll.deptCode)) {
                    throw new Exception(neweEmployeePayroll.deptCode + " Couldn't not be Found inside the DepartmentRatesFile");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
                    continue;
            }
            
            DepartmentRates newDepartmentRates = DepartmentRates.DepartmentRateStore.get(neweEmployeePayroll.deptCode);

            ProcessedPayroll newProcessedPayroll = new ProcessedPayroll(neweEmployeePayroll, newDepartmentRates);

            newProcessedPayroll.payrollDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            
            Random rand = new Random();

            for (int i = 0; i < 8; i++) {
            
                newProcessedPayroll.chequeNumber = newProcessedPayroll.chequeNumber + rand.nextInt(10);
            }

            double employeeOvertimePay = 0.0;
            double employeeRegularPay;

            if (neweEmployeePayroll.hoursWorked > 40) {
                double overTimeHours = neweEmployeePayroll.hoursWorked - 40;
                employeeOvertimePay = newDepartmentRates.overtimeRate * overTimeHours;
                employeeRegularPay = newDepartmentRates.regularRate * (neweEmployeePayroll.hoursWorked - overTimeHours);
            }else{
                employeeRegularPay = newDepartmentRates.regularRate * neweEmployeePayroll.hoursWorked;
            }

            newProcessedPayroll.grossPay = employeeOvertimePay + employeeRegularPay;
            
            newProcessedPayroll.UserData = newProcessedPayroll.UserData.format(format, newProcessedPayroll.IdNo, newProcessedPayroll.deptCode, newProcessedPayroll.firstName, newProcessedPayroll.lastName, newProcessedPayroll.position, newProcessedPayroll.hoursWorked, newProcessedPayroll.regularPay, newProcessedPayroll.overtimePay, newProcessedPayroll.grossPay, newProcessedPayroll.payrollDate, newProcessedPayroll.chequeNumber);

            ProcessedPayrollStore.put(newProcessedPayroll.IdNo, newProcessedPayroll);
            
        }
    }

    public void viewSameDepartment(){
        int deptCode = 0;
        
        new ProssedPayrollDepartment();
        /*

        do{
            try {
                //Ask the User For the Department DeptCode
                System.out.print("DeptCode: ");
                deptCode = scanner.nextInt(); scanner.nextLine(); System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (deptCode < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (deptCode < 1);
        
        System.out.println("Id              DeptCode          FirstName              LastName               Position               HoursWorked            RegularRate            OvertimePay            GrossPay               payrollDate             chequeNumber");

        for (Integer key : ProcessedPayrollStore.keySet()) {
            if (ProcessedPayrollStore.get(key).deptCode == deptCode ) {
                System.out.println(ProcessedPayrollStore.get(key));
            }
        }*/
    }

    public void getSpecificRecord() throws IOException{
        int idNo = 0;
        
        new ProsscedPayrollSpecifc_GUI();
       /* do{
            try {
                //Ask the User For their Id Number
                System.out.print("Employee Id Number: ");
                idNo = scanner.nextInt(); scanner.nextLine(); System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (idNo < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (idNo < 1);

        System.out.println("Id              DeptCode          FirstName              LastName               Position               HoursWorked            RegularRate            OvertimePay            GrossPay               payrollDate             chequeNumber");
        
        if (ProcessedPayrollStore.containsKey(idNo)) {
           System.out.println(ProcessedPayrollStore.get(idNo));
        }else{
            System.out.println("No such User Found");
        }*/
    }

    public void SaveDataToFile() throws IOException{
        file.delete();

        if (file.createNewFile()){System.out.println("New ProcessedPayroll File was made");}else{System.out.println("Couldn't create new ProcessedPayroll File");}

        FileWriter fileIn = new FileWriter(file, true);

        fileIn.write("Id              DeptCode          FirstName              LastName               Position               HoursWorked            RegularRate            OvertimePay            GrossPay               payrollDate             chequeNumber\n");

        // Iterating over the HashMap
        try {
            for (Integer key : ProcessedPayrollStore.keySet()) {
                ProcessedPayroll reWriteData = ProcessedPayrollStore.get(key);
                fileIn.write(reWriteData.UserData + "\n");
            }
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Could not write to file, " + e);
        }
        finally{
            fileIn.close();
        }

    }

    public void Display(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(UserData);
        System.out.println("------------------------------------------------------------------------------");
    }
    
    public String toString() {
        // TODO Auto-generated method stub
        return this.UserData;
    }

	
}
