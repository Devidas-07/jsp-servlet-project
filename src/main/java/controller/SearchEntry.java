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
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;

@WebServlet("/SearchEntry")
public class SearchEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEntry() {
		super();

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		String searchEntry = request.getParameter("search");
		System.out.println("search box query: " + searchEntry);
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("user");

		int uid = u.getuId();
		UserDao u1 = new UserDao();
		ArrayList<Entries> elist = u1.searchEntry(uid, searchEntry);
		for(Entries e: elist) {
			System.out.println("in search entry servlet");
			System.out.println(e.getEntries());
		}
//		request.setAttribute("entries", elist);
//		request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
	}

}
