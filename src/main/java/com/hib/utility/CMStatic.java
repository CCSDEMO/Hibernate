package com.hib.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CMStatic {

	/*
	 * static String DRIVERCLASS = "com.mysql.cj.jdbc.Driver"; static String URL =
	 * "jdbc:mysql://localhost:3306/hidb"; static String USERNAME = "root"; static
	 * String PASSWORD = "root";
	 */

	static Properties props = null;

	static {

		props = new Properties();

		try {
			//props.load(ConnectionManager.class.getClassLoader().getResourceAsStream("db.properties"));
			props=PropertiesReader.getReader("orm-config.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection newConnection() {
		Connection con = null;
		try {
			Class.forName(props.getProperty("driverclass"));
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
					props.getProperty("password"));

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
