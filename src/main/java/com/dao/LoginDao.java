package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bean.LFBean;
import com.util.LoginConnection;

public class LoginDao
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public boolean NewAccount(LFBean bean)
	{
		boolean flag = false;
		con = LoginConnection.getConnection();
		if(con!=null)
		{
			String addUserQuery = "insert into account(aname,apass,acreate)values(?,?,?)";
			try
			{
				pstmt = con.prepareStatement(addUserQuery);
				pstmt.setString(1,bean.getUser());
				pstmt.setString(2,bean.getPass());
				pstmt.setString(3,bean.getDate());
				int res = pstmt.executeUpdate();
				if(res>0)
				{
					flag = true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("LoginDao --> SqlException --> line : 34");
			}
		}
		return flag;
	}
	public boolean getLoginUserValidationData(String user,String pass,String time)
	{
		boolean flag = false;
//		LFBean loginBean = new LFBean();
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String userValidetionDataQuery = "update account set ltime=? where aname=? and apass=?";
			try 
			{
				pstmt = con.prepareStatement(userValidetionDataQuery);
				pstmt.setString(1,time);
				pstmt.setString(2,user);
				pstmt.setString(3,pass);
				int rs = pstmt.executeUpdate();
				if(rs > 0)
				{
					flag = true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
	public boolean enterNewPassword(String user,String newPassword)
	{
		boolean flag = false;
//		LFBean loginBean = new LFBean();
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String changePasswordQuery = "update account set apass=? where aname=?";
			try 
			{
				pstmt = con.prepareStatement(changePasswordQuery);
				pstmt.setString(1,newPassword);
				pstmt.setString(2,user);
				int rs = pstmt.executeUpdate();
				if(rs > 0)
				{
					flag = true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
}