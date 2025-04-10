package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EditAndReviewPage;
import pages.NavigationMenu;
import utilities.WebDriverSetup;

public class EditAndReviewStepDefintions {

	EditAndReviewPage editObj;
	WebDriver driver;

	public EditAndReviewStepDefintions() {
		this.driver = WebDriverSetup.getDriver();
	}

	@Then("click on the Edit and review page")
	public void click_on_the_edit_and_review_page() {
		NavigationMenu nav = new NavigationMenu(driver);
		nav.clickToNavigateTo_EditReview();
	}

	@Then("select the given {string} and chapter")
	public void select_the_given_book_and_chapter(String booknChapter) {
		String[] book = booknChapter.split(" ");
		String bookName = book[0];
		String[] chapter = book[1].split(":");
		String chapterNo = chapter[0];
		String verseNo = chapter[1];
		editObj = new EditAndReviewPage(driver);
		editObj.clickBook(bookName, chapterNo, verseNo);
	}
	
	@Then("click on add tab button")
	public void click_add_tab_button() {
		editObj = new EditAndReviewPage(driver);
		editObj.clickOnAddTabButton();
	}
	
	@And("select the {string} and verify")
	public void select_and_open_the_given_tab(String tab) {
		editObj = new EditAndReviewPage(driver);
		editObj.openTab(tab);
	}

}