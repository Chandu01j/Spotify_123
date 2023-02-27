package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	// Variable : WebElement :Login Or Sign Up Page
	
		@FindBy (xpath = "//button[@data-testid='login-button']")
		private WebElement loginButton ; 
		
		@FindBy (xpath = "//span[text()='Search']")
		private WebElement search ;
		
		@FindBy (xpath = "//input[@data-testid='search-input']")
		private WebElement searchTab ; 
		
		@FindBy (xpath = "(//div[@id='onetrust-banner-sdk']//button)")
		private WebElement hiddenclose ;
		
		@FindBy (xpath = "(//div[@class='KjPUGV8uMbl_0bvk9ePv']//span)[2]")
		private WebElement songs ; 
		
		@FindBy (xpath = "//span[text()='2']")
		private WebElement playButton ; 
		
		@FindBy (xpath = "//span[text()='Liked Songs']")
		private WebElement likedSongs ; 
		
		@FindBy (xpath = "((//div[@style='transform: translateY(0px);'])[2]//div)[7]")
		private WebElement likedSongsPlay ; 
		
		@FindBy (xpath = "(//button[@data-testid='play-button'])[2]")
		private WebElement likedSongsPlayButton ; 
		

		@FindBy (xpath = "//button[@data-testid='user-widget-link']")
		private WebElement userButton ; 
		
		@FindBy (xpath = "//span[text()='Account']")
		private WebElement account ;  
		
		@FindBy (xpath = "//span[text()='Create Playlist']")
		private WebElement createPlaylist ; 
		
		@FindBy (xpath = "//input[@placeholder='Search for songs or episodes']")
		private WebElement searchForSongsOrEpisodes ; 
		
		@FindBy (xpath = "(//button[@data-testid='add-to-playlist-button'])[1]")
		private WebElement addToPlaylistButton ; 
		
		@FindBy (xpath = "//button[@data-testid='user-widget-dropdown-logout']")
		private WebElement logOutButton ; 
		
		
		
		// Constructor : Initialization of WebElement : Login Or Sign Up Page
		
		 public HomePage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
		 }
		 
		 //Methods : Action on WebElement : Login Or Sign Up Page
		 
		  public void clickonLoginButton() {
			  loginButton.click();
		 }
		 
		  
		  public void clickonSearch() {
			  search.click();
		 }
		  
		  public void sendSearchTab(String song) {
			  searchTab.sendKeys(song);
		 }
		  
		  public void clickonHiddenclose() {
			  hiddenclose.click();
		 }
		  
		  public void clickonSongs() {
			  songs.click();
		 }
		 
		  public void clickonPlayButton() {
			  playButton.click();
		 }
		 
		  public void clickonLikedSongs() {
			  likedSongs.click();
		 }
		  public void clickonLikedSongsPlay() {
			  likedSongsPlay.click();
		 }
		  public void clickonlikedSongsPlayButton() {
			  likedSongsPlayButton.click();
		 }
		  
		  public void clickonUserButton() {
			  userButton.click();
		 }
		  
		  public void clickonAccount() {
			  account.click();
		 }
		  
		  public void clickonCreatePlaylist() {
			  createPlaylist.click();
		 }
		  
		  
		  public void sendSearchForSongsOrEpisodes(String songsearch) {
			  searchForSongsOrEpisodes.sendKeys(songsearch);
		 }
		  
		  
		  public void clickonAddToPlaylistButton() {
			  addToPlaylistButton.click();
		 }
		  public void clickonLogOutButton() {
			  logOutButton.click();
		 }
		  
		  
}
