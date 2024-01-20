import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BrokenLink {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://bstackdemo.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  for(WebElement link:links)
	  {
		  String url= link.getAttribute("href");
		  verifyLink(url);
		  	  
	  }
  }
	  public static void verifyLink(String url)
	  {
		  try
		  {
			  URL link = new URL(url);
			  HttpURLConnection httpURLCoonnection= (HttpURLConnection) link.openConnection();
			  httpURLCoonnection.setConnectTimeout(3000);
			  httpURLCoonnection.connect();
			  
			  if(httpURLCoonnection.getResponseCode()==200)
			  {
				  Reporter.log(url+" - "+httpURLCoonnection.getResponseMessage(),true);
			  }
			  else
			  {
				  Reporter.log(url+" - "+httpURLCoonnection.getResponseMessage()+" Link is broken",true);
			  }
		  }
		  catch(Exception e)
		  {
			  Reporter.log(url+" - " + "is broken link",true);
			  
		  }
		  
	  }
}

