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
import java.util.Date;

import dao.ToDoListDao;

/**
 * Servlet implementation class AddToDo
 */
@WebServlet("/AddToDo")
public class AddToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String name = request.getParameter("task");
		String discription = request.getParameter("description");
		String date = request.getParameter("date");
		
		
		System.out.println("task is "+name);
		System.out.println("description is "+discription);
		System.out.println("date is "+date);
		
		

		
		ToDoListDao t = new ToDoListDao();
		try {
		String msg =t.addToDo(name,discription,date,uid);
		System.out.println("in AddToDo.java "+msg);
		}
		catch (ClassNotFoundException e) {
			System.out.println("in catch block of addtodo");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/todolist.jsp");
		rd.forward(request, response);
	}

}
