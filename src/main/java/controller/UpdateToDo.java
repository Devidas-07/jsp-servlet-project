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
import java.sql.SQLException;

import dao.ToDoListDao;

/**
 * Servlet implementation class UpdateToDo
 */
@WebServlet("/UpdateToDoServlet")
public class UpdateToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(false);
	    User user = (User) session.getAttribute("user");
	   
	    int uid = user.getuId();
	    // Get the toDoId from the request parameters
        String toDoIdStr = request.getParameter("toDoId");
        int toDoId = Integer.parseInt(toDoIdStr);
		ToDoListDao t = new ToDoListDao();
		try {
		boolean result= t.updateToDo(toDoId, uid);
		
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
