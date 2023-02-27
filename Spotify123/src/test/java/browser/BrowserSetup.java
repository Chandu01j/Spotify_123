package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSetup {
	
	 public static WebDriver openChromeBrowser() {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
		  WebDriver	 driver = new ChromeDriver();
		  return driver ;
			
		}
		
      public static WebDriver openEdgeBrowser() {
      	System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			
      	WebDriver driver = new EdgeDriver();
      	return driver ;
		}

}
