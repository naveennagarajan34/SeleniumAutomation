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
	
	@Then("Click on the Terms button")
	public void click_on_the_terms_button() {
	   
		homeObject = new HomePage(driver);
		driver = homeObject.Terms();
		
	}
	
	@Then("Verify that the user is redirected to the Terms page")
	public void verify_that_the_user_is_redirected_to_the_terms_page() {
	   
		homeObject = new HomePage(driver);
		driver = homeObject.verifyUserIsOnTermsMorePage();
		
	}
	
	@Then("Click on the Privacy button")
	public void click_on_the_privacy_button() {
		
		homeObject = new HomePage(driver);
		driver = homeObject.privacy();
		
	}
	
	@Then("Verify that the user is redirected to the Privacy page")
	public void verify_that_the_user_is_redirected_to_the_privacy_page() {
		
		homeObject = new HomePage(driver);
		driver = homeObject.verifyUserIsOnPrivacyMorePage();
	   
	}
	
	@Then("Click on the Community Support button")
	public void click_on_the_community_support_button() {
		
		homeObject = new HomePage(driver);
		driver = homeObject.communitySupport();
		
	}
	
	@Then("Verify that the new tab opened for Community Support page")
	public void verify_that_the_new_tab_opened_for_community_support_page() throws InterruptedException {
	    
		homeObject = new HomePage(driver);
		driver = homeObject.verifyUserIscommunitySupportPage();
		
	}
	
	@Then("Click on the Help button")
	public void click_on_the_help_button() throws InterruptedException {
		
		homeObject = new HomePage(driver);
		driver = homeObject.clickHelpPage();
		
	}

	@Then("Verify that the new tab opened for help page")
	public void verify_that_the_new_tab_opened_for_help_page() {
	    
	}
	
}
