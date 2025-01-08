package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderClass;
import pages.LoginSignup;

public class StepDefinition {

	BrowserClass browserObject;
	LoginSignup loginObject;
	HeaderClass headerObject;
	ReadProperties readPropObject = new ReadProperties();

	static WebDriver driver;

	@Given("Launch Chrome browser")
	public void launch_browser() {
		browserObject = new BrowserClass();
		driver = browserObject.openBrowser(driver, readPropObject.getProperty("browser"));
	}

	@And("Navigate to Scriptureforge")
	public void navigateToScriptureforge() {
		loginObject = new LoginSignup();
		driver = loginObject.NavigateToLoginSignup(driver);
	}

	@When("valid {string} and {string} is entered")
	public void valid_and_is_entered(String userName, String password) throws InterruptedException {
		loginObject = new LoginSignup();
		driver = loginObject.loginWithCredentials(userName, password, driver);
	}

	@Then("Login with paratext {string} and {string}")
	public void login_with_paratext_and(String userName, String password) {
		loginObject = new LoginSignup();
		driver = loginObject.loginWithParatext(userName, password, driver);
	}

	@Then("click on the sf logo in the header")
	public void click_on_the_sf_logo_in_the_header() {
		headerObject = new HeaderClass(driver);
		driver = headerObject.sfLogo(driver);
	}

	@AfterAll
	public static void cleanUp() {
		try {
			Thread.sleep(Duration.ofSeconds(20));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.close();
	}
}