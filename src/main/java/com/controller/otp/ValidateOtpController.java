package com.controller.otp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Validation.ForgetPassword;
import com.dao.LoginDao;
import com.util.Email;
@WebServlet("/ValidateOtpController")
public class ValidateOtpController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int otp = Integer.parseInt(request.getParameter("otp"));
		String email = request.getParameter("mailI'd");
		HttpSession httpSession = request.getSession();
		System.out.println("set otp : " + httpSession.getAttribute("otp"));
		if(otp == (int)httpSession.getAttribute("otp"))
		{
			System.out.println("otp match");
			String newPasssword = new ForgetPassword().Password();
			String emailSended = new Email().email(email,"new Password ",newPasssword);
			if(emailSended == "done")
			{
				if(new LoginDao().enterNewPassword(email, newPasssword))
				{
					System.out.println("password changed sucessfully......");
					response.sendRedirect("login.jsp");
				}
				else
				{
					System.out.println("password not changed. try again ........");
				}
			}
			else
			{
				System.out.println("email not send...");
				response.sendRedirect("ResetPasswordGetOtpController");
			}
		}
		else
		{
			System.out.println("otp invalid");
			response.sendRedirect("otpVarification");
		}
	}

}