package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AccountOverviewPage;
import pomClasses.HomePage;
import pomClasses.SignINPage;

public class TestNotificationsetting {
	
	
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
		
		homePage.clickonUserButton();
		homePage.clickonAccount();
		
		ArrayList<String> addr1 = new ArrayList<String> (driverTest.getWindowHandles());
		driverTest.switchTo().window(addr1.get(1));//switch to child browser

		AccountOverviewPage accountOverviewPage = new AccountOverviewPage(driverTest);
		Thread.sleep(2000);
		homePage.clickonHiddenclose();
		Thread.sleep(2000);
		accountOverviewPage.clickonNotificationSetting();
		accountOverviewPage.clickonChangesetting();
		Thread.sleep(2000);
		accountOverviewPage.clickonsaveButton();

}
}