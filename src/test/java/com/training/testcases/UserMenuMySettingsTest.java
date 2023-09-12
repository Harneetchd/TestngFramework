package com.training.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.UserMenuDropDownPage;
import com.training.pages.UserMenuMySettingsPage;

public class UserMenuMySettingsTest extends BaseTest
{
	WebDriver driver;
	String url;
	UserMenuMySettingsPage usermenusettingspg;

	@BeforeMethod
	  public void beforemethod() throws IOException
		{
			driver = getDriver("chrome"); 
			url = getUrl();
			driver.get(url);
			usermenusettingspg = new UserMenuMySettingsPage(driver);
		}

	@Test
	public void usermenusettings() throws InterruptedException
	{
		usermenusettingspg.enterinemail();
		usermenusettingspg.enterinpassword();
		usermenusettingspg.clicklogin();
		usermenusettingspg.usermenudropdown();
		usermenusettingspg.mysettingsclick();
		usermenusettingspg.displayandlayout();
		usermenusettingspg.customizetab();
		usermenusettingspg.customapp();
		usermenusettingspg.availabletab();
		usermenusettingspg.addbutton();
		usermenusettingspg.saveclick();
	}
	@Test
	public void emailsettings() throws InterruptedException
	{
		usermenusettingspg.enterinemail();
		usermenusettingspg.enterinpassword();
		usermenusettingspg.clicklogin();
		usermenusettingspg.usermenudropdown();
		usermenusettingspg.mysettingsclick();
		usermenusettingspg.clickemail();
		usermenusettingspg.clickemailsettings();
		usermenusettingspg.enteremailname();
		usermenusettingspg.enteremailid();
		usermenusettingspg.clickonbccyes();
		usermenusettingspg.saveemailsetting();
		
	}
	@Test
	public void validateDeveloperConsole()
	{
		usermenusettingspg.enterinemail();
		usermenusettingspg.enterinpassword();
		usermenusettingspg.clicklogin();
		usermenusettingspg.usermenudropdown();
		usermenusettingspg.clickOnDeveloperConsoleAndValidate();
	}
	@Test
	public void logoutValidation() throws InterruptedException
	{
		usermenusettingspg.enterinemail();
		usermenusettingspg.enterinpassword();
		usermenusettingspg.clickRememberMe();
		usermenusettingspg.clicklogin();
		usermenusettingspg.usermenudropdown();
		usermenusettingspg.clickOnLogout();
		usermenusettingspg.validateLogoutWithUsernameDispalyed();
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//takescreenshot(driver);// pass the driver 
		//driver.close(); 
	}
}
