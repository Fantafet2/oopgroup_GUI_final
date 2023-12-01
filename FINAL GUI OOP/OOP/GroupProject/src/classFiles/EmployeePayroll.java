package classFiles;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * EmployeePayroll
*/

public class EmployeePayroll extends FileRate{ 
    static Scanner scanner = new Scanner(System.in);
    static File file = new File("lib/EmployeePayrollFile");

    protected int IdNo;

    protected String firstName, lastName, position, TRN, NIS, DOB, employeeHiredDate;

    protected double hoursWorked;

    public static HashMap<Integer, EmployeePayroll> EmployeePayrollStore = new HashMap<>();
    // Define the format with placeholders for each part
    String format = "%-15s : %-12s : %-20s : %-20s : %-20s : %-20s : %-20s : %-20s : %-25s : %-15s";

    //This is an Default Constructors
    public EmployeePayroll(){
        IdNo = 0;
        deptCode = 0; 
        firstName = "";
        lastName = "";
        position = ""; 
        TRN = "000-000-000"; 
        NIS = "PC-00-00-00-C";
        DOB = "12/34/2004";
        hoursWorked = 0;
        employeeHiredDate = "12/34/2004";
        UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, TRN, NIS, DOB, employeeHiredDate, hoursWorked);
    }

    //This is an Pirmary Constructors
    public EmployeePayroll(int IdNo, String firstName, String lastName, int deptCode, String position, String TRN, String NIS, String DOB, String employeeHiredDate,double hoursWorked){
        this.IdNo = IdNo;
        this.deptCode = deptCode; 
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position; 
        this.TRN = TRN; 
        this.NIS = NIS;
        this.DOB = DOB;
        this.employeeHiredDate = employeeHiredDate;
        this.hoursWorked = hoursWorked;
        this.UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, TRN, NIS, DOB, employeeHiredDate, hoursWorked);
    }
    
    //This is an Copy Constructors
    public EmployeePayroll(EmployeePayroll employeePayroll){
        this.IdNo = employeePayroll.IdNo;
        this.deptCode = employeePayroll.deptCode; 
        this.firstName = employeePayroll.firstName;
        this.lastName = employeePayroll.lastName;
        this.position = employeePayroll.position; 
        this.TRN = employeePayroll.TRN; 
        this.NIS = employeePayroll.NIS;
        this.DOB = employeePayroll.DOB;
        this.employeeHiredDate = employeePayroll.employeeHiredDate;
        this.hoursWorked = employeePayroll.hoursWorked;
        this.UserData = UserData.format(format, IdNo, deptCode, firstName, lastName, position, TRN, NIS, DOB, employeeHiredDate, hoursWorked);
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

    //Getters and Setters for DOB
    public void setDOB(String DOB){
        this.DOB = DOB;
    }
    
    public String getDOB(){
        return DOB;
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

    //Getters and Setters for TRN
     public void setTRN(String TRN){
        this.TRN = TRN;
    }

    public String getTRN(){
        return TRN;
    }

    //Getters and Setters for NIS
    public void setNIS(String NIS){
        this.NIS = NIS;
    }

    public String getNIS(){
        return NIS;
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

                String userTRN = userData[5];

                String userNIS = userData[6];

                String userDOB = userData[7];

                String userEHD = userData[8];

                Double HoursWorked = Double.parseDouble(userData[9]);

                EmployeePayroll newdEmployeePayroll = new EmployeePayroll(userID, userFname, userLname, userDeptCode, userPosition, userTRN, userNIS, userDOB, userEHD, HoursWorked);
                
                EmployeePayrollStore.put(userID, newdEmployeePayroll);
            }
        }finally{
            if (scannerRead != null) {
                scannerRead.close();
            }
        }   
    }
    
    public void SaveDataToFile() throws IOException{
        file.delete();

        if (file.createNewFile()){System.out.println("New Employee File was made");}else{System.out.println("Couldn't create new Employee File");}

        FileWriter fileIn = new FileWriter(file, true);

        fileIn.write("Id              DeptCode       FirstName              LastName               Position               TRN                    NIS                    DOB                    Employee Hired Date         HoursWorked\n");

        // Iterating over the HashMap
        try {
            for (Integer key : EmployeePayrollStore.keySet()) {
                EmployeePayroll reWriteData = EmployeePayrollStore.get(key);
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

    public void ViewAllRecord() throws IOException {
        //System.out.println("Id              DeptCode            FirstName              LastName               Position               HoursWorked");
        // Iterating over the HashMap
    	new EmployeePayrollViewAll();
    	/*
        Scanner scannerRead = new Scanner(file);
        String fileLine = "";

        System.out.println(scannerRead.nextLine());

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();
            System.out.println(fileLine);    
        }

        scannerRead.close();*/
    }  

    public void viewSameDepartment() throws IOException{
        //Ask the User For the Department DeptCode
    	
    	new EmployeePayrollViewSpecific_GUI();
        System.out.print("DeptCode: ");
        int deptCode = scanner.nextInt(); scanner.nextLine(); System.out.println();

        Scanner scannerRead = new Scanner(file);
        String fileLine = "";
        
        System.out.println(scannerRead.nextLine());

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();

            String[] userData = fileLine.split(":");

            // Trim leading and trailing spaces from each part
            for (int i = 0; i < userData.length; i++) {
                userData[i] = userData[i].trim();
            }

            int userId = Integer.parseInt(userData[1]); 

            if (userId == deptCode) {
                System.out.println(fileLine);    
                break;
            }
        }

        scannerRead.close();
    }
    

    public void getSpecificRecord() throws IOException{
        int idNo = 0;
        
        new EmployeePayrollSpecific_GUI();

        /*do{
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

        Scanner scannerRead = new Scanner(file);
        String fileLine = "";

        System.out.println(scannerRead.nextLine());

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();

            int userId = Integer.parseInt(fileLine.substring(0, 4)); 

            if (userId == idNo) {
                System.out.println(fileLine);    
                break;
            }
        }

        scannerRead.close();*/
    }

    public void UpdateSpecificRecord() throws IOException{
        int idNo = 0;
        
        new EmployeeUpdatespecific_GUI();
/*
        do{
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
        
        if (EmployeePayrollStore.containsKey(idNo)) {
            //Ask the User For the Updated Department Records
            Add();
            // Iterating over the HashMap
            SaveDataToFile();
        }else{
            System.out.println("No such User Found");
        }*/
    }

    public void RemoveSpecificRecord()throws Exception{
       int idNo = 0;

       new EmployeePayrollRemove_GUI();
       /*
        do{
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

        if (EmployeePayrollStore.containsKey(idNo)) {
            ProcessedPayroll.ProcessedPayrollStore.remove(idNo);
            EmployeePayrollStore.remove(idNo);
            SaveDataToFile();
        }else{
            System.out.println("No such User Found");
        }*/
    }

    public void Add(){
       new EmployeePayrollAdd_GUI();
       /*
        int idNo = 0;

        do{
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

        //Ask the User For their FirstName
        System.out.print("FirstName: ");
        String firstName = scanner.nextLine(); System.out.println();

        //Ask the User For their LastName
        System.out.print("LastName: ");
        String lastName = scanner.nextLine(); System.out.println();

        int deptCode = 0;
        
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

        //Ask the User For their Position
        System.out.print("Position: ");
        String Position = scanner.nextLine(); System.out.println();

        //Ask the User For their Position
        System.out.print("TRN: ");
        String trn = scanner.nextLine(); System.out.println();

        //Ask the User For their Position
        System.out.print("NIS: ");
        String nis = scanner.nextLine(); System.out.println();

        //Ask the User For their Position
        System.out.print("DOB: ");
        String dob = scanner.nextLine(); System.out.println();

        //Ask the User For their Position
        System.out.print("Employee Hired Date: ");
        String EHD = scanner.nextLine(); System.out.println();

        double HoursWorked = 0.0;

        do{
            try {
                //Ask the User For their HoursWorked
                System.out.print("HoursWorked ");
                HoursWorked = scanner.nextDouble(); scanner.nextLine();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (HoursWorked < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (HoursWorked < 1);

        System.out.println("------------------------------------------------------------------------------");

        EmployeePayroll employeePayroll = new EmployeePayroll(idNo, firstName, lastName, deptCode, Position, trn, nis, dob, EHD, HoursWorked);

        EmployeePayrollStore.put(employeePayroll.IdNo, employeePayroll);
*/    }

    public void Display(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(UserData);
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.UserData;
    }

}
