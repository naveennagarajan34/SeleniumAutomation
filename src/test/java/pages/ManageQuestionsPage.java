package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ReusableMethods;

public class ManageQuestionsPage {

	WebDriver driver;
	ReusableMethods resue; 

	@FindBy(xpath = "//span[text()='Add Question']/ancestor::button")
	private WebElement addQuestionsButton;
	@FindBy(css = "input[formcontrolname='scriptureStart']")
	private WebElement startReference;
	@FindBy(css = "input[formcontrolname='scriptureEnd']")
	private WebElement endReference;
	@FindBy(css = "#textarea[formcontrolname='text']")
	private WebElement quesTextBox;
	@FindBy(css = "button#question-save-btn[type='Submit']")
	private WebElement saveQuestionBtn;
	@FindBy(xpath = "//mat-card-content//div[contains(text(),'Questions')]/../div[@class='stat-total']")
	private WebElement questionsCount;
	@FindBy(xpath="//div[@id='text-with-questions-list']/mat-expansion-panel[1]")
	private WebElement questionBookExpand;
	@FindBy(xpath="//mat-selection-list[@role='listbox']//mat-expansion-panel-header[@role='button']")
	private WebElement chapterBookExpand;
	@FindBy(css="span.overflow-ellipsis")
	private WebElement questionText;
	@FindBy(xpath="//span[text()=' Archive ']/parent::button")
	private WebElement archiveBtnDialog;
	

	public ManageQuestionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver click_AddQuestionsButton() {
		resue = new ReusableMethods(driver);
		resue.explicit_wait_ele_visible(addQuestionsButton, 30);
		addQuestionsButton.click();
		return driver;
	}

	public WebDriver enter_scripture_reference(String start, String end, String text) {
		int beforeCount = Integer.parseInt(questionsCount.getText());
		startReference.sendKeys(start);
		endReference.sendKeys(end);
		quesTextBox.sendKeys(text);
		saveQuestionBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		int afterCount = Integer.parseInt(questionsCount.getText());
//		resue = new ReusableMethods(driver);
//		resue.explicit_wait_ele_visible(questionBookExpand, 30);
//		questionBookExpand.click();
//		resue.explicit_wait_ele_clickable(chapterBookExpand, 30);
//		chapterBookExpand.click();
//		resue.explicit_wait_ele_visible(questionText, 30);
//		assertTrue(questionText.getText().contains(text));
//		Assert.assertNotEquals(beforeCount, afterCount);
		return driver;
	}
	
	public void archiveQuestion(String book) {
		
		WebElement archiveBtnBook = driver.findElement(By.xpath("//span[text()='"+book+"']/parent::mat-panel-title//button"));
		resue = new ReusableMethods(driver);
		resue.explicit_wait_ele_visible(archiveBtnBook, 30);
		archiveBtnBook.click();
		resue.explicit_wait_ele_visible(archiveBtnDialog, 30);
		archiveBtnDialog.click();
	}

}
