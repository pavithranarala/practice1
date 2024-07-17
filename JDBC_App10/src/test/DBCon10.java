package test;
import java.util.*;
import java.sql.*;
public class DBCon10 {
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      try(s;){
    	  try {
    		  Class.forName("oracle.jdbc.driver.OracleDriver");
           	Connection con = DriverManager.getConnection
           	 ("jdbc:oracle:thin:@localhost:1521:xe",
           			 "system","tiger");
           	CallableStatement cs = con.prepareCall
           	("{call ?:=RetrieveTotSal57(?)}");
           	System.out.println("Enter EmpId:");
           	String eId = s.nextLine();
         	cs.registerOutParameter(1, Types.FLOAT);
           	cs.setString(2, eId);
            cs.execute();
            System.out.println("====Details====");
            System.out.println("Emp-Id:"+eId);
            System.out.println("Emp-TotSal:"+cs.getFloat(1));
    	  }catch(Exception e) {e.printStackTrace();}
      }//end of try with resource
	}
}




