package coverFoxTest;

import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import coverFoxBase.Base;
import coverFoxPom.CoverFoxAdressDetailsTN;
import coverFoxPom.CoverFoxHealthPlanPageTN;
import coverFoxPom.CoverFoxHomePageTN;
import coverFoxPom.CoverFoxMemberDetailsPageTN;
import coverFoxPom.CoverFoxResultPageTN;
import coverFoxUtility.Utility;

@Listeners(listenler.ListenerUse.class)
public class CF_TC555_validate_search_result_for_healthcare_policies extends Base {
	
	public static Logger logger;
	CoverFoxHomePageTN home;
	CoverFoxHealthPlanPageTN healthPlane;
	CoverFoxAdressDetailsTN adressDetails;
	CoverFoxMemberDetailsPageTN memberDetails;
	CoverFoxResultPageTN result;
	SoftAssert sf;
	
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		logger = logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("log4j.properties");
		
		launchCoverFox();
		logger.info("Launching CoverFox");
		home = new CoverFoxHomePageTN(driver);
		healthPlane = new CoverFoxHealthPlanPageTN(driver);
		memberDetails = new CoverFoxMemberDetailsPageTN(driver);
		adressDetails = new CoverFoxAdressDetailsTN(driver);
		result = new CoverFoxResultPageTN(driver);
		sf = new SoftAssert();
		Thread.sleep(3000);
	}
	
	
	
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Clicking on Gender Button", true);
		logger.info("Clicking on Femail button");
		home.clickOnGender();
		Thread.sleep(1000);
		
		Reporter.log("Clicking on next button", true);
		logger.info("Clicking on next button");
		healthPlane.nextButtonClick();
		Thread.sleep(1000);

		Reporter.log("Handaling age dropdown ", true);
		logger.info("Handeling drop down");
		memberDetails.selectAge(Utility.readDataFromExcel(1, 0));
		Reporter.log("Clicking on next button", true);
		logger.info("Clicking on next button");
		memberDetails.clickOnNextButton();
		Thread.sleep(1000);
		
		Reporter.log("Enter pincode number", true);
		logger.info("Enter Pin code");
		adressDetails.enterPinCode(Utility.readDataFromExcel(1, 1));
		Reporter.log("Enter Mobile number", true);
		logger.info("Enter Mob. Number");
		adressDetails.enterMobNumber(Utility.readDataFromExcel(1, 2));
		Reporter.log("Click on continue button", true);
		logger.info("Clicking on continue button");
		adressDetails.clickOnContinueButton();
		Thread.sleep(1000);
	}
	
  @Test
  public void validateTestPlanFromTextAndBanner() throws InterruptedException, IOException
  {
	//  enterMemberDetails();
	  Thread.sleep(7000);
	  Reporter.log("Fetching result from text",true);
	  logger.info("Fetching result from text");
	  int textResult = result.availablePlanNumberFromText();
	  Thread.sleep(5000);
	  
	  
	  Reporter.log("Fetching result from banner",true);
	  logger.info("Fetching result from banner");
	  int bannerResult = result.availablePlanNumberFromBanner();
	  Thread.sleep(3000);
	  
	  sf.assertEquals(textResult, bannerResult,"Text result are not matching, TC is Failed");
	  Reporter.log("TC is Pass both are equal",true);
	  logger.info("TC is Pass both are equal");
	  Thread.sleep(3000);
	  sf.assertTrue(result.sortPlanFeildPresency());
	  Reporter.log("TC is Pass sort plan is present",true);
	  logger.info("TC is Pass sort plan is present");
	  Utility.screenShot(driver, "TCID");
	  Thread.sleep(5000);
	  sf.assertAll();
  }
  @AfterClass
  public void closeBrowser() throws InterruptedException, SocketException
  {
	  Thread.sleep(10000);
	  logger.info("Closing the Browser");
	  closeCoverFox();
  }
}
