package lightning.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;

import lightning.pages.Accounts;
import lightning.pages.LoginPage;
import lightning.pages.ViewProfile;

public class AccountsTest extends BaseTest {
	WebDriver driver;
	Accounts accounts;
	ViewProfile viewProfile;
	LoginPage loginPage;
	String url;
	
	@BeforeMethod
	@Parameters ("browser")
	public void setup(@Optional("chrome")String browser) throws IOException
	{
		driver= getDriver(browser);
		url = getUrl();
		driver.get(url);
		loginPage= new LoginPage(driver);
		viewProfile= new ViewProfile(driver);
	    accounts= new Accounts(driver);
	}
	
	
	@Test
	public void createNewAccount() throws InterruptedException {
		loginPage.enterIntoUsername();
		loginPage.enterIntoPassword();
		loginPage.clickOnLogin();
		viewProfile.clickImage();
		viewProfile.clickImageAgain();
		accounts.clickAccountEle();
		accounts.clickNewAccount();
		accounts.enterAccountName();
		accounts.clickTypeArrow();
		accounts.selectTechnologyPartner();
		accounts.clickOwnership();
		accounts.clickPublicOption();
		accounts.clickSave();
		accounts.verifyEleName();
	}

}
