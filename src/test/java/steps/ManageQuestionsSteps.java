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
		;
	}

	@Then("click on the manage questions")
	public void clickManageQuestions() throws InterruptedException {
		navigate = new NavigationMenu(driver);
		driver = navigate.clickToNavigateTo_ManageQuestions();
	}

	@And("click Add Questions button and enter the scripture reference and verify")
	public void clickAddQuestionsButton() {
		manage = new ManageQuestionsPage(driver);
		driver = manage.click_AddQuestionsButton();
		manage.enter_scripture_reference("GEN 1:1", "GEN 1:2", "This is sample question");
	}
}
