package dao;

import model.Entries;
import model.User;
import util.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class UserDao {

	public int registerUser(User user) throws ClassNotFoundException {

		int result = 0;

		String insertQuery = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?);";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"PFH#23kgrw9"); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public boolean checkLogin(String email, String password) throws ClassNotFoundException {
		boolean isloginSuccessful = false;
		String selectQuery = "SELECT u_id,email, password FROM users";

		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"PFH#23kgrw9");) {

			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

			ResultSet r = preparedStatement.executeQuery();

			while (r.next()) {

				if (email.equals(r.getString(2)) && password.equals(r.getString(3))) {
					System.out.println(r.getString(1));
					System.out.println(r.getString(2));
					System.out.println("user id is " + r.getString(1));
					System.out.println("login successful in checkLogin method");
					isloginSuccessful = true;

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return isloginSuccessful;
	}

	public int createEvent(int id, String date, String entry) throws ClassNotFoundException {
		int status = 0;
		String insertQuery = "INSERT INTO entries (user_id,entry_date, content) VALUES(?,?,?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"PFH#23kgrw9");) {
			PreparedStatement p = connection.prepareCall(insertQuery);
			p.setInt(1, id);
			p.setString(2, date);
			p.setString(3, entry);
			status = p.executeUpdate();
			System.out.println("status of query is: " + status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public User getUserByEmailId(String email) throws ClassNotFoundException {
		User user = new User();
		String selectQuery = "SELECT * FROM users WHERE email=?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"PFH#23kgrw9");) {

			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, email);
			ResultSet r = preparedStatement.executeQuery();

			if (r.next()) {
				user.setuId(r.getInt(1));
				user.setFirstName(r.getString(2));
				user.setLastName(r.getString(3));
				user.setEmail(r.getString(4));
				user.setPassword(r.getString(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public List<Entries> getEntriesByUser(int uid) throws ClassNotFoundException{
		List<Entries> entries = new ArrayList<Entries>();

		String queryForEntries = "Select * from entries where user_id = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/onlinediarywithservlet?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"PFH#23kgrw9");) {

			PreparedStatement preparedStatement = connection.prepareStatement(queryForEntries);
			preparedStatement.setInt(1, uid);
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
                Entries entry = new Entries();
                entry.setUserId(r.getInt("user_id"));
                entry.setDate(r.getTimestamp("entry_date").toLocalDateTime());  // Convert SQL timestamp to LocalDateTime
                entry.setEntries(r.getString("content"));

                entries.add(entry);
            }
			for(Entries e : entries) {
				System.out.println(e.getEntries());
				System.out.println(e.getDate());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return entries;

	}
	public ArrayList<Entries> searchEntry(int uid, String searchEntry){
		
		ArrayList<Entries> list = new ArrayList<Entries>();
		
		Connection con= DbUtil.getConnection();
		String searchQuery = "select * from entries where user_id=? and content like ?; ";
		try {
		PreparedStatement stm= con.prepareStatement(searchQuery);
		stm.setInt(1, uid);
		stm.setString(2, searchEntry +"%");
		
		ResultSet r= stm.executeQuery();
		
		while(r.next()) {
			Entries e = new Entries();
			e.setDate(r.getTimestamp(2).toLocalDateTime());
			e.setEntries(r.getString(3));
			list.add(e);
		}
		System.out.println("in search entry to view past records");
		for(Entries e: list) {
			System.out.println(e.getEntries());
		}
		
		}
		catch(Exception e) {
			System.out.println("in search entry: "+e.getMessage());
		}
		
		return list;
	}
}
