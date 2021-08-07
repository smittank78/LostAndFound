package com.controller.Lost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LFBean;
import com.dao.LostDao;
@WebServlet("/LostInsertController")
public class LostInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name= request.getParameter("txtUserName");
		String dept= request.getParameter("txtUserDepartment");
		String field= request.getParameter("txtUserProfession");
		String prop= request.getParameter("txtPropertyName");
		String place= request.getParameter("txtPlace");
		String identity= request.getParameter("txtPropertySign");
		int contact= Integer.parseInt(request.getParameter("txtUserContact"));
		String email= request.getParameter("txtUserEmail");
			
		LFBean bean = new LFBean();
		
		bean.setContact(contact);
		bean.setDept(dept);
		bean.setEmail(email);
		bean.setField(field);
		bean.setIdentity(identity);
		bean.setName(name);
		bean.setPlace(place);
		bean.setProp(prop);
		
		PrintWriter out = response.getWriter();
		if(new LostDao().enterLostProp(bean))
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
