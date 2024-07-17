package test;
import java.util.Scanner;
import java.sql.*;
public class DBCon {

	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	       try(s;){
	    	   try {
	    		   Class.forName("oracle.jdbc.driver.OracleDriver");
	               Connection con = DriverManager.getConnection
	            	 ("jdbc:oracle:thin:@localhost:1521:xe",
	            			 "system","tiger");
	               System.out.println("Commit-status : "+con.getAutoCommit());
	               con.setAutoCommit(false);
	               System.out.println("Commit-status : "+con.getAutoCommit());
	               PreparedStatement ps1 = con.prepareStatement
	               ("select * from BankCustomer57 where accno=?");
	               PreparedStatement ps2 = con.prepareStatement
	               ("update BankCustomer57 set bal=bal+? where accno=?");
	               Savepoint sp = con.setSavepoint();
	               System.out.println("Enter the HomeAccNo:");
	               long hAccNo = s.nextLong();
	               ps1.setLong(1, hAccNo);
	               ResultSet rs1 = ps1.executeQuery();
	               if(rs1.next()) {
	            	  float bl = rs1.getFloat(3); 
	            	  System.out.println("Enter benifiecieryAccNo:");
	            	  long bAccNo = s.nextLong();
	            	  ps1.setLong(1, bAccNo);
	            	  ResultSet rs2 = ps1.executeQuery();
	            	  if(rs2.next()) {
	            		 System.out.println("Enter the amt to be transferred:");
	            		 int amt = s.nextInt();
	            		 if(amt<=bl) {
	            			 ps2.setFloat(1, -amt);
	            			 ps2.setLong(2, hAccNo);
	            			 int k = ps2.executeUpdate();//Buffer Updated
	            			 
	            			 ps2.setFloat(1, +amt);
	            			 ps2.setLong(2, bAccNo);
	            			 int z = ps2.executeUpdate();//Buffer Updated
	            			 
	            			 if(k==1 && z==1) {
	            				 con.commit();//Database Updated
	            				 System.out.println("Transaction Successfull..");
	            			 }else {
	            				 con.rollback(sp);
	            				 System.out.println("Transaction failed..");
	            			 }
	            			 
	            		 }else {
	            			 System.out.println("Insuffiecient fund...");
	            		 }
	            	  }else {
	            		  System.out.println("Invalid bAccNo...");
	            	  }
	               }else {
	            	   System.out.println("Invalid homeAccNo...");
	               }
	    	   }catch(Exception e) {e.printStackTrace();}
	       }//end of try with resource
		}
	}


