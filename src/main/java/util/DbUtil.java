package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Entries;

public class DbUtil{
	private static String jdbcURL = "jdbc:mysql://localhost:3306/onlinediarywithservlet";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "PFH#23kgrw9";

	public  static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return con;
	}
}
