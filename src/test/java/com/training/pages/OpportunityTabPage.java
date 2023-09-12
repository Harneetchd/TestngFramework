package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunityTabPage extends BasePage
{
	public OpportunityTabPage(WebDriver driver) 
	{
         super(driver);
	}
	 @FindBy(id = "username")
	  WebElement email;
	   
	 @FindBy(id = "password")
	 WebElement password;
	   
	 @FindBy(id= "Login")
	 WebElement login;
	 
	 @FindBy(xpath="//a[text()='Opportunities']")
	 WebElement opportunitytab;
	 
	 @FindBy(xpath="//div[@class='buttonBar']/input")
	  List<WebElement> nothankselement;
	   
	  @FindBy(xpath="//div[@class='displayContent screen']/fieldset/div/span")
	  List<WebElement> promptdisplayelement;
	   
	  @FindBy(id="lexSubmit")
	  WebElement submitelement;
	  
	  @FindBy(xpath="//a[text()='Stuck Opportunities']")
	  WebElement clickonstuckopportunity;
	  
	  @FindBy(id="fcf")
	  WebElement oppportunitydropdown;
	  
	  @FindBy(id="quarter_q")
	  WebElement intervalclick;
	  
	  @FindBy(id="open")
	  WebElement includeclick;
	  
	  @FindBy(xpath="//input[@value='Run Report']")
	  WebElement clickonreport;
	  
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
		public void clickOnOpportunityTab()
		{
			opportunitytab.click();
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
		
		public void clickOnOpportunityDropdownValidation()
		{
			oppportunitydropdown.click();
			List<String> expectedoptions = new ArrayList<String>() ;
			List<String> actualoptions= new ArrayList<String>();
			expectedoptions.add("All Opportunities");
			expectedoptions.add("Closing Next Month");
			expectedoptions.add("Closing This Month");
			expectedoptions.add("My Opportunities");
			expectedoptions.add("New Last Week");
			expectedoptions.add("New This Week");
			expectedoptions.add("Opportunity Pipeline");
			expectedoptions.add("Private");
			expectedoptions.add("Recently Viewed Opportunities");
			expectedoptions.add("Won");
			
			List<WebElement> dropdownoptions = driver.findElements(By.xpath("//select[@id='fcf']/option"));
			for(WebElement element : dropdownoptions)
			{
				actualoptions.add(element.getText());
			}
			if (actualoptions.equals(expectedoptions))
			{
				System.out.println("Test Pass: Dropdown Verified");
			}else
			{
				System.out.println("Test Fail");
			}
			
		}
		public void clickOnStuckOpportunityAndValidate()
		{
			clickonstuckopportunity.click();
			String stuckopptitle=driver.getTitle();
			System.out.println("Valid Title :"+stuckopptitle);
		}
		public void clickOnInterval()
		{
			intervalclick.click();
			
			//intervaldropdown.selectByIndex(i);
		}
		public void clickOnInclude()
		{
			includeclick.click();
			Select includedropdown= new Select(includeclick);
			//includedropdown.selectByIndex(j);
		}
		public void clickOnReport()
		{
			clickonreport.click();
			String actualtitle = driver.getTitle();
			String expectedvalue = "Opportunity Report ~ Salesforce - Developer Edition";
			
			if(actualtitle.equals(expectedvalue))
			{
				System.out.println("Valid Title :"+actualtitle);
			}else
			{
				System.out.println("Invalid Title");
			}
			
			opportunitytab.click();	
		}
		public void quarterlySummery()
		{
			int n1=10;
			int n2= 4;
			for(int i=0; i<=n1-1;i++)
			{
				Select intervaldropdown = new Select(intervalclick);
				intervaldropdown.selectByIndex(i);
				
				for(int j=1;j<=n2-1;j++)
				{
					Select includedropdown= new Select(includeclick);
					includedropdown.selectByIndex(j);
					
					
					clickonreport.click();
					String actualtitle = driver.getTitle();
					String expectedvalue = "Opportunity Report ~ Salesforce - Developer Edition";
					
					if(actualtitle.equals(expectedvalue))
					{
						System.out.println("Valid Title :"+actualtitle);
					}else
					{
						System.out.println("Invalid Title");
					}
					
					opportunitytab.click();	
				}
			}
			
		}
}
