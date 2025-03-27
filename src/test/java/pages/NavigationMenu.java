package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Overview')]/../parent::a")
	WebElement overviewPage;
	@FindBy(xpath = "//span[contains(text(),'Edit')]/../parent::a")
	WebElement editReviewPage;
	@FindBy(xpath = "//span[contains(text(),'draft')]/../parent::a")
	WebElement generateDraftPage;
	@FindBy(xpath = "//span[contains(text(),'Questions & answers')]/../parent::a")
	WebElement questionsPage;
	@FindBy(xpath = "//span[contains(text(),'Manage questions')]/../parent::a")
	WebElement manageQuestionsPage;
	@FindBy(xpath = "//span[contains(text(),'Sync')]/../parent::a")
	WebElement syncPage;
	@FindBy(xpath = "//span[contains(text(),'Users')]/../parent::a")
	WebElement usersPage;
	@FindBy(xpath = "//span[contains(text(),'Settings')]/../parent::a")
	WebElement settingsPage;

	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver clickToNavigateTo_Overview() {
		overviewPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_EditReview() {
		editReviewPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_GenerateDraft() {
		generateDraftPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_ManageQuestions() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
		manageQuestionsPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_QuestionsAnswers() {
		questionsPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_Sync() {
		syncPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_Users() {
		usersPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_Settings() {
		settingsPage.click();
		return driver;
	}
}
