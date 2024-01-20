package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAdressDetailsTN {
	@FindBy(className = "mp-input-text") private WebElement pincode;
	@FindBy(id = "want-expert") private WebElement mobNumber;
	@FindBy(className = "next-btn") private WebElement continueButton;
	@FindBy(xpath = "//div[@class='error-ui']") private WebElement errorMsg;
	
	public CoverFoxAdressDetailsTN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPinCode(String pinNo)
	{
		pincode.sendKeys(pinNo);
	}
	public void enterMobNumber(String mobNo)
	{
		mobNumber.sendKeys(mobNo);
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	public boolean errorMsgIsDisplayed()
	{
		boolean result = errorMsg.isDisplayed();
		return result;
	}
	

}
