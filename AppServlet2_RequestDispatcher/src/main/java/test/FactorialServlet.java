package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/xyz")
public class FactorialServlet extends GenericServlet{
	@Override
  public void service(ServletRequest req,ServletResponse res)throws
  ServletException,IOException{
	  PrintWriter pw = res.getWriter();
	  res.setContentType("text/html");
	  int n = Integer.parseInt(req.getParameter("val"));
	  int fact=1;
	  for(int i=n;i>=1;i--)
	  {
		  fact=fact*i;
	  }
	  pw.println("Factorial : "+fact+"<br>");
	  RequestDispatcher rd = 
			  req.getRequestDispatcher("input.html");
	  rd.include(req, res);
  }
}
