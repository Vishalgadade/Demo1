package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC001_Login extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		
		logger.info("url is opened");
		//driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("usrname is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		
		lp.clickButton();
		
		System.out.println(driver.getTitle());		
		if(driver.getTitle().equals("Guru9 Bank Manager HomePage"))
			Assert.assertTrue(true);
		else
		{
				
		captureScreen(driver, "logintest");
		Assert.assertTrue(false);
		logger.info("logintest is failed");
		}
	}

}
