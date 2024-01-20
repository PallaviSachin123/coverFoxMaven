package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlanPageTN {
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	
	public CoverFoxHealthPlanPageTN(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void nextButtonClick()
	{
		nextButton.click();
	}

}
