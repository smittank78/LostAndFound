package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.LFBean;
import com.util.LoginConnection;
public class LostDao 
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public boolean enterLostProp(LFBean bean)
	{
		boolean flag = false;
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String enterLostprop = "insert into lostprop(lname,ldepartment,lprofession,lproperty,lplace,lidentity,lcontact,lemail)values(?,?,?,?,?,?,?,?)";
			try 
			{
				pstmt = con.prepareStatement(enterLostprop);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getDept());
				pstmt.setString(3, bean.getField());
				pstmt.setString(4, bean.getProp());
				pstmt.setString(5, bean.getPlace());
				pstmt.setString(6, bean.getIdentity());
				pstmt.setInt(7, bean.getContact());
				pstmt.setString(8, bean.getEmail());
				
				int res = pstmt.executeUpdate();
				if(res>0)
					flag = true;
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
	public List<LFBean> showLostProp()
	{
		List<LFBean> listOfProp = new ArrayList<LFBean>();
		con = LoginConnection.getConnection();
		if(con != null)
		{
			String retriveQuery = "select * from lostprop";
			try 
			{
				pstmt = con.prepareStatement(retriveQuery);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString("lname") + "| " + rs.getString("lproperty") +"| " + rs.getString("lplace") + "| " +rs.getString("lprofession") +"| " + rs.getString("ldepartment") +"| " +rs.getString("lidentity")+"| " +rs.getInt("lcontact")+"| " + rs.getString("lemail")+"| " +rs.getInt("lid"));
					LFBean bean = new LFBean();
					bean.setName(rs.getString("lname"));
					bean.setProp(rs.getString("lproperty"));
					bean.setPlace(rs.getString("lplace"));
					bean.setField(rs.getString("lprofession"));
					bean.setDept(rs.getString("ldepartment"));
					bean.setIdentity(rs.getString("lidentity") );
					bean.setContact(rs.getInt("lcontact"));
					bean.setEmail(rs.getString("lemail"));
					bean.setId(rs.getInt("lid"));
					listOfProp.add(bean);
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return listOfProp;
	}
	
	public boolean deleteProp(int id)
	{
		boolean flag = false;
		con = LoginConnection.getConnection();
		
		try 
		{
			pstmt = con.prepareStatement("delete from lostprop where lid=?");
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
		return flag;
	}
	public LFBean searchLostPropDetail(int id)
	{
		con = LoginConnection.getConnection();
		LFBean bean = new LFBean();
		if(con != null)
		{
			String retriveQuery = "select * from lostprop where lid=?";
			try 
			{
				pstmt = con.prepareStatement(retriveQuery);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					bean.setName(rs.getString("lname"));
					bean.setProp(rs.getString("lproperty"));
					bean.setPlace(rs.getString("lplace"));
					bean.setField(rs.getString("lprofession"));
					bean.setDept(rs.getString("ldepartment"));
					bean.setIdentity(rs.getString("lidentity") );
					bean.setContact(rs.getInt("lcontact"));
					bean.setEmail(rs.getString("lemail"));
					bean.setId(rs.getInt("lid"));
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