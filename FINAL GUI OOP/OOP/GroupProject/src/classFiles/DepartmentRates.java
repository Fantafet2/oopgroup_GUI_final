package classFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * DepartmentRates
*/

public class DepartmentRates extends FileRate {
    static Scanner scanner = new Scanner(System.in);
    static File file = new File("lib/DepartmentRatesFile");

    public static HashMap<Integer, DepartmentRates> DepartmentRateStore = new HashMap<>();

    // Define the format with placeholders for each part
    String format = "%-15s : %-20s : %-20s : %-15s";

    protected String deptName;

    protected double regularRate, overtimeRate;

    //This is an Default Constructors
    public DepartmentRates(){
        deptCode = 0;
        deptName = "";
        regularRate = 0.0;
        overtimeRate = 0.0;
        //UserData = deptCode + ":" + deptName + ":" + regularRate + ":" + overtimeRate;
        UserData = UserData.format(format, deptCode, deptName, regularRate, overtimeRate);
    }
    
    //This is an Pirmary Constructors
    public DepartmentRates(int deptCode, String deptName, double regularRate, double overtimeRate){
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.regularRate = regularRate;
        this.overtimeRate = overtimeRate;
        //this.UserData = deptCode  + deptName + regularRate + overtimeRate;
        this.UserData = UserData.format(format, deptCode, deptName, regularRate, overtimeRate);
    }

    //This is an Copy Constructors
    public DepartmentRates(DepartmentRates departmentRates){
        this.deptCode = departmentRates.deptCode;
        this.deptName = departmentRates.deptName;
        this.regularRate = departmentRates.regularRate;
        this.overtimeRate = departmentRates.overtimeRate;
        //this.UserData = deptCode + ":" + deptName + ":" + regularRate + ":" + overtimeRate;
        this.UserData = UserData.format(format, deptCode, deptName, regularRate, overtimeRate);
    }
    

    //Getters and Setters for RegularRate
    public void setRegularRate(double regularRate){
        this.regularRate = regularRate;
    }

    public double getRegularRate(){
        return this.regularRate;
    }

    //Getters and Setters for OvertimeRate
    public void setOvertimeRate(double overtimeRate){
        this.overtimeRate = overtimeRate;
    }

    public double getOvertimeRate(){
        return this.overtimeRate;
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

                int userDeptCode = Integer.parseInt(userData[0]);
                String userName = userData[1];
                Double userRegularRate = Double.parseDouble(userData[2]);
                Double userOverRate = Double.parseDouble(userData[3]);

                DepartmentRates newdDepartmentRates = new DepartmentRates(userDeptCode,userName,userRegularRate,userOverRate);
                DepartmentRateStore.put(userDeptCode, newdDepartmentRates);
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }finally{
            scannerRead.close();
        }   
    }

    @Override
    public void SaveDataToFile() throws IOException{
        file.delete();

        if (file.createNewFile()){System.out.println("New DepartmentRates File was made");}else{System.out.println("Couldn't create new DepartmentRates File");}

        FileWriter fileIn = new FileWriter(file, true);

        fileIn.write("DeptCode        DeptName               RegularRate             overtimeRate\n");
        // Iterating over the HashMap
        try {
            for (Integer key : DepartmentRateStore.keySet()) {
                DepartmentRates reWriteData = DepartmentRateStore.get(key);
                fileIn.write(reWriteData.UserData + "\n");
            }
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Could not write to file, " + e);
        }
        finally{
            fileIn.close();
        }
        System.out.println("the record has been saved");

    }

    @Override
    public void viewSameDepartment() throws IOException {
        // TODO Auto-generated method stub
        
    }

    public void ViewAllRecord() throws IOException{
        //System.out.println("DeptCode        DeptName               RegularRate             overtimeRate");
        // Iterating over the HashMap
       
    	new ViewAll_GUI();

    	/*Scanner scannerRead = new Scanner(file);
        String fileLine = "";

        System.out.println(scannerRead.nextLine());

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();
            System.out.println(fileLine);    
        }

        scannerRead.close();*/
    }
    
    @Override
    public void getSpecificRecord() throws IOException{
        
    	new GetSpecific_GUI();
    	
    	/*int code = 0;

        do{
            try {
                //Ask the User For the Department DeptCode
                System.out.print("DeptCode: ");
                code = scanner.nextInt(); scanner.nextLine(); System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (code < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (code < 1);


        Scanner scannerRead = new Scanner(file);
        String fileLine = "";

        System.out.println(scannerRead.nextLine());

        while (scannerRead.hasNextLine()) {
            fileLine = scannerRead.nextLine();

            int userId = Integer.parseInt(fileLine.substring(0, 4)); 

            if (userId == code) {
                System.out.println(fileLine);    
                break;
            }
        }
        
        scannerRead.close();*/
    }

    public void UpdateSpecificRecord() throws IOException{
        int code = 0;
        
        new UpdateSpecific_GUI();

        /*do{
            try {
                //Ask the User For the Department DeptCode
                System.out.print("DeptCode: ");
                code = scanner.nextInt(); scanner.nextLine(); System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (code < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (code < 1);

        
        if (DepartmentRateStore.containsKey(code)) {
            //Ask the User For the Updated Department Records
            Add();
            // Iterating over the HashMap
            SaveDataToFile();
        }else{
            System.out.println("No such User Found");
        }*/
    }

    public void Add(){
        System.out.println("------------------------------------------------------------------------------");

        int deptCode = 0;
        new Deptcode_GUI(deptCode,deptName, regularRate, overtimeRate);
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

        //Ask the User For the Department DeptName
        System.out.print("DeptName: ");
        String deptName = scanner.nextLine(); System.out.println();

        double regularRate = 0.0;

        do{
            try {
                //Ask the User For the Department RegularRate
                System.out.print("RegularRate: ");
                regularRate = scanner.nextDouble(); scanner.nextLine(); System.out.println();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (regularRate < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (regularRate < 1);

        double overtimeRate = 0.0;

        do{
            try {
                //Ask the User For the Department overtimeRate
                System.out.print("overtimeRate: ");
                overtimeRate = scanner.nextDouble(); scanner.nextLine();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Option Not Vaild please try again");
                scanner.nextLine();
                continue;
            }
            if (overtimeRate < 1) {
                System.out.println("Option Not Vaild please try again");
            }
        } while (overtimeRate < 1);

        System.out.println("------------------------------------------------------------------------------");

        DepartmentRates department = new DepartmentRates(deptCode, deptName, regularRate, overtimeRate);

        DepartmentRateStore.put(department.deptCode, department);
        */
    }

    public void Display(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(UserData);
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
       return this.UserData;
    }

}
