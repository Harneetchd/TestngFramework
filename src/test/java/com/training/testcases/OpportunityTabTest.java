package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.OpportunityTabPage;

public class OpportunityTabTest extends BaseTest
{
	WebDriver driver;
	String url;
	OpportunityTabPage opportunityTabPage;
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver= getDriver("chrome");
		url= getUrl();
		driver.get(url);
		opportunityTabPage = new OpportunityTabPage(driver);
	}
	
	@Test
	public void opportunityDropDownValidate() throws InterruptedException
	{
		opportunityTabPage.enterinemail();
		opportunityTabPage.enterinpassword();
		opportunityTabPage.clicklogin();
		opportunityTabPage.clickOnOpportunityTab();
		opportunityTabPage.clickOnNoThanks();
		opportunityTabPage.clickOnPromptDisplay();
		opportunityTabPage.clickSubmit();
		opportunityTabPage.clickOnOpportunityDropdownValidation();
	}
	@Test
	public void stuckOpportunityReport() throws InterruptedException
	{
		opportunityTabPage.enterinemail();
		opportunityTabPage.enterinpassword();
		opportunityTabPage.clicklogin();
		opportunityTabPage.clickOnOpportunityTab();
		opportunityTabPage.clickOnNoThanks();
		opportunityTabPage.clickOnPromptDisplay();
		opportunityTabPage.clickSubmit();
		opportunityTabPage.clickOnStuckOpportunityAndValidate();
		
	}
	@Test
	public void quarterlySummary() throws InterruptedException
	{
		opportunityTabPage.enterinemail();
		opportunityTabPage.enterinpassword();
		opportunityTabPage.clicklogin();
		opportunityTabPage.clickOnOpportunityTab();
		opportunityTabPage.clickOnNoThanks();
		opportunityTabPage.clickOnPromptDisplay();
		opportunityTabPage.clickSubmit();
		opportunityTabPage.quarterlySummery();
	}
	@Test
	public void teardown()
	{
		//takescreenshot(driver);
		driver.close();
	}
}
