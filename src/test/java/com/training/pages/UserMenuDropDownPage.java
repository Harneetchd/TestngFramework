package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class UserMenuDropDownPage extends BasePage{

	public UserMenuDropDownPage(WebDriver driver)
	{
		super(driver);
	}

	// Get Elements and corresponding Actions in Page
		@FindBy(id = "username")
		WebElement email;

		@FindBy(id = "password")
		WebElement password;

		@FindBy(id= "Login")
		WebElement login;
		
		@FindBy(id="userNav")
		WebElement usermenu;

		@FindBy(xpath="//div[@id='userNavMenu']/div[3]/a")
		List<WebElement>usermenudropdown;
		
		List<String> actualoptions= new ArrayList<String>();
		List<String> expectedoptions = new ArrayList<String>();
		
		
		//Corresponding Actions as follows:
		public void enterinemail() 
		{
			explicitwait(10,email);
			email.sendKeys("harneetkaur@capitalforce.com ");
		}

		public void enterinpassword()
		{
			password.sendKeys("benihina@1018");
		}

		public void clicklogin()
		{
			login.click();
		}
		public void clickusermenu() throws InterruptedException
		{
			Thread.sleep(2000);
			usermenu.click();
		}
		public void dropdownverification()
		{
			expectedoptions.add("My Profile");
			expectedoptions.add("My Settings");
			expectedoptions.add("Developer Console");
			expectedoptions.add("Switch to Lightning Experience");
			expectedoptions.add("Logout");
			for(WebElement element:usermenudropdown)
			{
				actualoptions.add(element.getText());
			}
			if(actualoptions.equals(expectedoptions))
			{
				System.out.println("Test Results:Validation Pass");
			}else
			{
				System.out.println("Test Results:Validation Fail");
			}
			
		}

}
