
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ToDoListDao;
import dao.UserDao;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		try {
			boolean isValidUser = userDao.checkLogin(email, password);
			if (isValidUser) {
				System.out.println("login successful");
				User user = userDao.getUserByEmailId(email);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("/writeDiary.jsp");
				rd.forward(request, response);

			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("email id and password did't match!!!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			System.out.println("in UserLogin Servlet");
			e.printStackTrace();
		}

	}

}
