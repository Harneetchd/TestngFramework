package lightning.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.logs.Log;

import lightning.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage loginPage;
	WebDriver driver;
	String url;
	
	
	@BeforeMethod
	@Parameters ("browser")
	public void setUp(@Optional ("chrome") String browser) throws IOException {
		driver = getDriver(browser);
		url= getUrl();
		driver.get(url);
		loginPage= new LoginPage(driver);
	}
	
	@Test
	public void loginSucess() throws InterruptedException
	{
		loginPage.enterIntoUsername();
		loginPage.enterIntoPassword();
		loginPage.clickOnLogin();
	}
}
