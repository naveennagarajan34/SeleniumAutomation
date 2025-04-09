package steps;

import org.openqa.selenium.WebDriver;

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
	public void select_the_given_and_chapter(String booknChapter) {

		String[] book = booknChapter.split(" ");
		String bookName = book[0];
		String[] chapter = book[1].split(":");
		String chapterNo = chapter[0];
		String verseNo = chapter[1];

		editObj = new EditAndReviewPage(driver);
		editObj.clickBook(bookName, chapterNo, verseNo);

	}

}
