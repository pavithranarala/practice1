package test;
import java.sql.*;
public class DBCon5 {
	public static void main(String[] args) {
       try {
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
        	 ("jdbc:oracle:thin:@localhost:1521:xe",
        			 "system","tiger");
        	Statement stm = con.createStatement
        			(ResultSet.TYPE_SCROLL_INSENSITIVE,
        					ResultSet.CONCUR_READ_ONLY);
        	/*
        	 System.out.println(ResultSet.TYPE_FORWARD_ONLY);
        	System.out.println(ResultSet.TYPE_SCROLL_INSENSITIVE);
        	System.out.println(ResultSet.TYPE_SCROLL_SENSITIVE);
        	System.out.println(ResultSet.CONCUR_READ_ONLY);
        	System.out.println(ResultSet.CONCUR_UPDATABLE);
        	*/
        	ResultSet rs = stm.executeQuery
        			("select * from Customer57");
        	rs.afterLast();
        	//Cursor pointing after the last row
        	System.out.println("****Details****");
        	while(rs.previous())
        	{
        		System.out.println(rs.getString(1)+"\t"+
             	       rs.getString(2)+"\t"+rs.getString(3)+
             	       "\t"+rs.getString(4)+"\t"+
             	       rs.getInt(5)+"\t"+rs.getString(6)+"\t"+
             	       rs.getLong(7));
        	}
        	System.out.println("====row-2=====");
        	rs.absolute(2);
        	System.out.println(rs.getString(1)+"\t"+
          	       rs.getString(2)+"\t"+rs.getString(3)+
          	       "\t"+rs.getString(4)+"\t"+
          	       rs.getInt(5)+"\t"+rs.getString(6)+"\t"+
          	       rs.getLong(7));
     	    System.out.println("====relative(+2)=====");
     	    rs.relative(+2);
     	   System.out.println(rs.getString(1)+"\t"+
          	       rs.getString(2)+"\t"+rs.getString(3)+
          	       "\t"+rs.getString(4)+"\t"+
          	       rs.getInt(5)+"\t"+rs.getString(6)+"\t"+
          	       rs.getLong(7));
     	    
       }catch(Exception e) {e.printStackTrace();}
	}
}



