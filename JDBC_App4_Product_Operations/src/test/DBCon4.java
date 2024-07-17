package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {

	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	       try(s;){
	    	   try {
	    		   Class.forName("oracle.jdbc.driver.OracleDriver");
	            	Connection con = DriverManager.getConnection
	            	 ("jdbc:oracle:thin:@localhost:1521:xe",
	            			 "system","tiger");
	            	PreparedStatement ps1 = con.prepareStatement
	            	 ("insert into Product57 values(?,?,?,?)");//Compilation
	            	PreparedStatement ps2 = con.prepareStatement
	            			("select * from Product57");//Compilation
	            	PreparedStatement ps3 = con.prepareStatement
	            	("select * from Product57 where code=?");//Compilation
	            	PreparedStatement ps4 = con.prepareStatement
	            	("update Product57 set price=?,qty=qty+? where code=?");
	            	PreparedStatement ps5 = con.prepareStatement
	            	("delete from Product57 where code=?");
	            	while(true)
	            	{
	            		System.out.println("****Choice*****");
	            		System.out.println("1.AddProduct"
	            				+ "\t\n2.ViewAllProducts"
	            				+ "\t\n3.ViewProductByCode"
	            				+ "\t\n4.UpdateProductByCode(price-qty)"
	            				+ "\t\n5.DeleteProductByCode"
	            				+ "\t\n6.Exit");
	            		System.out.println("Enter the Choice:");
	            		int choice = Integer.parseInt(s.nextLine());
	            		switch(choice)
	            		{
	            		case 1:
	            			System.out.println("====Enter Product Details===");
	            			System.out.println("Enter ProdCode:");
	            			String pC = s.nextLine();
	            			System.out.println("Enter ProdName:");
	            			String pN = s.nextLine();
	            			System.out.println("Enter ProdPrice:");
	            			float pP = Float.parseFloat(s.nextLine());
	            			System.out.println("Enter ProdQty:");
	            			int pQ = Integer.parseInt(s.nextLine());
	            			
	            			
	            		    //Loading data to PreparedStatement Object
	            			ps1.setString(1, pC);
	            			ps1.setString(2, pN);
	            			ps1.setFloat(3, pP);
	            			ps1.setInt(4, pQ);
	            			
	            			int k = ps1.executeUpdate();//Execution
	            			if(k>0) {
	            				System.out.println("Product added Successfully..");
	            			}
	            			break;
	            		case 2:
	            			ResultSet rs1 = ps2.executeQuery();//Execution
	            			while(rs1.next())
	            			{
	            				System.out.println(rs1.getString(1)+"\t"+
	            			     rs1.getString(2)+"\t"+
	            						rs1.getFloat(3)+"\t"+
	            			             rs1.getInt(4));
	            			}
	            			break;
	            		case 3:
	            			System.out.println("Enter the ProdCode:");
	            			String pC1 = s.nextLine();
	            			ps3.setString(1, pC1);
	            			ResultSet rs2 = ps3.executeQuery();//Execution
	            			if(rs2.next()) {
	            				System.out.println(rs2.getString(1)+"\t"+
	                   			     rs2.getString(2)+"\t"+
	                   						rs2.getFloat(3)+"\t"+
	                   			             rs2.getInt(4));
	            			}else {
	            				System.out.println("Invalid ProdCode...");
	            			}
	            			break;
	            		case 4:
	            			System.out.println("Enter the ProdCode for Updating:");
	            			String pC2 = s.nextLine();
	            			ps3.setString(1, pC2);
	            			ResultSet rs3 = ps3.executeQuery();
	            			if(rs3.next()) {
	            				System.out.println("Old Price:"+rs3.getFloat(3));
	            				System.out.println("Enter the New price:");
	            				float nPrice = Float.parseFloat(s.nextLine());
	            				System.out.println("Existing Qty:"+rs3.getInt(4));
	            				System.out.println("Enter the New Qty:");
	            				int nQty = Integer.parseInt(s.nextLine());
	            				ps4.setFloat(1, nPrice);
	            				ps4.setInt(2, nQty);
	            				ps4.setString(3, pC2);
	            				int k2 = ps4.executeUpdate();
	            				if(k2>0) {
	            					System.out.println("Product Updated Successfully...");
	            				}
	            			}else {
	            				System.out.println("Invalid ProdCode...");
	            			}
	            			break;
	            		case 5:
	            			System.out.println("Enter the ProCode for delete process:");
	            			String pC3 = s.nextLine();
	            			ps3.setString(1, pC3);
	            			ResultSet rs4 = ps3.executeQuery();
	            			if(rs4.next()) {
	            				ps5.setString(1, pC3);
	            				int k4 = ps5.executeUpdate();
	            				if(k4>0) {
	            					System.out.println("Product deleted Successfully...");
	            				}
	            			}else {
	            				System.out.println("Invalid ProdCode...");
	            			}
	            			break;
	            		case 6:
	            			System.out.println("Operations Stopped...");
	            			System.exit(0);
	            		default:
	            			System.out.println("Invalid Choice...");
	            		}//end of switch
	            	}//end of loop
	    	   }//end of try
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	       }//end of try with resource
		}
	}

		


		