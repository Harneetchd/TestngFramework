package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.BasePage;

public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver) 
	{   
		super(driver); // passing constructor
	}

	@FindBy(xpath="//a[text()='Home']")
	WebElement hometab ;// getting the element
	
	@FindBy(id="name")
	WebElement name;
	
	
	public void clickhometab()
	{
		explicitwait(500,hometab); 
		hometab.click();// corresponding action
	}
	
	public void entername()
	{
		name.sendKeys("Harry ");
	}
}
