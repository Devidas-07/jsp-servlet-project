package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.ToDo;
import util.DbUtil;

public class ToDoListDao {
	public String addToDo(String task, String description,String date,int uid) throws ClassNotFoundException{
		String query = "INSERT INTO todolist (name, discription,targetDate,user_id) values (?,?,?,?);";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
					"PFH#23kgrw9");
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("connection established with todolis");
			ps.setString(1, task);
			ps.setString(2, description);
			ps.setString(3, date);
			ps.setInt(4, uid);
			
				
			
			
			int resultOfQuery =ps.executeUpdate();
			System.out.println(resultOfQuery+ "in todolistdao");
			
		}
		catch(SQLException e) {
			
		}
		
		return "to added";
	}
}
