package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.BasePage;

public class LeadsTabPage extends BasePage 
{

	public LeadsTabPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id = "username")
	  WebElement email;
	   
	 @FindBy(id = "password")
	 WebElement password;
	   
	 @FindBy(id= "Login")
	 WebElement login;
	 
	 @FindBy(xpath="//a[text()='Leads']")
	 WebElement leadtab;
	
	 @FindBy(xpath="//div[@class='buttonBar']/input")
	  List<WebElement> nothankselement;
	   
	  @FindBy(xpath="//div[@class='displayContent screen']/fieldset/div/span")
	  List<WebElement> promptdisplayelement;
	   
	  @FindBy(id="lexSubmit")
	  WebElement submitelement;
	  
	  @FindBy(xpath="//select[@id='fcf']")
	  WebElement leadsContentView;
	  
	  @FindBy(xpath="//select[@id='fcf']/option")
	  WebElement viewleaddropdown;
	  
	  @FindBy(xpath="//select[@id='fcf']/option")
	  List<WebElement> unreadlead;
	  
	  @FindBy(id="userNav")
	   WebElement usermenu;
	  
	  @FindBy(xpath="//a[text()='Logout']")
	  WebElement clicklogout;
	  
	  @FindBy(xpath="//input[@title='Go!']")
	  WebElement clickgo;

	  @FindBy(xpath="//select[@id='00B5f00000GkRlt_listSelect']/option")
	  List<WebElement> validateunreadlead;
	  
	 public void enterinemail() 
		{
			explicitwait(10,email);
			email.sendKeys("harneetkaur@capitalforce.com ");
		}

		public void enterinpassword()
		{
			password.sendKeys("Hello@123");
		}
		
		public void clicklogin()
		{
			login.click();
		}
		public void clickOnLeadTab()
		{
			leadtab.click();
		}
		
		public void clickOnNoThanks() throws InterruptedException
		   {
			   Thread.sleep(1000);
			   for(WebElement element: nothankselement)//the pop up inside table
				{
					//System.out.println(element.getAttribute("value"));
					if(element.getAttribute("value").equalsIgnoreCase("No Thanks"))
					{
						element.click();
						break;
					}
				}
		   }
		
		public void clickOnPromptDisplay()
		   {
			   for(WebElement element:promptdisplayelement ) // nextpage display
				{
					//System.out.println(element.getText());
					if(element.getText().equalsIgnoreCase("My team/company doesn't use Lightning Experience"))
					{
						element.click();
						break;
					}
				}
				
		   }
		public void clickSubmit()
		   {
			   submitelement.click();
		   }
		public void validateLeadTab()
		{
			String actualvalue= driver.getTitle();
			String expectedvalue= "Leads: Home ~ Salesforce - Developer Edition";
			if(actualvalue.equals(expectedvalue))
			{
				System.out.println("Lead Title Page Successful :"+actualvalue);
			}else
			{
				System.out.println("Lead Title Page Fail :"+actualvalue);
			}
		}
		public void clickOnLeadView()
		{
			leadsContentView.click();
		}
		public void validationLeadContent()
		{
			List<String>expectedoptions= new ArrayList<String>();
			List<String>actualoptions= new ArrayList<String>();
			expectedoptions.add("All Open Leads");
			expectedoptions.add("My Unread Leads");
			expectedoptions.add("Recently Viewed Leads");
			expectedoptions.add("Today's Leads");
			expectedoptions.add("View - Custom 1");
			expectedoptions.add("View - Custom 2");
			
			List<WebElement> viewleaddropdown= driver.findElements(By.xpath("//select[@id='fcf']/option"));
			for (WebElement element : viewleaddropdown)
			{
				actualoptions.add(element.getText());
			}
			if (actualoptions.equals(expectedoptions))
			{
				System.out.println(" Lead view content Pass: Dropdown Verified "+ actualoptions);
			}else
			{
				System.out.println(" Lead view content Fail");
			}
		}
		public void selectUnreadLead()
		{
			for(WebElement element : unreadlead)
			{
				if(element.getText().equalsIgnoreCase("My Unread Leads"))
				{
					System.out.println(element.getText());
					element.click();
					break;
				}
			}
		}
		public void clickOnGo()
		{
			clickgo.click();
		}
		public void validateUnreadLeadPage()
		{
			for(WebElement element : validateunreadlead)
			{
				if(element.getText().equalsIgnoreCase("My Unread Leads"))
				{
					System.out.println("Default view is Selected :"+element.getText());
					break;
				}
			}
		}
		public void clickOnUserMenu()
		{
			explicitwait(20,usermenu);
			usermenu.click(); 	
		}
		public void clickLogout()
		{
			clicklogout.click();
		}
		
}
