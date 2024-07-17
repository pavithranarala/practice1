package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBCon3H {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the Product code");
				String code = s.nextLine();
				// step-1 : Loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// step-2 : Creating Connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
				System.out.println("Connection Established");
				
				// step-3 : Preparing Statement
				
				  Statement stm = con.createStatement(); 
				  ResultSet rs = stm.executeQuery("select*from Product57 where code='"+code+"'");
				      if(rs.next()) {
				    	  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"); 
			       }
				      else {
				    	  System.out.println("Invalid PId.....");
				      }
			       
			       con.close();
			       
			}catch(Exception e) {e.printStackTrace ();}
		}
	}

}
