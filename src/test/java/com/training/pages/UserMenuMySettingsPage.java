package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class UserMenuMySettingsPage extends BasePage {

	public UserMenuMySettingsPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "username")
	WebElement email;
	
	@FindBy(xpath = "//span[@id='idcard-identity']")
	WebElement useremailelement;

	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='r4 fl mr8']")
	WebElement rememberme;

	@FindBy(id= "Login")
	WebElement login;
	
	@FindBy(id="userNav")
	WebElement userhover;
	
	@FindBy(xpath="//a[text()='Developer Console']")
	WebElement developerconsole;
	
	@FindBy(xpath="//a[text()='My Settings']")
	WebElement mysettings;
	
	
	@FindBy(xpath="//div[@id='AutoNumber5']/div")
	 List<WebElement> displayandlayout;
	
	@FindBy(xpath="//div[@id='DisplayAndLayout_child']/div")
	 List<WebElement> customizemytabs;
	
	@FindBy(id="p4")
	WebElement customapp;
	  
	
	@FindBy(xpath="//select[@id='duel_select_0']/option")
	List<WebElement> availabletabs;
	
	@FindBy(xpath="//td[@class='zen-phs buttonCell']/div/a/img")
	List<WebElement> addbutton;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']/input")
	List<WebElement> save;
	
	@FindBy(id="EmailSetup_font")
	WebElement clickonemail;
	
	@FindBy(id="EmailSettings_font")
	WebElement emailsettings;
	
	@FindBy(id="sender_name")
	WebElement enteremailname;
	
	@FindBy(id="sender_email")
	WebElement enteremailaddress;
	
	@FindBy(id="auto_bcc1")
	WebElement radiobuttonyes;
	
	
	@FindBy(xpath="//input[@value=' Save ']")
	WebElement saveemailsettings;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutelement;
	
	public void enterinemail() 
	{
		explicitwait(10,email);
		email.sendKeys("harneetkaur@capitalforce.com ");
	}

	public void enterinpassword()
	{
		password.sendKeys("Hello@123");
	}
	public void clickRememberMe() throws InterruptedException
	{
		rememberme.click();
	}
	

	public void clicklogin()
	{
		login.click();
	}
	
	public void usermenudropdown()
	{
		userhover.click();
	}
	
	public void clickOnDeveloperConsoleAndValidate()
	{
		developerconsole.click();
		String parenttitle= driver.getTitle();
		String parentwindow= driver.getWindowHandle();
		for(String handle : driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		String developerconsoletitle = driver.getTitle();
		System.out.println("DeveloperConsole Title: "+developerconsoletitle);
		driver.close();//closes the child window . driver.quit will close all windows
	}
	
	
	public void mysettingsclick() throws InterruptedException
	{
		Thread.sleep(5000);
		mysettings.click();
	}
	public void displayandlayout()
	{
		for(WebElement element: displayandlayout) // we call each element inside the list 
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Display & Layout"))// we check our element with if condition
			{
				element.click(); 
				break;  
			}
		}
	}
	
	public void customizetab()
	{
		for(WebElement element:customizemytabs)
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Customize My Tabs"))
			{
				element.click();
				break;
			}
		}
		
	}
	public void customapp()
	{
		Select dropdownoptions = new Select(customapp);
		dropdownoptions.selectByVisibleText("Salesforce Chatter");
	}
	public void availabletab()
	{
		for(WebElement element:availabletabs)
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Reports"))
			{
				element.click();
				break;
			}
		}
	}
	public void addbutton()
	{
		for(WebElement element:addbutton)
		{
			System.out.println(element.getAttribute("title"));
			if(element.getAttribute("title").equalsIgnoreCase("Add"))
			{
				element.click();
				break;
			}
		}
	}
	public void saveclick()
	{
		for(WebElement element:save)
		{
			System.out.println(element.getAttribute("title"));
			if(element.getAttribute("title").equalsIgnoreCase("Save"))
			{
				element.click();
				break;
			}
		}
	
	}
	public void clickemail() 
	{
		clickonemail.click();
	}
	public void clickemailsettings() throws InterruptedException
	{
		Thread.sleep(2000);
		emailsettings.click();
	}
	public void enteremailname() 
	{
		enteremailname.clear();
		enteremailname.sendKeys("Harneet Kaur");
	}
	public void enteremailid () 
	{
		enteremailaddress.clear();
		enteremailaddress.sendKeys("chdniti@gmail.com");
	}
	public void clickonbccyes()
	{
		radiobuttonyes.click();
	}
	public void saveemailsetting()
	{
		saveemailsettings.click();
	}
	public void clickOnLogout()
	{
		logoutelement.click();
	}
	public void validateLogoutWithUsernameDispalyed() throws InterruptedException
	{
		Thread.sleep(5000);
		useremailelement.getText();
		
		String actualvalue = useremailelement.getText();
		String expectedvalue = "harneetkaur@capitalforce.com";
		if (actualvalue.equals(expectedvalue)) 
		{
			System.out.println("Username Validated: " + actualvalue);
		} 
		else 
		{
			System.out.println("Username Validation Failed");
		}
		
	}
}

