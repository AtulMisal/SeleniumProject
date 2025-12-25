package utilityFiles;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AlertHandling extends BrowserOpenClose {
    public Alert alert;
    
    public AlertHandling (WebDriver ldriver)
    {
      BrowserOpenClose.driver = ldriver;
      PageFactory.initElements(driver, this);
      
    }
	public void switchToAlert()
	{
	  try
	  {
		alert = driver.switchTo().alert();  
		alert.accept();
	  }
	  catch (NoAlertPresentException e)
	  {
		  System.out.println("No alert present!");
    	  } 
	}
	
	public void dismissAlert()
	{
	  alert.dismiss();
	}

	
}
