package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.ParseDateTag;

import com.Validation.LoginValidation;
import com.bean.LFBean;
import com.dao.LoginDao;
import com.util.Email;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String user = request.getParameter("txtUserEmail");
			String pass = request.getParameter("pwdUserPassword");
			String time = request.getParameter("LoginTime");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("pass", pass);
			session.setAttribute("time", time);
			
			System.out.println( "password : " + pass + "	Login Time : "+  time);
			if( new LoginDao().getLoginUserValidationData(user, pass,time))
			{
				System.out.println("User Login Sucessfully......");
				System.out.println("new Session id : " + session.getId());
				response.sendRedirect("home.jsp");
			}
			else
			{
				request.setAttribute("invalid","User Or Password Invalid..........");
				System.out.println("sorry!!  User Login UnSucessfull......");	
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
	}
}
