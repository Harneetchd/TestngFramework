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
import lightning.pages.LoginPage;
import lightning.pages.TaskPage;
import lightning.pages.ViewProfile;

public class TaskTest extends BaseTest{
	WebDriver driver;
	ViewProfile viewProfile;
	LoginPage loginPage;
	TaskPage task;
	String url;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws IOException {
		
		driver= getDriver(browser);
		url = getUrl();
		driver.get(url);
		loginPage= new LoginPage(driver);
		viewProfile= new ViewProfile(driver);
		task = new TaskPage(driver);
	}
	
	@Test
	public void createTask() throws InterruptedException {
		loginPage.enterIntoUsername();
		loginPage.enterIntoPassword();
		loginPage.clickOnLogin();
		viewProfile.clickImage();
		viewProfile.clickImageAgain();
		task.clickTaskTab();
		task.clickArrow();
		task.clickNewTask();
		task.clickSubject();
		task.selectEmail();
		task.clickPriority();
		task.clickHighPriority();
		task.clickStatusArrow();
		task.clickInProgress();
		task.enterInDescription();
		task.clickSave();
		task.verifyTaskEmail();
		
		
		
		
	}
}
