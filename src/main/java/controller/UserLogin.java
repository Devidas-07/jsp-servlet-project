package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


import dao.UserDao;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserLogin() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		try {
		boolean isValidUser = userDao.checkLogin(email, password);
		if(isValidUser) {
			System.out.println("login successful");
			request.getRequestDispatcher("WEB-INF/writeDiary.jsp").forward(request, response);
			
			
			
		}
		}
		catch(Exception e){
			System.out.println("in UserLogin Servlet");
			e.printStackTrace();
		}
		
	}

}
