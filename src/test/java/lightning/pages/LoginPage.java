package lightning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.training.base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	WebElement email;
	
	
	@FindBy(id="password")
	WebElement enterpassword;
	
	@FindBy(id="Login")
	WebElement login;
	
	public void enterIntoUsername() throws InterruptedException
	{
		Thread.sleep(1000);
		email.sendKeys("harneetkaur@capitalforce.com");
	}
	
	public void enterIntoPassword()
	{
		enterpassword.sendKeys("Hello@1234");
	}
	
	public void clickOnLogin()
	{
		explicitwait(1000,login);
		login.click();
	}
	
	public void validateLogin() {
		 String expValue ="Home | Salesforce";
		 String actValue =driver.getTitle();
		 
		Assert.assertEquals(actValue, expValue, "Titles Dont Match");
	}

}
