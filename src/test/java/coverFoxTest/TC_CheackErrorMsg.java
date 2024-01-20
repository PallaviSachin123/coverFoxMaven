package coverFoxTest;

import java.io.IOException;
import java.net.SocketException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPom.CoverFoxAdressDetailsTN;
import coverFoxPom.CoverFoxHealthPlanPageTN;
import coverFoxPom.CoverFoxHomePageTN;
import coverFoxPom.CoverFoxMemberDetailsPageTN;
import coverFoxUtility.Utility;

@Listeners(listenler.ListenerUse.class)
public class TC_CheackErrorMsg extends Base {
	CoverFoxHomePageTN home;
	CoverFoxHealthPlanPageTN healthPlan;
	CoverFoxMemberDetailsPageTN memberDetails;
	CoverFoxAdressDetailsTN adressDetails;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		launchCoverFox();
		home = new CoverFoxHomePageTN(driver);
		healthPlan = new CoverFoxHealthPlanPageTN(driver);
		memberDetails = new CoverFoxMemberDetailsPageTN(driver);
		adressDetails = new CoverFoxAdressDetailsTN(driver);
		Thread.sleep(2000);
	}
	
	
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Clicking on gender",true);
		home.clickOnGender();
		Thread.sleep(2000);
		
		Reporter.log("Clicking on next Button", true);
		healthPlan.nextButtonClick();
		Thread.sleep(2000);
		
		Reporter.log("Select Age", true);
		memberDetails.selectAge(Utility.readDataFromExcel(1, 0));
		memberDetails.clickOnNextButton();
		Thread.sleep(2000);
			
	}
	
  @Test
  public void checkErrorMsgIsDisplayed() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  Reporter.log("check error message is Showing or not", true);
	  adressDetails.enterPinCode("");
	  adressDetails.enterMobNumber(Utility.readDataFromExcel(1, 2));
	  adressDetails.clickOnContinueButton();
	  Thread.sleep(2000);
	  Assert.assertTrue(adressDetails.errorMsgIsDisplayed());
	  Reporter.log("TC is Pass", true);
  }
  
  @AfterMethod
  public void closeBrowser() throws InterruptedException, SocketException
  {
	  Thread.sleep(7000);
	  closeCoverFox();
  }
}
