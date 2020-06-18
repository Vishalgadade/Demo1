package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement Loginbtn;
		
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	public void setUsername(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickButton()
	{
		Loginbtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
