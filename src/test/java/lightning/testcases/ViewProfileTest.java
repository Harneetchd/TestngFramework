package lightning.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;

import lightning.pages.LoginPage;
import lightning.pages.ViewProfile;

public class ViewProfileTest extends BaseTest 
{
	WebDriver driver;
	ViewProfile viewProfile;
	LoginPage loginPage;
	String url;
	
	@BeforeMethod
	@Parameters ("browser")
	public void setUp(@Optional("chrome") String browser) throws IOException
	{
		driver = getDriver(browser);
		url= getUrl();
		driver.get(url);
		loginPage= new LoginPage(driver);
		viewProfile= new ViewProfile(driver);
		
	}
	
	@Test
	public void clickOnProPic() throws InterruptedException
	{
		loginPage.enterIntoUsername();
		loginPage.enterIntoPassword();
		loginPage.clickOnLogin();
		viewProfile.clickImage();
		viewProfile.clickImageAgain();
	}
}
