package dao;

import model.Entries;
import model.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDao {
	
	public int registerUser(User user) throws ClassNotFoundException {

		int result= 0;
		
	
		String insertQuery = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?);";

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/onlinediarywithservlet?useSSL=false","root","PFH#23kgrw9");
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery)
				) {
			

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

		
			
			result = preparedStatement.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return result;
	}
	
	
	public boolean checkLogin(String email, String password) throws ClassNotFoundException {
		boolean isloginSuccessful=false;
		String selectQuery = "SELECT u_id,email, password FROM users";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinediarywithservlet?useSSL=false","root","PFH#23kgrw9");){
			
		PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			
			ResultSet r =preparedStatement.executeQuery();
			
			while(r.next()) {
				
				if(email.equals(r.getString(2)) && password.equals(r.getString(3))) {
					System.out.println(r.getString(1));
					System.out.println(r.getString(2));
					System.out.println("user id is "+r.getString(1));
				System.out.println("login successful in checkLogin method");
				isloginSuccessful=true;
				
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		return isloginSuccessful;
	}
//	public int createEvent(Entries en) throws ClassNotFoundException {
//		int status=0;
//		String insertQuery= "INSERT INTO entries (content) VALUES(?);";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinediarywithservlet?useSSL=false","root","PFH#23kgrw9");){
//			 PreparedStatement p =connection.prepareCall(insertQuery);
//			 p.setString(1, en.getEntries());
//			 status= p.executeUpdate();
//			System.out.println("status of query is: "+status);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return status;
//	}
	
	
}
	
