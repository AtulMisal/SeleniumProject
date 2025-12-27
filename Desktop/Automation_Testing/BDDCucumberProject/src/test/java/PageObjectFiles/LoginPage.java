package PageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityFiles.BrowserInit;

public class LoginPage extends BrowserInit{

	public LoginPage(WebDriver driver)
	{
		BrowserInit.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="login-button")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	@CacheLookup
	WebElement menuButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutButton;
	
	
	public void setUserName(String uname)
	{
	   userName.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
	   password.sendKeys(pass);
	}
	
	public void loginBtn()
	{
	   loginButton.click();
	}
	
	public void logoutBtn() throws InterruptedException
	{
	   menuButton.click();
	   Thread.sleep(3000);
	   logoutButton.click();
	}
}
