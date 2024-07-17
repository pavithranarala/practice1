package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBCon2H {
       
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the Product code");
				String code = s.next();
				System.out.println("Enter the Product Name:");
				String Name= s.next();
				System.out.println("Enter the Product Price:");
				int price= s.nextInt();
				System.out.println("Enter the Product  QTY:");
				int qty = s.nextInt();
				
				
				// step-1 : Loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// step-2 : Creating Connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
				System.out.println("Connection Established");
				
				// step-3 : Preparing Statement
				
				  Statement stm = con.createStatement(); 
				  int k = stm.executeUpdate
				  ("insert into Product57 values('"+code+"','"+Name+"','"+price+"','"+ qty+"')");
			       if(k>0) {
			    	System.out.println("Product details Inserted Successfully...."); 
			       }
			       System.out.println("The value k:"+k);
			       con.close();
			       
			}catch(Exception e) {e.printStackTrace ();}
		}
	}

}


