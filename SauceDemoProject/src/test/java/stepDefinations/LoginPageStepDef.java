package stepDefinations;

import java.io.IOException;
import java.time.Duration;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectFiles.HomePage;
import pageObjectFiles.LoginPage;
import utilityFiles.BrowserOpenClose;
import utilityFiles.ScreenshotClass;

public class LoginPageStepDef extends BrowserOpenClose {

	public LoginPage lp;
	public HomePage hp;

	@Given("User is on login page of sauce demo page {string}")
	public void user_is_on_login_page_of_sauce_demo_page(String url) throws IOException {
		BrowserOpenClose.open_browser(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new LoginPage(driver);
		ExtentCucumberAdapter.addTestStepLog("Application Launched Successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
	}

	@When("User enters UserName {string} and Password {string}")
	public void user_enters_user_name_and_password(String uname, String pass) throws IOException {
	   lp.setUserName(uname);
	   lp.setPassword(pass);
	   ExtentCucumberAdapter.addTestStepLog("Username and password is typed successfully");
	   ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
	}

	@When("User clicks on log in button")
	public void user_clicks_on_log_in_button() throws InterruptedException, IOException {
	    lp.clickLogInBtn();
	    Thread.sleep(5000);
	    ExtentCucumberAdapter.addTestStepLog("Clicked on Login button");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
	}
	@Then("User should be navigated to Home page")
	public void user_should_be_navigated_to_home_page() throws IOException {
		hp = new HomePage(driver);
		hp.alertWindow();
		ExtentCucumberAdapter.addTestStepLog("Switched to home page");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
	   
	}

	@Then("Verify the title of page as {string}")
	public void verify_the_title_of_page_as(String title) throws InterruptedException, IOException {
		 if (hp.pageTitle().equals(title))
		 {
			 ExtentCucumberAdapter.addTestStepLog("Title matched on home page");
			 ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
		 }
		 else
		 {
			 ExtentCucumberAdapter.addTestStepLog("Title not matched on home page");
			 ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
		 }
	}

	@When("User clicks on log out button")
	public void user_clicks_on_log_out_button() throws InterruptedException, IOException {
		hp.burgerBtn();
	    hp.logoutBtn();
	    ExtentCucumberAdapter.addTestStepLog("Clicked on logout button");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
	}

	@Then("User should be logged out and navigated to log in page")
	public void user_should_be_logged_out_and_navigated_to_log_in_page() throws InterruptedException, IOException {
		
		if (hp.pageTitle().equals("Swag Labs"))
		 {
		   ExtentCucumberAdapter.addTestStepLog("Title Matched on log in screen");
		   ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
		 }
		 else
		 {
		   ExtentCucumberAdapter.addTestStepLog("Title not matched on log in screen");
		   ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenshotClass.screenshot());
		 } 
		
	}
}
