package com.controller.Lost;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.LostDao;
@WebServlet("/LostFullDetailController")
public class LostFullDetailController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("lId"));
		LFBean bean = new LostDao().searchLostPropDetail(id);
		System.out.println("full : " + bean.getName());
		request.setAttribute("fullDetail", bean);
		request.getRequestDispatcher("fullDetailPage.jsp").forward(request, response);
	}
}