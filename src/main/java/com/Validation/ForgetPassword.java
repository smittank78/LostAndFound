package com.Validation;

import java.util.Random;

public class ForgetPassword 
{
	Random random = new Random();
	public static void main(String[] args) 
	{
		System.out.println(new ForgetPassword().OTP());
		System.out.println(new ForgetPassword().Password());
	}
	public int OTP()
	{
		int otp = random.nextInt(8999) + 1000 ;
		return otp;
	}
	public String Password()
	{
		String pass = "";
		for(int i=0;i<2;i++)
		{
			char upper = (char) (random.nextInt(26) + 'A');
			char lower = (char) (random.nextInt(26) + 'a');
			int num = random.nextInt(9);
			String symbolList = "!@#$%^&*()_+={}|[]:><?';/.,'";
			char symbol = symbolList.charAt(random.nextInt(symbolList.length()));
			pass = pass+ String.valueOf(upper) + String.valueOf(lower) + String.valueOf(num) + String.valueOf(symbol) ;
		}
		String password = "";
		for(int j=0;j<=7;j++)
		{
			password = password + String.valueOf(pass.charAt(random.nextInt(pass.length())));
		}
		return password;
	}
}