package com.controller.Found;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoundDao;
@WebServlet("/FoundDeleteController")
public class FoundDeleteController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int fId = Integer.parseInt(request.getParameter("id"));		
		if(new FoundDao().deleteFoundData(fId))
		{
			System.out.println("data deleted sucessfully..............");
			response.sendRedirect("FoundRetriveController");
		}
		else
		{
			response.sendRedirect("FoundRetriveController");	
		}
	}
}