package coverFoxPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultPageTN {
	@FindBy (xpath = "//div[text()='49 matching Health Insurance Plans']")private WebElement text;
	@FindBy (xpath = "//div[@id='plans-list']") private List<WebElement> planList;
	@FindBy (xpath="//div[text()='Sort Plans']") private WebElement sortPlanField;
	
	public CoverFoxResultPageTN(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int availablePlanNumberFromText()
	{
		String test = text.getText();
		 String arr[] = test.split(" ");
		 String numberResultInString = arr[0];
		 int  numberResultInInteger = Integer.parseInt(numberResultInString);
		 return numberResultInInteger;
	}
	
	public int availablePlanNumberFromBanner()
	{
		int totalNumberOfPlan= planList.size();
		return totalNumberOfPlan; 
	}
	
	public boolean sortPlanFeildPresency()
	{
		boolean result = sortPlanField.isDisplayed();
		return result;
	}
	

}
