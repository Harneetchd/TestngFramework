package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.LeadsTabPage;

public class LeadsTabTest extends BaseTest
{
   WebDriver driver;
   String url;
   LeadsTabPage leadsTabpage;
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver= getDriver("chrome");
		url = getUrl();
		driver.get(url);
		leadsTabpage = new LeadsTabPage(driver);
	}
	
	@Test
	public void validateLeadTab()
	{
		leadsTabpage.enterinemail();
		leadsTabpage.enterinpassword();
		leadsTabpage.clicklogin();
		leadsTabpage.clickOnLeadTab();
		leadsTabpage.validateLeadTab();
	}
	@Test
	public void leadSelectView() throws InterruptedException
	{
		leadsTabpage.enterinemail();
		leadsTabpage.enterinpassword();
		leadsTabpage.clicklogin();
		leadsTabpage.clickOnLeadTab();
		leadsTabpage.clickOnNoThanks();
		leadsTabpage.clickOnPromptDisplay();
		leadsTabpage.clickSubmit();
		leadsTabpage.clickOnLeadView();
		leadsTabpage.validationLeadContent();
		leadsTabpage.clickOnUserMenu();
		leadsTabpage.clickLogout();
	}
	@Test
	public void leadDefaultView() throws InterruptedException
	{
		leadsTabpage.enterinemail();
		leadsTabpage.enterinpassword();
		leadsTabpage.clicklogin();
		leadsTabpage.clickOnLeadTab();
		leadsTabpage.clickOnNoThanks();
		leadsTabpage.clickOnPromptDisplay();
		leadsTabpage.clickSubmit();
		leadsTabpage.clickOnLeadView();
		leadsTabpage.selectUnreadLead();
		leadsTabpage.clickOnUserMenu();
		leadsTabpage.clickLogout();
		leadsTabpage.enterinemail();
		leadsTabpage.enterinpassword();
		leadsTabpage.clicklogin();
		leadsTabpage.clickOnLeadTab();
		//leadsTabpage.clickOnNoThanks();
		//leadsTabpage.clickOnPromptDisplay();
		//leadsTabpage.clickSubmit();
		leadsTabpage.clickOnGo();
		leadsTabpage.validateUnreadLeadPage();
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		//takescreenshot(driver);
		//driver.close();
	}
}
