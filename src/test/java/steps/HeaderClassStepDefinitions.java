package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.HeaderClass;
import utilities.WebDriverSetup;

public class HeaderClassStepDefinitions {

	HeaderClass headerObject;
	
	public HeaderClassStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}

	private WebDriver driver;

	@Then("click on the sf logo in the header")
	public void click_on_the_sf_logo_in_the_header() {
		headerObject = new HeaderClass(driver);
		driver = headerObject.sfLogo();
	}

	@And("click on the profile icon in the header")
	public void click_on_the_profile_icon_in_the_header() {
		headerObject = new HeaderClass(driver);
		driver = headerObject.clickProfile();
	}

	@Then("change the user name to {string}")
	public void changeTheUsername(String name) {
		headerObject = new HeaderClass(driver);
		driver = headerObject.changeName(name);
	}

	@And("verify that the user name is changed to {string}")
	public void verifyUserNameIsUpdatedToGivenName(String newName) {
		headerObject = new HeaderClass(driver);
		headerObject.verifyNameIsUpdated(newName);
	}
}
