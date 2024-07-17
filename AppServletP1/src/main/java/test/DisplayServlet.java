
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
	String code = req.getParameter("code");
	String name = req.getParameter("name");
	String price = req.getParameter("price");
	String qty= req.getParameter("qty");
	
    pw.println("*****DisplayServlet****");
    pw.println("<br>code:"+code);
    pw.println("<br>name:"+name);
    pw.println("<br>price:"+price);
    pw.println("<br>qty:"+qty);
  }
  @Override
  public void destroy()
  {
	 //NoCode 
  }
}
