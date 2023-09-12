package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class SFDC_loginPage extends BasePage
{
	public SFDC_loginPage (WebDriver driver)
	{
		super(driver);
	}
 
	@FindBy(id = "username")
	WebElement email;
	
	
	@FindBy(id="password")
	WebElement enterpassword;
	
	@FindBy(xpath="//input[@class='r4 fl mr8']")
	WebElement rememberme;
	
	@FindBy(id="Login")
	WebElement login;
	
	@FindBy(id="userNav")
	WebElement usermenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	WebElement populatedusername;
	

	public void enterIntoUsername() throws InterruptedException
	{
		Thread.sleep(1000);
		email.sendKeys("harneetkaur@capitalforce.com");
	}
	public void clearPassword()
	{
		enterpassword.clear();
	}
	public void enterIntoPassword()
	{
		enterpassword.sendKeys("benihina@1018");
	}
	public void checkrememberMe()
	{
		rememberme.clear();
	}
	public void clickRememberMe() throws InterruptedException
	{
		rememberme.click();
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickonusermenu() throws InterruptedException
	{
		Thread.sleep(8000);
		usermenu.click();
	}
	public void clickOnLogout()
	{
		logout.click();
	}
	
	
	public void validateLoginErrorMessage()
	{
		String actualvalue=driver.getTitle();
		String expectedvalue= "Login | Salesforce";
		Assert.assertEquals(actualvalue, expectedvalue);
		if(actualvalue.equals(expectedvalue))
			{
			  System.out.println("Test:Salesforce login Page Success");
			}
		else
			{
			  System.out.println("Test:Salesforce login Page Fail");
			}
	}
	public void validateLoginSuccessMessage()
	{
		String expectedvalue = "Home Page ~ Salesforce - Developer Edition";
		String actualvalue = driver.getTitle();
		
		if(actualvalue.equals(expectedvalue))
			
			System.out.println("Success: "+actualvalue);
		else
			System.out.println("Fail");

	}
	public void validateusername() throws InterruptedException 
	{
		Thread.sleep(5000);
		String actualvalue = populatedusername.getText();
		String expectedvalue = "harneetkaur@capitalforce.com";
		if (actualvalue.equals(expectedvalue)) 
		{
			System.out.println("Username Validated: " + actualvalue);
		} else 
		{
			System.out.println("Username Validation Failed");
		}
	}
}

