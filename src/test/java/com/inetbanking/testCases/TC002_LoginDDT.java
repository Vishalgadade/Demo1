package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC002_LoginDDT extends BaseClass {
	
	@Test(dataProvider="Logindata")
	public void loginDDT(String uname, String pwd) throws IOException, InterruptedException
	{
		
		logger.info("url is opened");
		//driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("usrname is entered");
		lp.setPassword(pwd);
		logger.info("password is entered");
		
	     lp.clickButton();
	     Thread.sleep(3000);
	     
	     if(isAlertPresent()==true)
	     {
	    	 captureScreen(driver, "loginDDT");
	    	 Thread.sleep(3000);
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	    	 logger.info("logintest is failed");
	 		 Assert.assertTrue(false);
			 
	     }
	     
	     else
	     {
	    	 Assert.assertTrue(true);
	    	 lp.clickLogout();
	    	 Thread.sleep(3000);
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	     }
		
	}
	
	
	public boolean isAlertPresent() //user defined method to check alert presence
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name="Logindata")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir") +"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum] [colcount];
		
		for(int i=1;i<=rownum;i++)
			
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
	}
}
