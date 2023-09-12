package com.training.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.SFDC_loginPage;

public class SFDC_Test extends BaseTest
{
	WebDriver driver;
	String url;
	SFDC_loginPage sfdc_loginPage;
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver= getDriver("chrome");
		url = getUrl();
		driver.get(url);
		sfdc_loginPage= new SFDC_loginPage(driver);
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
		sfdc_loginPage.enterIntoUsername();
		sfdc_loginPage.enterIntoPassword();
		sfdc_loginPage.clickOnLogin();
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
