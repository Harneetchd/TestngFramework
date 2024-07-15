package lightning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ViewProfile extends BasePage
{

	public ViewProfile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div/span/div/span[@class='uiImage']")
	WebElement clickCat;
	
	@FindBy(xpath="//div/h1/a[text()='Harneet Kaur']")
	WebElement clickIconAgain;
	
	public void clickImage() throws InterruptedException {
		explicitwait(80000,clickCat);
		clickCat.click();
	}
	
	public void clickImageAgain() {
		clickIconAgain.click();
	}

}
