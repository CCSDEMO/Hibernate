package com.hib.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static ConnectionManager instance;

	/*
	 * dont Hardcode the values use properties file bcz if we change db code need to
	 * modify again
	 */
	/*
	 * private static String DRIVERCLASS = "com.mysql.cj.jdbc.Driver"; private
	 * static String URL = "jdbc:mysql://localhost:3306/hidb"; private static String
	 * USERNAME = "root"; private static String PASSWORD = "root";
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

	public static Connection newConnection() throws IOException {
		Connection con = null;

		try {

			Class.forName(props.getProperty("driverclass"));
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
					props.getProperty("password"));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private ConnectionManager() {

	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

}
