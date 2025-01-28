package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.WebDriverSetup;

public class HomePageStepDefinitions {

	HomePage homeObject;
	
	private WebDriver driver;

	public HomePageStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}
	
	@Then("Click on the Learn more button")
	public void clickOnLearnMore() {
		homeObject = new HomePage(driver);
		driver = homeObject.clickLearnMore();
	}
	
	@And("verify that the user is redirected to learn more page")
	public void verifyUserIsRedirectedToLearnMore() {
		homeObject = new HomePage(driver);
		driver = homeObject.verifyUserIsOnLearnMorePage();
	}
	
}
