package test;
import java.util.*;
import javax.sql.rowset.*;
public class DBCon7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
       try {
    	   RowSetFactory rsf = RowSetProvider.newFactory();
    	        //RowSetFactory Object created
    	   System.out.println("****Choice****");
    	   System.out.println("\t1.JdbcRowSet"
    	   		+ "\n\t2.CachedRowSet");
    	   System.out.println("Enter the Choice:");
    	   int choice = s.nextInt();
    	   switch(choice)
    	   {
    	   case 1:
    		   JdbcRowSet jrs = rsf.createJdbcRowSet();
    		   //JdbcRowSet Object created
    		   jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    		   jrs.setUsername("system");
    		   jrs.setPassword("tiger");
    		   jrs.setCommand("select * from Product57");
    		   jrs.execute();
    		   while(jrs.next()) {
    			   System.out.println(jrs.getString(1)+"\t"
    					   +jrs.getString(2)+"\t"
    					   +jrs.getFloat(3)+"\t"
    					   +jrs.getInt(4));
    		   }
    		   jrs.close();
    		   break;
    	   case 2:
    		   CachedRowSet crs = rsf.createCachedRowSet();
    		   //CachedRowSet Object
    		   crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    		   crs.setUsername("system");
    		   crs.setPassword("manager");
    		   crs.setCommand("select * from Product57");
    		   crs.execute();
    		   while(crs.next()) {
    			   System.out.println(crs.getString(1)+"\t"
    					   +crs.getString(2)+"\t"
    					   +crs.getFloat(3)+"\t"
    					   +crs.getInt(4));
    		   }
    		   crs.close();
    		   break;
    	   default:
    		   System.out.println("Invalid Choice...");
    	   }//end of switch
       }catch(Exception e) {e.printStackTrace();}
		}//end of try with resource
	}
}


