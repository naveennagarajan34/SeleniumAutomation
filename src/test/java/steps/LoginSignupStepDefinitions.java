package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderClass;
import pages.HomePage;
import pages.LoginSignup;
import utilities.BrowserClass;
import utilities.ReadProperties;
import utilities.ReadWriteExcel;
import utilities.TestLogger;
import utilities.WebDriverSetup;

public class LoginSignupStepDefinitions {

	LoginSignup loginObject;
	BrowserClass browserObject;
	HomePage homeObject;
	ReadProperties readPropObject = new ReadProperties();
  
	WebDriver driver;

	public LoginSignupStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}

	@Given("Navigate to Scriptureforge")
	public void navigateToScriptureforge() {
		homeObject = new HomePage(driver);
		driver = homeObject.navigateToHomePage(readPropObject.getProperty("baseURL"));
		TestLogger.startTestCase("Navigated to ScriptureForge application");
	}

	@When("clicking on login button")
	public void clickOnLoginButton() {
		loginObject = new LoginSignup(driver);
		driver = loginObject.clickOnLoginButton();
	}

	@Then("login with valid user name and password")
	public void valid_and_is_entered() throws InterruptedException, IOException {

		ReadWriteExcel.loadExcelFile(readPropObject.getProperty("excel_data_path"), "credentials");

		String username = ReadWriteExcel.getCellValue(1, 0);
		String password = ReadWriteExcel.getCellValue(1, 1);
		String loginType = ReadWriteExcel.getCellValue(1, 2);
		loginObject = new LoginSignup(driver);
		if (loginType.equalsIgnoreCase("email")) {
			driver = loginObject.loginWithCredentials(username, password);
		} else if (loginType.equalsIgnoreCase("paratext")) {
			driver = loginObject.loginWithParatext(username, password);
		}
	}
	
	@And("verify that the user is loggedin successfully")
	public void verify_user_loggedin() {
		HeaderClass header= new HeaderClass(driver);
		header.verifyHeaderIsVisible();
	}
	
	@Then("click on the logout button and verify")
	public void click_on_the_logout_button_and_verify() {
	   
		loginObject = new LoginSignup(driver);
		loginObject.logoutBtnclick();
		
	}
	
	@Then("login with invalid {string} and {string}")
	public void login_with_invalid_credentials(String username, String password) {
		loginObject = new LoginSignup(driver);
		loginObject.login_with_invalid_credentials(username, password);
	}
	
	@And("verify that wrong email or password banner appeared")
	public void verify_invalid_credentials_login () {
		loginObject = new LoginSignup(driver);
		loginObject.wrongEmailOrPasswordMessage();
	}
	
}
