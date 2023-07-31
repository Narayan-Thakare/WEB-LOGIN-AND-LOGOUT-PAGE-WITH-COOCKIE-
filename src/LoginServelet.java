

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	     response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        request.getRequestDispatcher("index.html").include(request, response); 
	        
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        if(name.equals("admin")&& password.equals("abc123"))	
	        {  
	        	out.print("<br>");
	            out.print("You are successfully logged in!");  
	            out.print("<br>Welcome, "+name);  
	              
	            Cookie ck=new Cookie("name",name);  
	            response.addCookie(ck);  
	        }else{  
	        	out.print("<br>");

	            out.print("sorry, username or password error!");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  

		
		
		
	}

}
