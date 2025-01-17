package test;
import java.util.*;
import java.sql.*;
public class DBCon9 {
	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       try(s;){
    	   try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
           	Connection con = DriverManager.getConnection
           	 ("jdbc:oracle:thin:@localhost:1521:xe",
           			 "system","tiger");
           	CallableStatement cs = con.prepareCall
           	("{call RetrieveDetails57(?,?,?,?,?)}");
           	
           	System.out.println("Enter the EmpId:");
           	String eId = s.nextLine();
           	cs.setString(1, eId);
           	cs.registerOutParameter(2, Types.VARCHAR);
           	cs.registerOutParameter(3, Types.VARCHAR);
           	cs.registerOutParameter(4, Types.INTEGER);
           	cs.registerOutParameter(5, Types.FLOAT);
           	
           	cs.execute();
           	
           	System.out.println("====EmpDetails====");
           	System.out.println("EmpId:"+eId);
           	System.out.println("EmpName:"+cs.getString(2));
           	System.out.println("EmpDesg:"+cs.getString(3));
           	System.out.println("EmpBSal:"+cs.getInt(4));
           	System.out.println("EmpTotSal:"+cs.getFloat(5));
    	   }catch(Exception e) {e.printStackTrace();}
       }//try with resource
	}
}

