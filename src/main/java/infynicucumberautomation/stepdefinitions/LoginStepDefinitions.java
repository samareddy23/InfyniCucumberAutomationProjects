package infynicucumberautomation.stepdefinitions;

import java.io.FileNotFoundException;

import org.testng.Assert;

import infynicucumberautomation.pageobjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends LoginPage {

	@Before
	public void launchBrowser() {
		launchBrowser("Edge");
	}
	
	@Given("User is in login page") public void user_is_in_login_page() throws
	  FileNotFoundException { launchApp();
	  System.out.println(driver.getPageSource()); }
	  
	@When("User enters email id {string}")
	public void user_enters_email_id(String emailid) {
	    enterEmailId(emailid);
	}
	@When("User enters password {string}")
	public void user_enters_password(String password) {
	   enterPassword(password); 
	}
	
		
	@When("User clicks on SignIn Button")
	public void user_clicks_on_sign_in_button() {
		clickSignInButton();
	   
	}
	
	@Then("User should see All projects page")
	public void user_should_see_all_projects_page() {
		String actualText =  getAllProjectsText();
		String expectedText = "All projects";
		Assert.assertEquals(actualText, expectedText);
	   
	}
	
	@Then("User should not see All projects page")
	public void user_should_not_see_all_projects_page() {
		boolean actualresult = errorMessagePresence();
		boolean expectedresult = true;
		
		Assert.assertEquals(actualresult, expectedresult);
		
	}
	
	@After
	public static void closeApp() {
		driver.close();
	}

}
