package test;
import java.util.*;
import java.sql.*;
public class DBCon2 
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the CustId:");
				String cId = s.nextLine();
				System.out.println("Enter the CustName:");
				String cName = s.nextLine();
				System.out.println("Enter the CustCity:");
				String city = s.nextLine();
				System.out.println("Enter the CustState:");
				String state = s.nextLine();
				System.out.println("Enter the PinCode:");
				int pinCode = Integer.parseInt(s.nextLine());
				System.out.println("Enter the CustMail:");
				String mId = s.nextLine();
				System.out.println("Enter the PhNO:");
				long phNo = s.nextLong();
				
				// step-1 : Loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// step-2 : Creating Connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
				System.out.println("Connection Established");
				
				// step-3 : Preparing Statement
				
				  Statement stm = con.createStatement(); 
				  int k = stm.executeUpdate
				  ("insert into Customer57 values('"+cId+"','"+cName+"','"+city+"','"+state+"',"+pinCode+",'"+mId+"',"+phNo+")");
				  System.out.println("k value"+k);
			       if(k>0) {
			    	System.out.println("Customer details Inserted Successfully...."); 
			       }
			       System.out.println("The value k:"+k);
			       con.close();
			       
			}catch(Exception e) {e.printStackTrace ();}
		}
	}

}
