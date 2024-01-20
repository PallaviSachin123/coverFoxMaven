package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHomePageTN {
	@FindBy(xpath = "//div[text()='Female']") private WebElement gender;
	
	
	public CoverFoxHomePageTN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGender()
	{
		gender.click();
	}

}
