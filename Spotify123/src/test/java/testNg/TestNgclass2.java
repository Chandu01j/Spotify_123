package testNg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.BrowserSetup;
import pomClasses.AccountOverviewPage;
import pomClasses.HomePage;
import pomClasses.SignINPage;
import utils.Utility;

public class TestNgclass2 extends BrowserSetup {
	
	WebDriver driver ;
	HomePage homePage;
	SignINPage signINPage ;
	AccountOverviewPage accountOverviewPage;
	private String testID ;
	
	@Parameters ("browser")
	@BeforeTest
	public void LauchBrowser(String browserName) {
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();	
		}
		
		if(browserName.equals("Edge"))
		{
			 driver = openEdgeBrowser();
		}
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void ctreatePOMObjects() {
		homePage = new HomePage(driver);
		signINPage = new SignINPage(driver);
		accountOverviewPage =new AccountOverviewPage(driver);
	}
	
	
	@BeforeMethod
	public void goToHomePage() throws IOException {
    driver.get("https://www.spotify.com/");
		
		
	//	HomePage homePage = new HomePage(driver);
		homePage.clickonLoginButton();
		
	//	SignINPage signINPage = new SignINPage(driver);
		 String data =   Utility.fetchDataFromExcelSheet("TestData", 2, 0);
		 
			signINPage.sendUserOrEmailId(data);
			data =   Utility.fetchDataFromExcelSheet("TestData", 2, 1);
			signINPage.sendPassword(data);
		signINPage.clickonCkeckBox();
		signINPage.clickonLoginNutton();
	}
	
	@Test
	public void VerifyNotificationSetting() throws InterruptedException {
		
		testID = "TC1012";
	//	HomePage homePage = new HomePage(driver);
		homePage.clickonUserButton();
		homePage.clickonAccount();
		
		ArrayList<String> addr1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));//switch to child browser

	//	AccountOverviewPage accountOverviewPage = new AccountOverviewPage(driver);
		Thread.sleep(2000);
		homePage.clickonHiddenclose();
		Thread.sleep(2000);
		accountOverviewPage.clickonNotificationSetting();
		accountOverviewPage.clickonChangesetting();
		Thread.sleep(2000);
	//	accountOverviewPage.clickonsaveButton();
	}
	
	@AfterMethod
	public void logOutPage(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		   {
			   Utility.captureScreenshot(driver, testID);
		   }
		
	//	AccountOverviewPage accountOverviewPage =new AccountOverviewPage(driver);
		accountOverviewPage.clickonprofileacc();
		accountOverviewPage.clickonlogOutButtonAcc();
		
		
	}
	@AfterClass
	public void clearPOMObjects() {
		homePage = null;
		signINPage = null;
		accountOverviewPage = null ;
	}
	
	@AfterTest 
	public void closedbrowser() {
		driver.quit();
		driver = null ;
		
		System.gc();
	}

}
