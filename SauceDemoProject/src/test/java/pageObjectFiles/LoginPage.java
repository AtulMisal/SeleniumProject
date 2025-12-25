package pageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFiles.BrowserOpenClose;

public class LoginPage extends BrowserOpenClose{

  public LoginPage (WebDriver rdriver)
  {
	 BrowserOpenClose.driver = rdriver;
	 PageFactory.initElements(driver, this);
  }
  
  @FindBy (id = "user-name")
  @CacheLookup
  WebElement userName;
  
  @FindBy (id = "password")
  @CacheLookup
  WebElement password;
  
  @FindBy (id = "login-button")
  @CacheLookup
  WebElement loginButton;
 
  
  public void setUserName (String uname)
  {
	  userName.sendKeys(uname);
  }
  
  public void setPassword (String upass)
  {
	  password.sendKeys(upass);
  }
  
  public void clickLogInBtn ()
  {
	  loginButton.click();
  }
  
  
}
