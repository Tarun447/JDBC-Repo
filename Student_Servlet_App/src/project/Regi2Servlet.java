package project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/resi1")
public class Regi2Servlet extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res) throws javax.servlet.ServletException,
	java.io.IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sc = req.getServletContext();
		StudentBean sb = (StudentBean)sc.getAttribute("sb");
		sb.setLname(req.getParameter("lname"));
		sb.setPhn(Long.parseLong(req.getParameter("ph")));
		sb.setMid(req.getParameter("email"));
		int k = ResisterDAO.Register(sb);
		if(k>0)
		{
			pw.println("<script>alert('Resistraion Successfully Done')</script>");	
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
