package UtilityFiles;

  import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjectFiles.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

  public class BrowserInit {

	public static String browser = "chrome";
	public static WebDriver driver;	
	public static LoginPage lp;  
	
	public static void open_browser(String url)
	{
	  switch(browser)  
	  {
		case "chrome":
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
			
		try 
		{
		  if ((url.length()==0) || (!url.contains("com")) || (!url.contains(".")) || (!url.contains("https")))
		  {
			throw new UrlException ("URL is incorrect");
		  }
		  else
		  {
			driver.get(url);
			driver.manage().window().maximize();
			break;
		  }
		}
		catch (Exception e)
		{
			System.out.println(e);
			driver.get(url);
		    break;
		}
	    case "IE":
		  WebDriverManager.iedriver().setup();
		  driver= new InternetExplorerDriver();
		  break;
		  
	    case "edge":
		  WebDriverManager.edgedriver().setup();
		  driver= new EdgeDriver();
		  break;	   
		}
	  }
	  
	 public static void browser_close()
	 {
		driver.close();
	 }
	} 

