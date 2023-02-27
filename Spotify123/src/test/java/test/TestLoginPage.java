package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.SignINPage;

public class TestLoginPage {
	
	
public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.spotify.com/");
		
		
		HomePage homePage = new HomePage(driverTest);
		homePage.clickonLoginButton();
		
		SignINPage signINPage = new SignINPage(driverTest);
//		signINPage.sendUserOrEmailId();
//		signINPage.sendPassword();
//		signINPage.clickonLoginNutton();
		
		signINPage.login();
//		homePage.clickonUserButton();
//		homePage.clickonLogOutButton();

}
}