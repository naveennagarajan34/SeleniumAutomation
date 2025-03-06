package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.UsersPage;
import utilities.WebDriverSetup;

public class UsersPageStepsDefinitions {
	
	UsersPage userObject;
	
	WebDriver driver;
	
    public UsersPageStepsDefinitions() {
        this.driver = WebDriverSetup.getDriver();;
    }
    
    @And("click on the users")
    public void clickOnTheUsers() throws InterruptedException {
    	userObject = new UsersPage(driver);
    	userObject.clickOnUsersFromNavBar();
    }
    
    @Then("enter the email, select role and invitation language and send")
    public void enterEmailSelectRoleAndLanguage() {
    	userObject = new UsersPage(driver);
    	userObject.sendEmailSelectRoleAndInviteLanguage();
    }
    
    @And("verify that the invite has been sent")
    public void clickSendAndVerifyInviteSent() {
    	userObject = new UsersPage(driver);
    }
}
