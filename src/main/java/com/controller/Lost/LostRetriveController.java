package com.controller.Lost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.FoundDao;
import com.dao.LostDao;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.LostDao;
@WebServlet("/LostRetriveController")
public class LostRetriveController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LFBean> listOfProp = new ArrayList<LFBean>();
		listOfProp = new LostDao().showLostProp();
		
		List<LFBean> listOfFoundData = new ArrayList<LFBean>();
		listOfFoundData = new FoundDao().foundData();
		
		System.out.println("lost : " + listOfProp + "	found	" + listOfFoundData);
		
		request.setAttribute("LostProperties", listOfProp);
		request.setAttribute("FoundData", listOfFoundData);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}