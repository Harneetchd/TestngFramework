package com.training.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

public class HomeTest extends BaseTest 
{
	WebDriver driver;
	LoginPage loginpage;
	String url;
	HomePage homepage;
	
	@BeforeMethod
	public void beforemethod() throws IOException
	{
		driver = getDriver("chrome"); 
		url = getUrl();
		driver.get(url);
		loginpage = new LoginPage(driver);
	    homepage = new HomePage(driver);
	}
	
	@Test
	public  void enterfirstname()
	{
		loginpage.enterinemail();
		loginpage.enterinpassword();
		loginpage.clicklogin();
		homepage.clickhometab();
		homepage.entername();
	}
}
