package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet 
{
	@Override
	public void init()throws ServletException
	{
		//NoCode
	}
  @Override
  public void service(ServletRequest req,ServletResponse res)throws
  ServletException,IOException
  {
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	String Custid = req.getParameter("Custid");
	String CustName = req.getParameter("CustName");
	String CustCity = req.getParameter("CustCity");
	String CustState = req.getParameter("CustState");
	String CustMailId = req.getParameter("CustMailId");
	String CustPhno = req.getParameter("CustPhno");
	
    pw.println("*****DisplayServlet****");
    pw.println("<br>Custid:"+Custid);
    pw.println("<br>CustName:"+CustName);
    pw.println("<br>CustCity:"+CustCity);
    pw.println("<br>CustState:"+CustState);
    pw.println("<br>CustmailId:"+CustMailId);
    pw.println("<br>CustPhno:"+CustPhno);
  }
  
  @Override
  public void destroy()
  {
	 //NoCode 
  }
}

