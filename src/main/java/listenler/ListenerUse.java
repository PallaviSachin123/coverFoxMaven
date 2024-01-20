package listenler;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;
import coverFoxUtility.Utility;

public class ListenerUse extends Base implements ITestListener{

@Override
	
	public void onTestStart(ITestResult result) {
	String s = result.getName();
		Reporter.log("TC "+s+" Excution Stared", true);
}
	@Override
	public void onTestFailure(ITestResult result) {
		String s = result.getName();
		try {
			Utility.screenShot(driver, s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("TC "+s+" Excution Failed", true);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String s = result.getName();
		Reporter.log("TC "+s+" Excution Skipped", true);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	String s  = result.getName();	
	Reporter.log("TC "+s+" Excution Success", true);
	}
//	
//
//	
}
