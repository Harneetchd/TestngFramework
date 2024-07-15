package lightning.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class TaskPage extends BasePage{
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public TaskPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='slds-truncate'][normalize-space()='Tasks']")
	WebElement taskTab;
	
	@FindBy(xpath="//div/div/div/div/a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']")
	WebElement arrowTask;
	
	@FindBy(xpath="//a[@title='New Task']")
	WebElement newTaskEle;
	
	@FindBy(xpath="//div/input[@class='slds-combobox__input slds-input']")
	WebElement subjectEle;
	
	@FindBy(xpath="//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click slds-is-open']/div[2]/lightning-base-combobox-item[2]/span[2]/span")
	WebElement selectEmailEle;
	//span[text()='Email']
	//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click slds-is-open']/div[2]/lightning-base-combobox-item[2]/span[2]/span
	
	@FindBy(xpath="//a[normalize-space()='Normal']")
	WebElement priorityArrow;
	
	@FindBy(xpath="//li/a[@title='High']")
	WebElement priorityHighEle;
	
	@FindBy(xpath="//div/a[text()='Not Started']")
	WebElement statusEle;
	
	@FindBy(xpath="//li/a[text()='In Progress']")
	WebElement selectInProgressEle;
	
	@FindBy(xpath="//div/textarea[@role='textbox']")
	WebElement descriptionEle;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement saveEle;
	
	@FindBy(xpath="//span[@class='uiOutputTextArea']")
	WebElement commentsEle;
	
	@FindBy(xpath="//div[@title='Email']//span[@class='uiOutputText']")
	WebElement taskEmailEle;
	
	public void clickTaskTab() {
		explicitwait(1000,taskTab);
		js.executeScript("arguments[0].click()", taskTab);
	}
	
	public void clickArrow() {
		explicitwait(40000,arrowTask);
		arrowTask.click();
	}
	public void clickNewTask() {
		explicitwait(1000,newTaskEle);
		newTaskEle.click();
	}
	
	public void clickSubject()
	{
		explicitwait(40000,subjectEle);
		subjectEle.click();
	}
	public void selectEmail()
	{
		selectEmailEle.click();
	}
	public void clickPriority()
	{
		priorityArrow.click();
	}
	public void clickHighPriority()
	{
		explicitwait(2000,priorityHighEle);
		priorityHighEle.click();
	}
	public void clickStatusArrow() {
		statusEle.click();
	}
	
	public void clickInProgress()
	{
		explicitwait(2000,selectInProgressEle);
		selectInProgressEle.click();
	}
	
	public void enterInDescription()
	{
		explicitwait(2000,descriptionEle);
		descriptionEle.sendKeys("Tekarch Task created");;
	}
	public void clickSave()
	{
		saveEle.click();
	}
	
	public void verifyDescription()
	{
		explicitwait(35000,commentsEle);
		String actual=commentsEle.getText();
		String expected="Tekarch Task created";
		Assert.assertEquals(actual, expected,"Description doesnt match");
	}
	
	public void verifyTaskEmail()
	{
		explicitwait(80000,taskEmailEle);
		String actual = taskEmailEle.getText();
		String expected= "Email";
		Assert.assertEquals(actual, expected,"Task Email is not Created");
	}
}
