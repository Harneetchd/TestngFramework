package com.training.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.logs.Log;
import com.training.pages.SFDC_loginPage;

public class SFDC_Test extends BaseTest
{
	WebDriver driver;
	String url;
	SFDC_loginPage sfdc_loginPage;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(@Optional("firefox") String browser) throws IOException
	{
		driver= getDriver(browser);
		url = getUrl();
		driver.get(url);
		sfdc_loginPage= new SFDC_loginPage(driver);
		//DOMConfigurator.configure("log4j.xml");
	//	Log.startTestCase("TestCaseLogin");
	}
	
	@Test
	public void loginError() throws InterruptedException
	{
		sfdc_loginPage.enterIntoUsername();
		sfdc_loginPage.clearPassword();
		sfdc_loginPage.clickOnLogin();
		sfdc_loginPage.validateLoginErrorMessage();
	}
	@Test
	public void loginSucess() throws InterruptedException
	{
		Log.info("I am Logging in.......");
		sfdc_loginPage.enterIntoUsername();
		sfdc_loginPage.enterIntoPassword();
		sfdc_loginPage.clickOnLogin();
		Log.info("I am DONE Logging in.......");
		sfdc_loginPage.validateLoginSuccessMessage();
	}
	@Test
	public void checkRememberMe() throws InterruptedException
	{
		sfdc_loginPage.enterIntoUsername();
		sfdc_loginPage.enterIntoPassword();
		sfdc_loginPage.clickRememberMe();
		sfdc_loginPage.clickOnLogin();
		sfdc_loginPage.clickonusermenu();
		sfdc_loginPage.clickOnLogout();
		sfdc_loginPage.validateusername();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//takescreenshot(driver);// pass the driver 
		driver.close(); 
	}

}
