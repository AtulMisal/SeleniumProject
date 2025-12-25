package pageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFiles.AlertHandling;
import utilityFiles.BrowserOpenClose;

public class HomePage extends BrowserOpenClose 
{
	  public AlertHandling al;
	  
	  public HomePage (WebDriver ldriver)
	  {
	    BrowserOpenClose.driver = ldriver;
	    PageFactory.initElements(driver, this);
	  }
	  
	  
	  @FindBy (xpath = "//button[text()='Open Menu']")
	  @CacheLookup
	  WebElement burgerButton;
	  
	  @FindBy (linkText = "Logout")
	  @CacheLookup
	  WebElement logOut;
	  
	  public String pageTitle()
	  {
		return driver.getTitle();
	  } 
	  
	  public void alertWindow()
	  {
		al = new AlertHandling(driver);
		al.switchToAlert();
	  }
	  
	  public void burgerBtn ()
	  {
		  burgerButton.click();
	  }
	  
	  public void logoutBtn ()
	  {
		  logOut.click();
	  }
	  	  
}
