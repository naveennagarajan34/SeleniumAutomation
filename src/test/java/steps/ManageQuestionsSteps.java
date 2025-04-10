package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ManageQuestionsPage;
import pages.NavigationMenu;
import utilities.WebDriverSetup;

public class ManageQuestionsSteps {
	NavigationMenu navigate;
	ManageQuestionsPage manage;

	WebDriver driver;

	public ManageQuestionsSteps() {
		this.driver = WebDriverSetup.getDriver();
		
	}

	@Then("click on the manage questions")
	public void clickManageQuestions() throws InterruptedException {
		navigate = new NavigationMenu(driver);
		driver = navigate.clickToNavigateTo_ManageQuestions();
	}

	@And("click Add Questions button and enter the scripture reference {string},{string},{string} and verify")
	public void clickAddQuestionsButton(String starref, String endref,String question) {
		manage = new ManageQuestionsPage(driver);
		driver = manage.click_AddQuestionsButton();
		manage.enter_scripture_reference(starref, endref, question);
	}
	
	@Then("click on the archive button on the {string}")
	public void click_on_the_archive_button_on_the(String string) {
	    
		manage = new ManageQuestionsPage(driver);
		manage.archiveQuestion(string);
		
	}

}
