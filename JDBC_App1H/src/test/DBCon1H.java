package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBCon1H {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// step-1 : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step-2 : Creating Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			System.out.println("Connection Established");
			
			// step-3 : Preparing Statement
			
			  Statement stm = con.createStatement(); // step-4 : Executing query
			  ResultSet rs = stm.executeQuery("select * from Product57");
			  System.out.println("****Product-Details****"); while (rs.next()) {
			  System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" +
			  rs.getInt(3) + "\t" + rs.getInt(4) ); } // end of loop // step-5 : Closing the connection
			 			con.close();
		} // end of try
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}

