package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.LoginDao;

@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String aname = request.getParameter("txtNewUserEmail");
		String apass = request.getParameter("pwdUserPassword");
		String date = request.getParameter("txtTodayDate");
		System.out.println("new acc " + aname + aname + date);
		
		LFBean bean = new LFBean();
		bean.setUser(aname);
		bean.setPass(apass);
		bean.setDate(date);
		
		if(new LoginDao().NewAccount(bean))
		{
			System.out.println("Account Created...........");
			response.sendRedirect("login.jsp");
		}
		else
		{
			System.out.println("Account Creation Failed...........");
			request.setAttribute("failed", "try again.........");
			request.getRequestDispatcher("CreateAccount.jsp").include(request, response);
		}
	}
}