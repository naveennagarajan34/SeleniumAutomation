package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    	userObject.verifyInviteSent();
    }
    
    @And("click on the share button")
    public void clickShare() {
    	userObject = new UsersPage(driver);
    	userObject.clickShareButton();
    }
    
  
    
    @And("verify that the invite has been copied")
    public void verifyLinkCopiedToClipboard() {
    	userObject = new UsersPage(driver);
    	userObject.verifyLinkCopied();
    }
    
    @Then("click on the three dot button")
    public void click_on_the_three_dot_button() {
    	
    	userObject = new UsersPage(driver);
    	userObject.clickThreeDotBtn();
    }
    
    @When("Open the Edit roles and permission dialog")
    public void open_the_edit_roles_and_permission_dialog() {
    	
    	
    	
    }

    @Then("Change the checker user to viewer user")
    public void change_the_checker_user_to_viewer_user() {
        
    	
    }

    @Then("verify that the user role updated to viewer user")
    public void verify_that_the_user_role_updated_to_viewer_user() {
       
    	
    }
}
