package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

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
	public List<ToDo> getAllToDo(int uid) throws SQLException{
		List<ToDo> list = new ArrayList<ToDo>();
		
		String query ="SELECT * FROM TODOLIST WHERE user_id=?;";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps= con.prepareStatement(query);
		ps.setInt(1, uid);
		ResultSet r = ps.executeQuery();
		
		while(r.next()) {
			ToDo todo = new ToDo();
			todo.setTid(r.getInt(1));
			todo.setName(r.getString(2));
			todo.setDiscription(r.getString(3));
			todo.setTargetDate(r.getDate(4));
			todo.setStatus(r.getBoolean(5));
			todo.setUserId(r.getInt(6));
			
			list.add(todo);
			
		}
		return list;
	}
	public int countOfPendingTask(int uid) throws SQLException{
		String query = "select count(*) from todolist where user_id=? AND status=0 ;";
		int count=0;
		
		Connection con = DbUtil.getConnection();
		PreparedStatement ps=  con.prepareStatement(query);
		ps.setInt(1, uid);
		ResultSet r =ps.executeQuery();
		if(r.next()) {
			count = r.getInt(1);
		}
		else {
			System.out.println("no rows found");
		}
		return count;
		
	}
	public boolean updateToDo(int tid, int uid) throws SQLException{
		Connection con = DbUtil.getConnection();
		String query = "update todolist set status= 1 where tid=? AND user_id=?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, tid);
		ps.setInt(2, uid);
		
		int result =ps.executeUpdate();
		if(result>0) {
		return true;
		}
		else {
			return false;
		}
	}
}
