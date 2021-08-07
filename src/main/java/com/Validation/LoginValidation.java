package com.Validation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bean.LFBean;
import com.dao.LoginDao;

public class LoginValidation 
{
	public boolean LoginValidate(String user,String Pass)
	{	
		if(user.equals(bean.getUser()))
		{
			if(Pass.equals(bean.getPass()))
			{
				flag = true;
			}
		}
		return flag;
	}
}
