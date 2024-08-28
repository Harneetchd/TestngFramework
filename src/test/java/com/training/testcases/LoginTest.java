package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.logs.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtlities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest
{
	WebDriver driver;
	LoginPage loginpage;
	String browserUrl;
	HomePage homepage;
	
	@BeforeMethod
	@Parameters("browser")
	public void beforemethod(@Optional("firefox") String browser) throws IOException
	{
		driver = getDriver(browser); 
		browserUrl = getUrl();
		driver.get(browserUrl);
		loginpage = new LoginPage(driver);
	    homepage = new HomePage(driver);
	    DOMConfigurator.configure("log4j.xml");
	    Log.startTestCase("TestCheck1");
	}
	// Test should contain  : Steps & Data
	// Data can be taken from:
	// 1) Property Files; 2) Parameters from TestNg.xml; 3) Excel Sheets.
	@Test
	public void login()
	{
		
		Log.info("I am Logging in....");
		loginpage.enterinemail();
		loginpage.enterinpassword();
		loginpage.clicklogin();
		Log.info("Now,I am logged in");
		homepage.clickhometab();
	}
	
	@Test
	public void loginandclickonhometab() {
		loginpage.enterinemail();
		loginpage.enterinpassword();
		loginpage.clicklogin();
		homepage.clickhometab();
	}
	
	@AfterMethod
	public void teardown()
	{
		takescreenshot(driver);// pass the driver 
		driver.close(); 
	}
}
