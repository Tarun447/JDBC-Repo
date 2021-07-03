package project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/login")
public class LoginServlet extends GenericServlet {
	public void init() throws javax.servlet.ServletException
	{
		
	}
	public void service (ServletRequest req,ServletResponse res)throws javax.servlet.ServletException,java.io.IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String fname = LoginDAO.login(req);
		if(fname==null)
		{
			pw.println("<script>alert('Invalid Credential')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("<script>alert('Login Successfully')</script>");
			pw.println("Welcome "+fname);
			
		}
		
	}

	public void destroy()
	{
		
	}

}
