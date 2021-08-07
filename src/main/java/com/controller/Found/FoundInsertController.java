package com.controller.Found;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.FoundDao;
import com.dao.LostDao;
@WebServlet("/FoundInsertController")
public class FoundInsertController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name= request.getParameter("txtUserName");
		String dept= request.getParameter("txtUserDepartment");
		String field= request.getParameter("z");
		String prop= request.getParameter("txtPropertyName");
		String place= request.getParameter("txtPlace");
		String identity= request.getParameter("txtPropertySign");
		int contact= Integer.parseInt(request.getParameter("txtUserContact"));
		String email= request.getParameter("txtUserEmail");
		String submit = request.getParameter("submit");
		String collectFrom = request.getParameter("collectFrom");
		String time = request.getParameter("date");
//		create table foundprop(fid serial primary key,name varchar(30),dept varchar(20),field varchar(20),prop varchar(50),place varchar(200),identity varchar(200),contact int(10),email varchar(30),submit varchar(10),collectfrom varchar(200),time varchar(50));
		LFBean bean = new LFBean();
		
		bean.setContact(contact);
		bean.setDept(dept);
		bean.setEmail(email);
		bean.setField(field);
		bean.setIdentity(identity);
		bean.setName(name);
		bean.setPlace(place);
		bean.setProp(prop);
		bean.setCollection(collectFrom);
		bean.setSubmit(submit);
		bean.setDate(time);
		PrintWriter out = response.getWriter();
		if(new FoundDao().insertFoundProperty(bean))
		{
			out.println("<html><body><font color=red size='10px'>Data entered sucessfully.......</font><body></html>");
			request.getRequestDispatcher("Enter.jsp").include(request, response);
		}
		else
		{
			out.println("oops! Data not entered....");
			response.sendRedirect("Enter.jsp");
		}
	}
}