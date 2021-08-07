package com.controller.Lost;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LostDao;
@WebServlet("/LostDeleteController")
public class LostDeleteController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id =Integer.parseInt(request.getParameter("id"));
		if(new LostDao().deleteProp(id))
		{
			response.sendRedirect("LostRetriveController");
		}
		else
		{
			response.sendRedirect("LostRetriveController");
		}
	}

}
