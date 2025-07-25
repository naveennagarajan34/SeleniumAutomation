package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ReusableMethods;

public class QuestionsAndAnswersPage {
	
	WebDriver driver;
	ReusableMethods reusable = new ReusableMethods(driver);

	@FindBy(css = "button.add-audio-button")
	private WebElement manageAudioButton;
	@FindBy(css = "mat-select[panelclass=book-select-menu]")
	private WebElement bookDropdown;
	@FindBy(css = "mat-select[panelclass=chapter-select-menu]")
	private WebElement chapterDropdown;
	@FindBy(css = "input[type='file']")
	private WebElement uploadInputField;
	@FindBy(css = "button#audio-save-btn")
	private WebElement audioSaveButton;
	@FindBy(xpath="//mat-icon[text()='play_circle_outline']/parent::button")
	private WebElement playIcon;
	@FindBy(css = ".wrapper-audio .delete")
	private WebElement audioDeleteButton;
	@FindBy(css = ".wrapper-timing .delete")
	private WebElement timingDataDeleteButton;
	@FindBy(css=".cdk-overlay-backdrop")
	private WebElement overlayLocator;
	

	public QuestionsAndAnswersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectTheBook(String bookName, String chapterNo, String verseNo) {
		bookDropdown.click();
		WebElement book = driver.findElement(By.xpath("//span[text()='" + bookName + "']/parent::mat-option"));
		
		reusable.explicit_wait_ele_visible(book, 30);
		book.click();
		chapterDropdown.click();
		WebElement chapter = driver.findElement(By.xpath("//span[text()='" + chapterNo + "']/parent::mat-option"));
		chapter.click();
	}

	public void clickOnManageAudio() {
		
		reusable.explicit_wait_ele_invisble(overlayLocator,30);
		reusable.explicit_wait_ele_clickable(manageAudioButton, 0);
		manageAudioButton.click();
	}
	
	public void uploadAudioFiles(String book) {
	    File audioFile = new File("src/test/resources/AudioFiles/John 1.mp3");
	    File timingFile = new File("src/test/resources/AudioFiles/John 1.txt");

	    // Get absolute paths
	    String audioFilePath = audioFile.getAbsolutePath();
	    String timingFilePath = timingFile.getAbsolutePath();

	    // Upload both files (newline separator for multiple files)
	    uploadInputField.sendKeys(audioFilePath + "\n" + timingFilePath);
	    audioSaveButton.click();
	}
	
	public void verifyPlayIconAppeared() {
		
		reusable.explicit_wait_ele_visible(playIcon,30);
		
		Assert.assertTrue(playIcon.isDisplayed(), "PlayIcon is visible");

	}
	
	public void clickDeleteBtns() {
		
		audioDeleteButton.click();
		timingDataDeleteButton.click();
}
	
	public void clickSaveBtn() {
		
		audioSaveButton.click();
	}
	
	public void verifyPlayIconDisappeared() throws InterruptedException {
		
		Thread.sleep(3000);
		boolean playiconNotVisible = reusable.ele_disappeared(playIcon, 30);
		Assert.assertEquals(true, playiconNotVisible);
		

	}
	
	
	
	
}
