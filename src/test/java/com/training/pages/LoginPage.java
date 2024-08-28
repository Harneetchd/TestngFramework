package com.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage 
{
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	// Get Elements and corresponding Actions in Page
	@FindBy(id = "email_field")
	WebElement email;

	@FindBy(id = "password_field")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')] ")
	WebElement login;

	public void enterinemail() 
	{
		explicitwait(800,email);
		email.sendKeys("admin123@gmail.com");
	}

	public void enterinpassword()
	{
		password.sendKeys("admin123");
	}

	public void clicklogin()
	{
		login.click();
	}

}

	  