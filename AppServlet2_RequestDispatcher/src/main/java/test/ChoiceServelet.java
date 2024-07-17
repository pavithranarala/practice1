package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServelet extends GenericServlet 
{
	@Override
   public void service(ServletRequest req,ServletResponse res)throws
   ServletException,IOException{
	 String s1 = req.getParameter("s1");
	 if(s1.equals("Factorial")) {
		RequestDispatcher rd = 
				req.getRequestDispatcher("xyz");
		rd.forward(req, res);
	 }else {
		RequestDispatcher rd =
				req.getRequestDispatcher("pqr");
		rd.forward(req, res);
	 }
   }
}
