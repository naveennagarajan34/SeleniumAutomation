package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HeaderClass;
import pages.LoginSignup;

public class StepDefinition {

	BrowserClass browserObject;
	LoginSignup loginObject;
	HeaderClass headerObject;
	ReadProperties readPropObject = new ReadProperties();

	static WebDriver driver;

	@Given("Launch browser")
	public void launch_browser() {
		browserObject = new BrowserClass();
		driver = browserObject.openBrowser(driver, readPropObject.getProperty("browser"));
	}

	@And("Navigate to Scriptureforge")
	public void navigateToScriptureforge() {
		loginObject = new LoginSignup();
		driver = loginObject.NavigateToLoginSignup(driver);
	}

	@Then("login via {string} with {string} and {string}")
	public void valid_and_is_entered(String loginVia, String userName, String password) throws InterruptedException {
		loginObject = new LoginSignup();
		if (loginVia.equalsIgnoreCase("email")) {
			driver = loginObject.loginWithCredentials(userName, password, driver);
		} else if (loginVia.equalsIgnoreCase("paratext")) {
			driver = loginObject.loginWithParatext(userName, password, driver);
		}
	}

	@Then("click on the sf logo in the header")
	public void click_on_the_sf_logo_in_the_header() {
		headerObject = new HeaderClass(driver);
		driver = headerObject.sfLogo(driver);
	}

	@And("click on the profile icon in the header")
	public void click_on_the_profile_icon_in_the_header() {
		headerObject = new HeaderClass(driver);
		driver = headerObject.clickProfile(driver);
	}

	@Then("change the user name to {string}")
	public void changeTheUsername(String name) {
		headerObject = new HeaderClass(driver);
		driver = headerObject.changeName(driver, name);
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