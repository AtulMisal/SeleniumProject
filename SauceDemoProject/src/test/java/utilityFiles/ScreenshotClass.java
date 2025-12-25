package utilityFiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotClass extends BrowserOpenClose {
  public static String screenshot() throws IOException {
	 TakesScreenshot tc=(TakesScreenshot) driver;
		
	 File scrfile=tc.getScreenshotAs(OutputType.FILE);
			
	 File destfile=new File("C:\\Users\\atulm\\Desktop\\Selenium_Programs\\SauceDemoProject\\target\\Screenshotss\\"+"ScreenCaptue"+System.currentTimeMillis()+".png");
		
	 FileUtils.copyFile(scrfile, destfile);
 	 return destfile.getAbsolutePath();
}
}