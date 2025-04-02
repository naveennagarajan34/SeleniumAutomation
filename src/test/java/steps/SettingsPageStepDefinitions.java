package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingsPage;
import utilities.WebDriverSetup;

public class SettingsPageStepDefinitions {

	SettingsPage settingsObject;
	private WebDriver driver;

	public SettingsPageStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}

	@When("clicking on the Settings")
	public void clickSettingsButton() throws InterruptedException {
		settingsObject = new SettingsPage(driver);
		driver = settingsObject.clickSettingsButton();
	}

	@And("click on the Delete button")
	public void clickOnDeleteButton() {
		settingsObject = new SettingsPage(driver);
		settingsObject.clickDeleteButton();
	}

	@And("click on the source project field")
	public void click_on_the_source_project_field() {
		settingsObject = new SettingsPage(driver);
		settingsObject.clickOnTheSourceProjectField();
	}

	@Then("select the {string} project from the list")
	public void select_the_source_project(String source) {
		settingsObject = new SettingsPage(driver);
		settingsObject.selectSourceProject(source);
	}

	@And("verify that the source project is added")
	public void verify_source_added() {
		settingsObject = new SettingsPage(driver);
		settingsObject.verifySourceAdded();
	}
}
