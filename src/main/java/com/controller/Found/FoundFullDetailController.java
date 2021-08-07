package com.controller.Found;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.FoundDao;

@WebServlet("/FoundFullDetailController")
public class FoundFullDetailController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("fId"));
		System.out.println("full detail controller.......");
		LFBean bean = new FoundDao().searchFoundPropDetail(id);
		System.out.println(id + "	" + bean.getName());
		request.setAttribute("fullDetail", bean);
		request.getRequestDispatcher("fullDetailPage.jsp").forward(request, response);
	}
}