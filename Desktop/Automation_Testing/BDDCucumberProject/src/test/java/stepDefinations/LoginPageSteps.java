package stepDefinations;

import java.util.List;

import PageObjectFiles.LoginPage;
import UtilityFiles.BrowserInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BrowserInit{

	@Given("User is on login page of {string}")
	public void user_is_on_login_page_of(String url) 
	{
	   BrowserInit.open_browser(url);
	}

	@When("User enters credentials as")
	public void user_enters_credentials_as(io.cucumber.datatable.DataTable dataTable) 
	{
	  lp = new LoginPage(driver);
	  List<List<String>> data = dataTable.cells();
	  lp.setUserName(data.get(0).get(0));
	  lp.setPassword(data.get(0).get(1));
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException 
	{
	  lp.loginBtn();
	  Thread.sleep(5000);
	}

	@Then("User should navigate to Home page")
	public void user_should_navigate_to_home_page() 
	{
	  if (driver.getPageSource().contains("Products")) 
	  {
		System.out.println("User is on Home page");
	  }
	  else
	  {
		System.out.println("User is not on Home page");
	  }
	}

	@Then("User must validate the Home page title")
	public void user_must_validate_the_home_page_title()
    {
	  if (driver.getTitle().equals("Swag Labs")) 
      {
		System.out.println("Title matched");
	  }
      else
      {
		System.out.println("Title not matched");
	  }
	}

	@Then("User logs out")
	public void user_logs_out() throws InterruptedException 
	{
	  lp.logoutBtn();
	}

}
