package project;

import javax.servlet.*;
import javax.servlet.annotation.*;



@SuppressWarnings("serial")
@WebServlet("/resi")
public class Register1Servlet extends GenericServlet {
	
	public void init() throws javax.servlet.ServletException
	{
		
	}
	
	public void service(ServletRequest req ,ServletResponse res) throws javax.servlet.ServletException,java.io.IOException
	{
		StudentBean sb = new StudentBean();
		sb.setuName(req.getParameter("un"));
		sb.setPass(req.getParameter("pass"));
		sb.setFname(req.getParameter("fname"));
		ServletContext sc = req.getServletContext();
		sc.setAttribute("sb", sb);
		RequestDispatcher rd = req.getRequestDispatcher("Resi2.html");
		rd.forward(req, res);
		
	}
	public void destroy()
	{
		
	}

}
