package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuDropDownPage;

public class UserMenuDropDownTest extends BaseTest
{
	WebDriver driver;
	String url;
	UserMenuDropDownPage usermenudropdownpage;
	
  @BeforeMethod
  public void beforemethod() throws IOException
	{
		driver = getDriver("chrome"); 
		url = getUrl();
		driver.get(url);
		usermenudropdownpage = new UserMenuDropDownPage(driver);
	}
  
  @Test
  public void usermenudropdown() throws InterruptedException
  {
	  usermenudropdownpage.enterinemail();
	  usermenudropdownpage.enterinpassword();
	  usermenudropdownpage.clicklogin();
	  usermenudropdownpage.clickusermenu();
	  usermenudropdownpage.dropdownverification();
  }
  
  @AfterMethod
	public void teardown()
	{
		takescreenshot(driver);// pass the driver 
		driver.close(); 
	}
	
}
