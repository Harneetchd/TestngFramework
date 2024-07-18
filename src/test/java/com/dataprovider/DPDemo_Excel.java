package com.dataprovider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.utilities.DataProviderUtils;
public class DPDemo_Excel {
	
	WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws Exception
    {
    	String userdir = System.getProperty("user.dir")+"\\resources\\chromedriver";
		userdir = userdir.replace("\\","\\\\");
		System.setProperty("webdriver.chrome.driver", (userdir));
    	driver = new ChromeDriver();
		driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
    }

	@Test(dataProvider="Authentication")
    public void Registration_data(String sUserName,String sPassword)throws  Exception
	{
        driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys(sUserName);
        driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys(sPassword);
        driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click();
	}
    @DataProvider
    public Object[][] Authentication() throws Exception
    {
         Object[][] testObjArray = DataProviderUtils.getTableArray("/Users/harneetkaur/eclipse-workspace/TestNGFramework/properties/data.xls","data");
         return (testObjArray);
    }
    
    @AfterMethod
    public void afterMethod() 
	{

		driver.close();

	}

 }