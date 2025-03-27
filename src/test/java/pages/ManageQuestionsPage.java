package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageQuestionsPage {

	WebDriver driver;

	@FindBy(css = "button[mat-flat-button][color='primary']")
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

	public ManageQuestionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver click_AddQuestionsButton() {
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
//		Assert.assertNotEquals(beforeCount, afterCount);
		return driver;
	}

}
