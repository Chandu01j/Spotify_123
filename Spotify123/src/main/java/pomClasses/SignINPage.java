package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignINPage {
	
	

	// Variable : WebElement :Login Or Sign Up Page
	
	@FindBy (xpath = "//input[@id='login-username']")
	private WebElement userOrEmailId ; 
	
	
	@FindBy (xpath = "//input[@id='login-password']")
	private WebElement password ; 

	@FindBy (xpath = "//button[@id='login-button']")
	private WebElement loginButton ; 

	@FindBy (xpath = "//a[@id='reset-password-link']")
	private WebElement forgotPasswordLink ; 
	
	@FindBy (xpath = "//label[@for='login-remember']")
	private WebElement ckeckBox ; 
	

	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	
	 public SignINPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Methods : Action on WebElement : Login Or Sign Up Page
	 
	  public void sendUserOrEmailId(String emailid) {
		  userOrEmailId.sendKeys(emailid);
	 }
	  
	  public void sendPassword(String pass) {
			 password.sendKeys(pass);
		 }
	  
	  public void clickonLoginNutton() {
		  loginButton.click();
		 }
	  
	  public void clickonForgotPasswordLink() {
		  forgotPasswordLink.click();
		 }
	  
	  public void clickonCkeckBox() {
		  ckeckBox.click();
		 }
	  
	  public void login() {
		  userOrEmailId.sendKeys("chandrakantbharsawde04@gmail.com");
		  password.sendKeys("Chandu@123");
		  ckeckBox.click();
		  loginButton.click();
	  }
	  
	 
		  
	  }
	 


