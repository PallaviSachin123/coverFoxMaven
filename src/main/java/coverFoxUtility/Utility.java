package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\mock Result.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet6");
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static void screenShot(WebDriver driver,String TCID) throws IOException
	{
	
		Reporter.log("Taking ScreenShot", true);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest  = new File("D:\\softwareTestingMaterial\\ScreenShot\\ALLScreenShot\\"+"coverFox"+TCID+"-"+timeStamp+".png");
		FileHandler.copy(src, dest);
	}
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		//create object of properties file
		Properties prop = new Properties();
		//file location
		//FileInputStream myFile =  new FileInputStream("C:\\Users\\User\\eclipse-workspace\\pallaviSelenium\\coverfoxProperties.properties");
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\coverfoxProperties.properties");
		
		//load file
		prop.load(myFile);
		//pass the key for the data we want
		String value = prop.getProperty(key);
		return value;
		
	}

}
