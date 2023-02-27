package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
	
	
	

	@FindBy (xpath = "(//div[@data-testid='Menu Container']//a)[4]")
	private WebElement notificationSetting ; 
	
	@FindBy (xpath = "(//span[@class='Indicator-sc-1airx73-0 bpcByA'])[1]")
	private WebElement changesetting ;
	@FindBy (xpath = "//button[@data-encore-id='buttonPrimary']")
	private WebElement saveButton ;
	@FindBy (xpath = "(//li[@class='svelte-11h1c9'])[2]")
	private WebElement logOutButtonAcc ;
	
	@FindBy (xpath = "//span[text()='Profile']")
	private WebElement profileacc ;
	private WebDriver driver ;
	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	
			 public AccountOverviewPage(WebDriver driver) {
				 PageFactory.initElements(driver, this);
				 this.driver = driver;
			 }
			 
			 
			 //Methods : Action on WebElement : Login Or Sign Up Page
			 
			  public void clickonNotificationSetting() {
				  notificationSetting.click();
			 }
			 
			  
			  public void clickonChangesetting() {
				  changesetting.click();
			 }
			  
			  public void clickonsaveButton() {
				  saveButton.click();
			 }
			  public void clickonprofileacc() {
				  profileacc.click();
			 }
			  
			  public void clickonlogOutButtonAcc() {
				  Actions act = new Actions(driver);
				  act.moveToElement(profileacc).moveToElement(logOutButtonAcc).click().build().perform();
			 }
			  
			  
			 


}
