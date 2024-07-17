package test;
import java.sql.*;
import java.util.*;
public class DBCon8 {
	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       try(s;){
    	   try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
            	Connection con = DriverManager.getConnection
            	 ("jdbc:oracle:thin:@localhost:1521:xe",
            			 "system","tiger");
            	CallableStatement cs = con.prepareCall
            	("{call InsertDetails57(?,?,?,?,?)}");
            	
            	//read data into Local Variables
            	System.out.println("Enter the empId:");
            	String eId = s.nextLine();
            	System.out.println("Enter the empName:");
            	String eName = s.nextLine();
            	System.out.println("Enter the empDesg:");
            	String eDesg = s.nextLine();
            	System.out.println("Enter the empBSal:");
                int bSal = s.nextInt();
                float totSal = bSal+(0.93F*bSal)+(0.61F*bSal);
            	
                //Add data to CallableStatement Object
                cs.setString(1, eId);
                cs.setString(2, eName);
                cs.setString(3, eDesg);
                cs.setInt(4, bSal);
                cs.setFloat(5, totSal);
                
                cs.execute();//Procedure executed with values
                System.out.println("EmpDetails inserted Successfully...");
                
    	   }catch(Exception e) {e.printStackTrace();}
       }//try with resource
	}
}

