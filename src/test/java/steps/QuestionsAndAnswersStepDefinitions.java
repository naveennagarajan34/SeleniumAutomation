package steps;


import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NavigationMenu;
import pages.QuestionsAndAnswersPage;
import utilities.WebDriverSetup;

public class QuestionsAndAnswersStepDefinitions {

	QuestionsAndAnswersPage qaObj;
	NavigationMenu navObj;
	WebDriver driver;

	public QuestionsAndAnswersStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}

	@And("click on the questions and answers page")
	public void clickQuestionsAndAnswers() throws InterruptedException {
		navObj = new NavigationMenu(driver);
		navObj.clickToNavigateTo_QuestionsAnswers();
	}

	@Then("select the given {string} and chapter in questions pane")
	public void selectTheGivenBook(String booknChapter) {
		String[] book = booknChapter.split(" ");
		String bookName = book[0];
		String[] chapter = book[1].split(":");
		String chapterNo = chapter[0];
		String verseNo = chapter[1];
		qaObj = new QuestionsAndAnswersPage(driver);
		qaObj.selectTheBook(bookName, chapterNo, verseNo);
	}
	
	@When("click on the manage audio button")
	public void clickManageAudio() {
		qaObj = new QuestionsAndAnswersPage(driver);
		qaObj.clickOnManageAudio();
	}
	
	@Then("upload the audio files for the {string}")
	public void uploadTheAudioFiles(String booknChapter) {
		String[] book = booknChapter.split(" ");
		String bookName = book[0]+" "+book[1];
		System.out.println(bookName);
		qaObj.uploadAudioFiles(bookName);
	}
	
	@Then("verify that the play icon appeared")
	public void verify_that_the_play_icon_appeared() {
	   qaObj.verifyPlayIconAppeared();
	}

	@Then("click delete button on the audio and timing file")
	public void click_delete_button_on_the_audio_and_timing_file() {
		qaObj.clickDeleteBtns();
	}

	@Then("click on the save button")
	public void click_on_the_save_button() {
	   qaObj.clickSaveBtn();
	}

	@Then("verify that the play icon disappeared")
	public void verify_that_the_play_icon_disappeared() throws InterruptedException {
	   qaObj.verifyPlayIconDisappeared();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








