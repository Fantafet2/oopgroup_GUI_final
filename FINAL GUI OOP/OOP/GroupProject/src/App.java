import java.util.Scanner;

import classFiles.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        int option = 0;
        int counter = 0;
        

        boolean loadDepartmentFiles = false , loadEmployeeFiles = false, loadProcessFiles = false;
        new GUI();
        /*
        System.out.print("Loading DepartmentRate Files");

        do {
            try {
                System.out.print("[");
                while(counter<5){
                    System.out.print(".");
                    counter++;
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException ex){}
                    
                }
                System.out.print("]\n");
                counter = 0;
                //Askes for the User Choice
                new DepartmentRates().getAllFileRecords();
                loadDepartmentFiles = true;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Failed to load DepartmentRates File, retrying now");
                scanner.nextLine();
            }
        } while (loadDepartmentFiles == false);

        System.out.print("\nLoading EmployeePayroll Files");

        do {
            try {
                System.out.print("[");
                 while(counter<5){
                    System.out.print(".");
                    counter++;
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException ex){}
                    
                }
                System.out.print("]\n");
                counter = 0;
                //Askes for the User Choice
                new EmployeePayroll().getAllFileRecords();
                loadEmployeeFiles = true;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Failed to load EmployeePayroll File, retrying now");
                scanner.nextLine();
            }
        } while (loadEmployeeFiles == false);

        System.out.print("\nLoading ProcessedPayroll Files");
        do {
            try {
                System.out.print("[");
                while(counter<5){
                    System.out.print(".");
                    counter++;
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException ex){}
                    
                }
                System.out.print("]\n");
                counter = 0;
                //Askes for the User Choice
                new ProcessedPayroll().getAllFileRecords();
                loadProcessFiles = true;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
                System.out.println("Failed to load ProcessedPayroll File, retrying now");
                scanner.nextLine();
            }
        } while (loadProcessFiles == false);

        System.out.println("\nHello User, What whould you like to do do Today \n");


        while (option != 4) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Please Input the corresponding Number for your choice: ");
            System.out.println("[1]DepartmentRates");
            System.out.println("[2]EmployeePayroll");
            System.out.println("[3]ProcessedPayroll");
            System.out.println("[4]Exit");
            
            do {
                try {
                    //Askes for the User Choice
                    System.out.print("Your Choice: ");
                    option = scanner.nextInt();
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Option Not Vaild please try again");
                    scanner.nextLine();
                    continue;
                }
                if (option < 1 || option > 4) {
                    System.out.println("Option Not Vaild please try again");
                }
            } while (option < 1 || option > 4);
            
            System.out.println("------------------------------------------------------------------------------");
            switch (option) {
                case 1:
                    System.out.println("Please Input the corresponding Number for your choice: ");
                    //allows the user to add new department rates record to the system.
                    System.out.println("[1]Add:");
                    //allows the user to update an existing department record.
                    System.out.println("[2]Update");
                    //allows the user to view a single department record.
                    System.out.println("[3]View a Specific record");
                    //which allows the user to view all department records.
                    System.out.println("[4]View All records");
                    //Cancel Current Option
                    System.out.println("[5]Cancel");
                    option = 0;

                    do {
                        try {
                            //Askes for the User Choice
                            System.out.print("Your Choice: ");
                            option = scanner.nextInt();
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Option Not Vaild please try again");
                            scanner.nextLine();
                            continue;
                        }
                        if (option < 1 || option > 5) {
                            System.out.println("Option Not Vaild please try again");
                        }
                    } while (option < 1 || option > 5);
                    
                    switch (option) {
                        case 1:
                            new DepartmentRates().Add();
                            break;
                        case 2:
                            new DepartmentRates().UpdateSpecificRecord();
                            break;
                        case 3:
                            new DepartmentRates().getSpecificRecord();
                            break;
                        case 4:
                            new DepartmentRates().ViewAllRecord();
                            break;
                        default:
                            option = 0;
                            break;
                    }
                    option = 0;
                    break;
                case 2:
                    System.out.println("Please Input the corresponding Number for your choice");
                    //allows the user to add a new employee record to the system.
                    System.out.println("[1]Add");
                    //allows the user to update an existing employee record.
                    System.out.println("[2]Update");
                    //allows the user to view a single employee record.
                    System.out.println("[3]View a Specific record");
                    //allows the user to view all employee records for a specified department.
                    System.out.println("[4]View All records for Employee of the same Department");
                    //allows the user to delete an employee record.
                    System.out.println("[5]Delete a record");
                    //Cancel Current Option
                    System.out.println("[6]Cancel");
                    option = 0;

                    do {
                        try {
                            //Askes for the User Choice
                            System.out.print("Your Choice: ");
                            option = scanner.nextInt();
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Option Not Vaild please try again");
                            scanner.nextLine();
                            continue;
                        }
                        if (option < 1 || option > 6) {
                            System.out.println("Option Not Vaild please try again");
                        }
                    } while (option < 1 || option > 6);

                    switch (option) {
                        case 1:
                            new EmployeePayroll().Add();
                            break;
                        case 2:
                            new EmployeePayroll().UpdateSpecificRecord();
                            break;
                        case 3:
                            new EmployeePayroll().getSpecificRecord();
                            break;
                        case 4:
                            new EmployeePayroll().ViewAllRecord();
                            break;
                        case 5:
                            new EmployeePayroll().RemoveSpecificRecord();
                            break;
                        default:
                            option = 0;
                            break;
                    }
                    option = 0;
                    break;
                case 3:
                    System.out.println("Please Input the corresponding Number for your choice");
                    System.out.println("[1]Process Payroll");
                    System.out.println("[2]View Specific records");
                    System.out.println("[3]View All records for Employee of the same Department");
                    System.out.println("[4]Cancel");
                    option = 0;
                    
                    do{
                        try {
                            //Askes for the User Choice
                            System.out.print("Your Choice: ");
                            option = scanner.nextInt();
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Option Not Vaild please try again");
                            scanner.nextLine();
                            continue;
                        }
                        if (option < 1 || option > 4) {
                            System.out.println("Option Not Vaild please try again");
                        }
                    } while (option < 1 || option > 4);
                    
                    switch (option) {
                        case 1:
                            new ProcessedPayroll().processPayroll();
                            break;
                        case 2:
                            new ProcessedPayroll().getSpecificRecord();
                            break;
                        case 3:
                            new ProcessedPayroll().viewSameDepartment();
                            break;
                        default:
                            option = 0;
                            break;
                    }
                    option = 0;
                    break;
                default:
                    break;
            }
        }

        new DepartmentRates().SaveDataToFile();

        new EmployeePayroll().SaveDataToFile();

        new ProcessedPayroll().SaveDataToFile();

        scanner.close();
*/
        

    }

}
