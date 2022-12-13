package rushi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user;
import bean.uservaliator;


@WebServlet(asyncSupported = true, name = "Rushi", urlPatterns = { "/Rushi" })
public class Rushidemo1 extends HttpServlet {
private static final long serialVersionUID = 1L;

   
    public Rushidemo1() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 String UserName=request.getParameter("username");
		 String Password=request.getParameter("password");
		 user currentuser=new user(UserName,Password);
		 boolean valid=uservaliator.isvalid(currentuser);
		 if(valid)
		 {
			 out.println("<h1>Welcome to my Website</h1>");
		 }
		 else {
			 out.println("<h1> Sorry</h1>");
		 }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	
		doGet(request, response);
	}

}
