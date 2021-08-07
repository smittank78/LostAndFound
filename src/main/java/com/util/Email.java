package com.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email 
{
	public String email(String recipent,String subject,String Msg)
	{
		final String from= "sjtank.781@gmail.com";
		final String pass = "java7801";
		final String sub = subject;
		final String msg = Msg;
		System.out.println("email.........");
		Properties properties = new Properties();
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.EnableSSL.enable", "true");
		
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.auth", "true");
		System.out.println("properties ..............");
		Session session = Session.getDefaultInstance(properties,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, pass);
			}
																					});
		System.out.println("session created..........");
		MimeMessage mimeMessage = new MimeMessage(session);
		try 
		{
			System.out.println("try........");
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipent));
			mimeMessage.setSubject(sub);
			mimeMessage.setText(msg);
			
			Transport.send(mimeMessage);
			System.out.println("mail sended.......");
		} 
		catch (AddressException e)
		{
			e.printStackTrace();
		} 
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
		return "done";
	}
	public static void main(String[] args)
	{
	//	new Email().email();
	}
}