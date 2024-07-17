package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/pqr")
public class PrimeServlet extends GenericServlet{
	@Override
 public void service(ServletRequest req,ServletResponse res)throws
 ServletException,IOException{
	 PrintWriter pw = res.getWriter();
	 res.setContentType("text/html");
	 int n = Integer.parseInt(req.getParameter("val"));
	 int count=0;
	 for(int i=1;i<=n;i++)
	 {
		 if(n%i==0)
		 {
			 count++;
		 }
	 }
	 if(count==2) pw.println("Prime Number..<br>");
	 else pw.println("Not Prime Number...<br>");
	 RequestDispatcher rd =
			 req.getRequestDispatcher("input.html");
	 rd.include(req, res);
 }
}

