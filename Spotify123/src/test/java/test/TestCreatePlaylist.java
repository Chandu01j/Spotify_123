package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.SignINPage;

public class TestCreatePlaylist {
	
public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.spotify.com/");
		
		
		HomePage homePage = new HomePage(driverTest);
		homePage.clickonLoginButton();
		
		SignINPage signINPage = new SignINPage(driverTest);
		signINPage.login();
		
		homePage.clickonCreatePlaylist();
		homePage.sendSearchForSongsOrEpisodes("ved");
		Thread.sleep(2000);
		homePage.clickonHiddenclose();
		homePage.clickonAddToPlaylistButton();
		
}
}
