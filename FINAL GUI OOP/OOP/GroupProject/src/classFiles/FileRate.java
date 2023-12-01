package classFiles;

import java.io.IOException;

import javax.print.DocFlavor.STRING;

public abstract class FileRate {

    protected int deptCode;

    protected String UserData;
    //This is an Default Constructors
    public FileRate(){
       
    }

    //This is an Pirmary Constructors
    public FileRate(int deptCode){
        
    }
    
    //This is an Copy Constructors
    public FileRate(FileRate file){
       
    }

    //Getters and Setters for DeptCode
    public void setDeptCode(int deptCode){
        this.deptCode = deptCode;
    }

    public int getDeptCode(){
        return deptCode;
    }

    //Getters and Setters for DeptCode
    public void setUserData(String UserData){
        this.UserData = UserData;
    }

    public String setUserData(){
        return UserData;
    }
    


    public abstract void SaveDataToFile() throws IOException;
    public abstract void getAllFileRecords() throws IOException;
    public abstract void viewSameDepartment()throws IOException;
    public abstract void getSpecificRecord() throws IOException;
    public abstract void Display() throws IOException;

}
