package com.controller.otp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Validation.ForgetPassword;
@WebServlet("/ResetPasswordGetOtpController")
public class ResetPasswordGetOtpController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				int otp = new ForgetPassword().OTP();
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("otp",otp);
				System.out.println(otp);
				httpSession.setAttribute("newotp","new otp generated" );
				response.sendRedirect("otpVarification.jsp");
	}
}