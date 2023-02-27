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
import pomClasses.HomePage;
import pomClasses.SignINPage;
import utils.Utility;

public class TestNgClass1 extends BrowserSetup {
	WebDriver driver ;
	HomePage homePage;
	SignINPage signINPage ;
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
	public void VerifyPlaySong() throws InterruptedException, IOException
	{
		
		testID = "TC1010";
	//	HomePage homePage = new HomePage(driver);
		 homePage.clickonSearch();
		 String data =   Utility.fetchDataFromExcelSheet("TestData", 2, 2);
			homePage.sendSearchTab(data);
			Thread.sleep(3000);
		//	homePage.clickonHiddenclose();
			homePage.clickonSongs();
	//		homePage.clickonPlayButton();		
	}
	
	@Test
	public void VerifyLikedSongPlay() throws InterruptedException {
		
		testID = "TC1011";
	//	HomePage homePage = new HomePage(driver);
		homePage.clickonLikedSongs();
		homePage.clickonLikedSongsPlay();
		Thread.sleep(3000);
	//	homePage.clickonHiddenclose();
		homePage.clickonlikedSongsPlayButton();
	}
	
	@Test
	public void VerifyCreatePlayList() throws InterruptedException, IOException {
	//	HomePage homePage = new HomePage(driver);
		homePage.clickonCreatePlaylist();
		 String data =   Utility.fetchDataFromExcelSheet("TestData", 2, 2);
		homePage.sendSearchForSongsOrEpisodes(data);
		Thread.sleep(2000);
		homePage.clickonHiddenclose();
		homePage.clickonAddToPlaylistButton();
	}
	
	@AfterMethod
	public void logOutPage(ITestResult result) throws IOException {
		
		 if(ITestResult.FAILURE == result.getStatus())
		   {
			   Utility.captureScreenshot(driver, testID);
		   }
	//	HomePage homePage = new HomePage(driver);
		homePage.clickonUserButton();
		homePage.clickonLogOutButton();
	}
	
	@AfterClass
	public void clearPOMObjects() {
		homePage = null;
		signINPage = null;
	}
	
	@AfterTest 
	public void closedbrowser() {
		driver.quit();
		driver = null ;
		
		System.gc();
	}

}
