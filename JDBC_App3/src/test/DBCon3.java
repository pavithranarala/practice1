package test;
import java.sql.*;
import java.util.*;
public class DBCon3
{
public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the CustId:");
				String cId = s.nextLine();
				// step-1 : Loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// step-2 : Creating Connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
				System.out.println("Connection Established");
				
				// step-3 : Preparing Statement
				
				  Statement stm = con.createStatement();
				  ResultSet rs = stm.executeQuery
			      ("select * from Customer57 where cid='"+cId+"'");
				  if(rs.next()) {
					  System.out.println(rs.getString(1)+"\t"+
				  rs.getString(2)+"\t"+rs.getString(3)+"\t"+
							  rs.getString(4)+"\t"+rs.getInt(5)+
							  "\t"+rs.getString(6)+"\t"+
							  rs.getLong(7));
				  }else {
					  System.out.println("Invalid CustId...");
				  }
				  con.close();
			}catch(Exception e) {e.printStackTrace ();}
		}//ene of try with resource
	}

}
