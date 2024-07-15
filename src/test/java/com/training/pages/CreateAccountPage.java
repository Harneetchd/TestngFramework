package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage
{
   public CreateAccountPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(id = "username")
	WebElement email;
   
   @FindBy(id = "password")
	WebElement password;
   
   @FindBy(id= "Login")
	WebElement login;
   
   @FindBy(xpath="//a[@title='Accounts Tab']")
   WebElement accountstabelement;
   
   @FindBy(xpath="//div[@class='buttonBar']/input")
   List<WebElement> nothankselement;
   
   @FindBy(xpath="//div[@class='displayContent screen']/fieldset/div/span")
  List<WebElement> promptdisplayelement;
   
   @FindBy(id="lexSubmit")
   WebElement submitelement;
   
   @FindBy(id="fcf")
   WebElement view ;
   
   @FindBy(xpath="//a[text()='Edit']")
   WebElement edit;
   
   @FindBy(id="fcol1")
   WebElement filterfield;
   
   @FindBy(id="fop1")
   WebElement operator;
   
   @FindBy(id="fval1")
   WebElement value;
   
   @FindBy(xpath="//td[@class='pbButtonb']/input")
    List<WebElement> clicksave;
   
   @FindBy(xpath="//a[text()='Create New View']")
   WebElement createnewview ;
   
   @FindBy(id="fname")
   WebElement viewname ;
   
   @FindBy(id="devname")
   WebElement viewuniquename;
   
   @FindBy(xpath="//input[@data-uidsfdc='4']")
   WebElement save;
   
   @FindBy(xpath="//input[@value=' New ']")
   WebElement newaccountelement;
   
   @FindBy(id="acc2")
   WebElement accountnameelement;
   
   @FindBy(id="acc6")
   WebElement typeelement;
   
   @FindBy(id="00N5f00000Shnzk")
   WebElement customerpriorityelement;
   
   @FindBy(xpath="//td[@id='bottomButtonRow']/input")
   List<WebElement> saveelement;
   
   @FindBy(xpath="//div[@class='toolsContentRight']/div/div/ul/li/span")
   List<WebElement> mergeaccount;
   
   @FindBy(id="srch")
   WebElement enteraccountname;
   
   @FindBy(xpath="//input[@value='Find Accounts']")
   WebElement findaccounts;
   
   @FindBy(id="cid0")
   WebElement checkbox1;
   
   @FindBy(id="cid1")
   WebElement checkbox2;
   
   @FindBy(xpath=" //input[@value=' Next '] ")
   WebElement next;
   
   @FindBy(xpath="//input[@value=' Merge ']")
   WebElement merge;
   
   public void enterinemail() 
	{
		explicitwait(10,email);
		email.sendKeys("harneetkaur@capitalforce.com ");
	}

	public void enterinpassword()
	{
		password.sendKeys("Hello@1234");
	}
	
	public void clicklogin()
	{
		login.click();
	}
   
   
   public void clickAccountsTab()
   {
	   accountstabelement.click();
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
   
   public void clickOnCreateNewView()
   {
	   createnewview.click();
   }
   
   public void enterInViewName()
   {
	   viewname.sendKeys("The Accounts");
   }
   
   public void enterViewUniqueName()
   {
	   viewuniquename.sendKeys("ACC");
   }
   public void clickOnSave()
   {
	   save.click();
   }
   public void selectViewOptions()
   {
	   Select viewoptions= new Select(view);
	   viewoptions.selectByVisibleText("My Accounts");
   }
   public void clickOnEdit()
   {
	   edit.click();
   }
   public void enterIntoViewName()
   {
	   viewname.clear();
	   viewname.sendKeys("NewMyAccount");	
   }
   public void selectFilterField()
   {
	   Select fieldoptions= new Select(filterfield);
	   fieldoptions.selectByValue("ACCOUNT.NAME");
   }
   public void selectOperator()
   {
	   Select operatoroptions = new Select(operator);
	   operatoroptions.selectByVisibleText("contains");
   }
   public void enterIntoValue()
   {
	   value.sendKeys("a");
   }
   public void clickToSave()
   {
	   for(WebElement element : clicksave)
		{
			//System.out.println(element.getAttribute("value"));
			if(element.getAttribute("value").equalsIgnoreCase(" Save "))
			{
				element.click();
				break;
			}
		}
   }
   
   public void clickOnNewAccount()
   {
	   newaccountelement.click();
   }
   public void enterAccountName()
   {
	   accountnameelement.sendKeys("Tekarch2");
   }
   public void enterType()
   {
	   Select optiontype= new Select(typeelement); // Select class is imported as its a drop down
	   optiontype.selectByVisibleText("Technology Partner");//
   }
   public void enterPriority()
   {
	   Select priorityoptions= new Select(customerpriorityelement); // dropdown :select class
	   priorityoptions.selectByVisibleText("High");
   }
   public void clickOnSaveAndValidate()
   {
	   for(WebElement element:saveelement)
		{
			//System.out.println(element.getAttribute("value"));
			if(element.getAttribute("value").equalsIgnoreCase(" Save "))
			{
				element.click();
				String titlename= driver.getTitle();
				System.out.println(titlename);
				break;// Pass : New Account:Tekarch, type:TechnologyPartner , Priority:high  is created
			}
			
		}
   }
   public void clickOnMergeAccounts() throws InterruptedException
   {
	   for(WebElement element: mergeaccount)
		{
			//System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Merge Accounts"))
			{
				System.out.println(element.getText());
				Thread.sleep(1000);
				element.click();
				break;
			}
		}
   }
   public void enterIntoAccountName()
   {
	   enteraccountname.sendKeys("al");
   }
   public void clickOnFindAccounts()
   {
	   findaccounts.click();
   }
   public void clickOnCheck1()
   {
	   checkbox1.click(); 
   }
   public void clickOnCheck2()
   {
	   checkbox2.click(); 
   }
   public void clickOnNext()
   {
	   next.click();
   }
   public void clickOnMerge()
   {
	   merge.click();
	   
	   driver.switchTo().alert().accept();// PopUp accepted (ok clicked)
   }
}
