package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Entries;

import java.io.IOException;

import dao.UserDao;

/**
 * Servlet implementation class DiaryServlet
 */
@WebServlet("/DiaryServlet")
public class DiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/lib/writeDiary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String content =request.getParameter("content");
		System.out.println("content is : "+content);
		Entries e = new Entries();
		e.setEntries(content);
		UserDao d = new UserDao();
		try {
		//d.createEvent(e);
		request.getRequestDispatcher("WEB-INF/lib/diary.jsp").forward(request, response);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
