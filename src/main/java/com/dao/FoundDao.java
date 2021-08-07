package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.LFBean;
import com.util.LoginConnection;

public class FoundDao
{
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	public boolean insertFoundProperty(LFBean bean)
	{
		boolean flag = false;
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String insertQuery = "insert into foundprop(name,dept,field,prop,place,identity,contact,email,submit,collectfrom,time)values(?,?,?,?,?,?,?,?,?,?,?)";
			try
			{
				pstmt = con.prepareStatement(insertQuery);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getDept());
				pstmt.setString(3, bean.getField());
				pstmt.setString(4, bean.getProp());
				pstmt.setString(5, bean.getPlace());
				pstmt.setString(6, bean.getIdentity());
				pstmt.setInt(7, bean.getContact());
				pstmt.setString(8, bean.getEmail());
				pstmt.setString(9, bean.getSubmit());
				pstmt.setString(10, bean.getCollection());
				pstmt.setString(11, bean.getDate());
				
				int res = pstmt.executeUpdate();
				if(res>0)
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
	public List<LFBean> foundData()
	{
		List<LFBean> listOfFoundData = new ArrayList<LFBean>();
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String foundData = "select * from foundprop";
			try
			{
				pstmt = con.prepareStatement(foundData);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					LFBean bean = new LFBean();
					bean.setId(rs.getInt("fid"));
					bean.setName(rs.getString("name"));
					bean.setDept(rs.getString("dept"));
					bean.setField(rs.getString("field"));
					bean.setProp(rs.getString("prop"));
					bean.setPlace(rs.getString("place"));
					bean.setIdentity(rs.getString("identity"));
					bean.setContact(rs.getInt("contact"));
					bean.setEmail(rs.getString("email"));
					bean.setSubmit(rs.getString("submit"));
					bean.setCollection(rs.getString("collectfrom"));
					bean.setDate(rs.getString("time"));
					listOfFoundData.add(bean);
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return listOfFoundData;
	}
	public boolean deleteFoundData(int id)
	{
		boolean flag = false;
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String deleteQuery = "delete * from foundprop where id =?";
			try 
			{
				pstmt = con.prepareStatement(deleteQuery);
				pstmt.setInt(1, id);
				int res = pstmt.executeUpdate();
				if(res>0)
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
	public LFBean searchFoundPropDetail(int id)
	{
		con = LoginConnection.getConnection();
		LFBean bean = new LFBean();
		if(con != null)
		{
			String retriveQuery = "select * from foundprop where fid=?";
			try 
			{
				pstmt = con.prepareStatement(retriveQuery);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					bean.setId(rs.getInt("fid"));
					bean.setName(rs.getString("name"));
					bean.setDept(rs.getString("dept"));
					bean.setField(rs.getString("field"));
					bean.setProp(rs.getString("prop"));
					bean.setPlace(rs.getString("place"));
					bean.setIdentity(rs.getString("identity"));
					bean.setContact(rs.getInt("contact"));
					bean.setEmail(rs.getString("email"));
					bean.setSubmit(rs.getString("submit"));
					bean.setCollection(rs.getString("collectfrom"));
					bean.setDate(rs.getString("time"));
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return bean;
	}
}