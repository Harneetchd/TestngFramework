package lightning.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class Accounts extends BasePage{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public Accounts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String accountName= "Tekarch";
	@FindBy(xpath="//a/span[text()='Accounts']")
	WebElement accountEle;
	
	@FindBy(xpath="//a/div[text()='New']")
	WebElement newEle;
	
	@FindBy(xpath="//div//input[@name='Name']")
	WebElement accountNameEle;
	
	@FindBy(xpath="//div/button[@data-value='--None--' and @aria-label='Type - Current Selection: --None--']")
	WebElement typeArrowEle;
	
	@FindBy(xpath="//div/lightning-base-combobox-item[@data-value='Technology Partner']/span/span")
	WebElement selecttechnologyPartner;
	
	@FindBy(xpath="//div/button[@type='button' and @aria-label='Ownership - Current Selection: --None--']")
	WebElement ownershipEle;
	
	@FindBy(xpath="//div/lightning-base-combobox-item/span/span[text()='Public']")
	WebElement publicEle;
	
	@FindBy(xpath="//button[@name='SaveEdit']")
	WebElement saveEle;
	
	@FindBy(xpath="//lightning-formatted-text[@class='custom-truncate']")
	WebElement eleName;
	
	public void clickAccountEle() throws InterruptedException {
		explicitwait(1000,accountEle);
		js.executeScript("arguments[0].click()", accountEle);
		
	}
	
	public void clickNewAccount()
	{
		explicitwait(80000,newEle);
		js.executeScript("arguments[0].click()", newEle);
		
	}
	
	public void enterAccountName()
	{
		explicitwait(80000,accountNameEle);
		accountNameEle.sendKeys("Tekarch");
	}
	
	public void clickTypeArrow()
	{
		explicitwait(10000,typeArrowEle);
		typeArrowEle.click();
	}
	
	public void selectTechnologyPartner()
	{
//		Select sel=new Select(selecttechnologyPartner);
//		sel.selectByVisibleText("Technology Partner");
		selecttechnologyPartner.click();
		
	}
	
	public void clickOwnership() {
		ownershipEle.click();
	}
	
	public void clickPublicOption() {
		publicEle.click();
	}
	public void clickSave() {
		saveEle.click();
	}
	
	public void verifyEleName()
	{
		explicitwait(40000,eleName);
		String actual=eleName.getText();
		String expected="Tekarch";
		Assert.assertEquals(actual,expected,"No such Account exists");
	}

}
