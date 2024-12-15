package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Entries;
import model.User;

import java.io.IOException;

import dao.UserDao;

/**
 * Servlet implementation class DiaryServlet
 */
@WebServlet("/DiaryServlet")
public class DiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DiaryServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/lib/writeDiary.jsp");
		//dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		HttpSession session = request.getSession(false);
	    User user = (User) session.getAttribute("user");
	   
	    	int uid = user.getuId();
	    	String content =request.getParameter("content");
	    
		System.out.println("content is : "+content);
		
		UserDao d = new UserDao();
		try {
		d.createEvent(uid, content);
		request.getRequestDispatcher("WEB-INF/entries.jsp").forward(request, response);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
