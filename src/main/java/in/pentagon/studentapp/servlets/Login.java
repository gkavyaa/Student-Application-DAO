package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
 
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
  StudentDAO sdao = new StudentDAOImpl();
  HttpSession session=req.getSession(true);
//  PrintWriter out = resp.getWriter();
//    String username = req.getParameter("username");
//    String pass = req.getParameter("password");
  
  Student s = sdao.getStudent(req.getParameter("username"),req.getParameter("password"));
  
  if(s != null) {
	  session.setAttribute("student",s);
	  req.setAttribute("success","Login successfull!");
		RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
		rd.forward(req, resp);
//   out.println("<h1>Login Successfull!...Welcome "+s.getName()+"</h1>");
  }
  else {
	  req.setAttribute("error","Failed to login");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req, resp);
		
//   out.println("<h1>Invalid login credentials...!</h1>");
  }
  
 }

}

