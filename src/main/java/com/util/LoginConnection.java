package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginConnection 
{
	private static String user = "postgres";
	private static String pass = "root";
	private static String url = "jdbc:postgresql://localhost:5432/lflogin";
	private static String driverClass = "org.postgresql.Driver";
	static Connection con = null;
	public static Connection getConnection()
	{
		try 
		{
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, pass);
			if(con != null)
			{
				System.out.println("Login Connection Esatablished..........");
			}
			else
			{
				System.out.println("Login Connection Failed..........");			
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Login Connection ---> Class Not Found...........");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Login Connection --->Sql Exception Occured ...........");
		}
		return con;
	}
	public static void main(String[] args)
	{
		LoginConnection.getConnection();
	}
}