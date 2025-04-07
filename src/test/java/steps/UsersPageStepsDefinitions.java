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
    
    @Then("click on the three dots button of {string}")
    public void click_on_the_three_dot_button_ofUser(String user) {
    	
    	userObject = new UsersPage(driver);
    	userObject.clickThreeDotBtn(user);
    }
    
    @When("Open the Edit roles and permission dialog")
    public void open_the_edit_roles_and_permission_dialog() {
    	
    	userObject = new UsersPage(driver);
    	userObject.EditBtnClick();
    	
    }

    @Then("Change the role of the user to {string}")
    public void change_the_user_role_to_given_role(String role) {
        
    	userObject = new UsersPage(driver);
    	userObject.updateRole(role);
    }

    @Then("verify that the {string} role updated to {string}")
    public void verify_that_the_user_role_updated_to_given_role(String user, String role) {
       
    	userObject = new UsersPage(driver);
    	userObject.roleVerify(role,user);
    }
}
