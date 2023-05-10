package com.techademy.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	private static Connection con;
	
	public static Connection getConnection() throws SQLException
	{
		if (con != null) {
            return con;
        }

		Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("path/to/project/db.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Failed to load properties file: " + e.getMessage());
        }
        
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

		try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load database driver: " + e.getMessage());
        }
        
        return con;
	}

}
