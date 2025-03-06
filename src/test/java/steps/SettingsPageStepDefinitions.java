package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
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
}
