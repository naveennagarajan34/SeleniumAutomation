package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginSignup;
import utilities.BrowserClass;
import utilities.ReadProperties;
import utilities.WebDriverSetup;

public class LoginSignupStepDefinitions {
	
	LoginSignup loginObject;
	BrowserClass browserObject;
	HomePage homeObject;
	ReadProperties readPropObject = new ReadProperties();
	
	WebDriver driver;
	
    public LoginSignupStepDefinitions() {
        this.driver = WebDriverSetup.getDriver();;
    }

	@Given("Navigate to Scriptureforge")
	public void navigateToScriptureforge() {
		homeObject = new HomePage(driver);
		driver = homeObject.navigateToHomePage(readPropObject.getProperty("baseURL"));
	}
	
	@When("clicking on login button")
	public void clickOnLoginButton() {
		loginObject = new LoginSignup(driver);
		driver = loginObject.clickOnLoginButton();
	}

	@Then("login via {string} with {string} and {string}")
	public void valid_and_is_entered(String loginVia, String userName, String password) throws InterruptedException {
		loginObject = new LoginSignup(driver);
		if (loginVia.equalsIgnoreCase("email")) {
			driver = loginObject.loginWithCredentials(userName, password);
		} else if (loginVia.equalsIgnoreCase("paratext")) {
			driver = loginObject.loginWithParatext(userName, password);
		}
	}
}
