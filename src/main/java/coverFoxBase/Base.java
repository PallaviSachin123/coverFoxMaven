package coverFoxBase;

import java.net.SocketException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class Base 
{
	
	protected static WebDriver driver;
	
	//Open Browser

	public void launchCoverFox() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching CoverFox", true);
		driver.get("https://www.coverfox.com/");
		Thread.sleep(2000);
	}
//	public WebDriver getWebDriver()
//	{
//		return driver;
//	}
//	
	//close browser
	public void closeCoverFox() throws InterruptedException, SocketException
	{
		Reporter.log("Closing Browser", false);
		Thread.sleep(1000);
		driver.close();
		
	}

}
