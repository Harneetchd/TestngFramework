package com.training.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest
{
    WebDriver driver;
    String url ;
    CreateAccountPage createaccountspage;
    
    @BeforeMethod
    public void beforeMethod() throws IOException
    {
    	driver = getDriver("chrome");
    	url = getUrl();
    	driver.get(url);
    	createaccountspage = new CreateAccountPage (driver);
    }
    @Test
    public void createAccountAndValidate() throws InterruptedException
    {
    	createaccountspage.enterinemail();
    	createaccountspage.enterinpassword();
    	createaccountspage.clicklogin();
    	createaccountspage.clickAccountsTab();
    	createaccountspage.clickOnNoThanks();
    	createaccountspage.clickOnPromptDisplay();
    	createaccountspage.clickSubmit();
    	createaccountspage.clickOnNewAccount();
    	createaccountspage.enterAccountName();
    	createaccountspage.enterType();
    	createaccountspage.enterPriority();
    	createaccountspage.clickOnSaveAndValidate();
    }
    
    @Test
    public void createNewView() throws InterruptedException
    {
    	createaccountspage.enterinemail();
    	createaccountspage.enterinpassword();
    	createaccountspage.clicklogin();
    	createaccountspage.clickAccountsTab();
    	createaccountspage.clickOnNoThanks();
    	createaccountspage.clickOnPromptDisplay();
    	createaccountspage.clickSubmit();
    	createaccountspage.clickOnCreateNewView();
    	createaccountspage.enterInViewName();
    	createaccountspage.enterViewUniqueName();
    	createaccountspage.clickOnSave();
    }
    
    @Test
    public void editView() throws InterruptedException
    {
    	createaccountspage.enterinemail();
    	createaccountspage.enterinpassword();
    	createaccountspage.clicklogin();
    	createaccountspage.clickAccountsTab();
    	createaccountspage.clickOnNoThanks();
    	createaccountspage.clickOnPromptDisplay();
    	createaccountspage.clickSubmit();
    	createaccountspage.selectViewOptions();
    	createaccountspage.clickOnEdit();
    	createaccountspage.enterIntoViewName();
    	createaccountspage.selectFilterField();
    	createaccountspage.selectOperator();
    	createaccountspage.enterIntoValue();
    	createaccountspage.clickToSave();
    }
    @Test
    public void mergeAccounts() throws InterruptedException
    {
    	createaccountspage.enterinemail();
    	createaccountspage.enterinpassword();
    	createaccountspage.clicklogin();
    	createaccountspage.clickAccountsTab();
    	createaccountspage.clickOnNoThanks();
    	createaccountspage.clickOnPromptDisplay();
    	createaccountspage.clickSubmit();
    	createaccountspage.clickOnMergeAccounts();
    	createaccountspage.enterIntoAccountName();
    	createaccountspage.clickOnFindAccounts();
    	createaccountspage.clickOnCheck1();
    	createaccountspage.clickOnCheck2();
    	createaccountspage.clickOnNext();
    	createaccountspage.clickOnMerge();
    }
    @Test
    public void teardown()
    {
    	takescreenshot(driver);
    	driver.close();
    }
}
