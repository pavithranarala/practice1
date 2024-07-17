package test;
import java.sql.*;
public class DBCon6 {
	public static void main(String[] args) {
      try {
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
       	Connection con = DriverManager.getConnection
       	 ("jdbc:oracle:thin:@localhost:1521:xe",
       			 "system","tiger");
       	PreparedStatement ps = con.prepareStatement
       		("select * from Product57",1004,1007);
       	ResultSet rs = ps.executeQuery();
       	rs.first();
       	System.out.println(rs.getString(1)+"\t"+
       	   rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
       			rs.getInt(4));
      }catch(Exception e) {e.printStackTrace();}
	}
}

