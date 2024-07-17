package com.nt.comps;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon1 {

	public static void main(String[] args) {
	
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			System.out.println("Connection Established");
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		

	}

}
