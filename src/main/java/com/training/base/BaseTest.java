package com.training.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.training.utilities.CommonUtlities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	CommonUtlities commonutil = new CommonUtlities();//create an object of CommonUtilities
    WebDriver driver;
	
    public WebDriver getDriver(String browser) throws MalformedURLException
    {
    	if(browser.equalsIgnoreCase("chrome"))
		{
    		
//    		 DesiredCapabilities caps = new DesiredCapabilities();
//    		 caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//    		 
//    		 driver = new RemoteWebDriver(new URL("http://3.143.173.157:4444/"),caps);
//    		
    		System.setProperty("webdriver.chrome.driver","/Users/harneetkaur/eclipse-workspace/TestNGFramework/mydriver/chromedriver");
			driver = new ChromeDriver();
		}
    	else if(browser.equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    		
    		// DesiredCapabilities caps = new DesiredCapabilities();
    		 
    		// caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
    		 
    		
    		// driver = new RemoteWebDriver(new URL("http://3.145.8.31:4444/wd/hub"),caps);
    		 
    	}
		return driver; // getDriver returns driver , thats why we aren't passing url
    }
    
    public String getUrl() throws IOException
    {
    	String url=commonutil.getProperty("qaurl");
    	return url;
    }
    
    public void takescreenshot(WebDriver driver)// pass the driver as we aren't storing WebDriver anywhwere
    {
    	//Takesscreenshot  interface: to get screenshot
    	TakesScreenshot  screenshot = ((TakesScreenshot) driver);// takes screen shot : Typecasting Driver to take screenshot
    	//file is stored as object, from screenshot 
    	File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);// Returns File
    	
    	// date is used to put at end of filepath: so we can get screenshots with timestamp
    	Date currentdate = new Date();  // import java.util
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentdate);
    	
    	// create folder screenshot in framework. Get the path + //blabla.jpeg or blabla.png
    	String filepath = "/Users/harneetkaur/eclipse-workspace/TestNGFramework/screenshots//Salesforce"+timestamp+ ".jpeg ";
    	
    	//create destination file to store the screenshot object
    	// source and destination are both in the format of file
    	File destinationfile = new File (filepath);
    	
        try 
        {
        	// convert file object to a physical file : Using FileUtils.copy
			FileUtils.copyFile(sourcefile, destinationfile); //  you can either do it with IO exception or surround with try/catch
		} 
        catch (IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
