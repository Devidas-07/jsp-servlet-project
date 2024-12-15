package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;


import dao.UserDao;

@WebServlet("/RegisterServlet")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname= request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		user.setPassword(password);
		
		System.out.println("in UserRegisterServlet");
		System.out.println("first name: "+fname);
		System.out.println("last name: "+lname);
		System.out.println("email is : "+email);
		System.out.println("password is: "+password);
		UserDao userDao = new UserDao();

		try {
			int result = userDao.registerUser(user);
			System.out.println(result+" resutl of inset query");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
