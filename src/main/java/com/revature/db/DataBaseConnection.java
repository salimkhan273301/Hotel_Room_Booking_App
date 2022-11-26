package com.revature.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	public static Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
		// 1 registration driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2 creating Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking", "root", "12345");
		return con;
	}

}

