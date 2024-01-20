package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetailsPageTN {
	@FindBy(id = "Age-You") private WebElement age;
	@FindBy(className = "next-btn") private WebElement nextButton;
		
	public CoverFoxMemberDetailsPageTN(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectAge(String ageRuntime)
	{
		Select s = new Select(age);
		s.selectByValue(ageRuntime+"y");
	}
	public void clickOnNextButton()
	{
		nextButton.click();
	}
	

}
