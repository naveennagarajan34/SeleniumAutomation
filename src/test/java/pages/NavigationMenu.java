package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableMethods;

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
	@FindBy(xpath = "//span[contains(text(),'Sync')]/ancestor::a")
	//@FindBy(id="sync-icon")
	WebElement syncPage;
	@FindBy(xpath = "//span[contains(text(),'Users')]/../parent::a")
	WebElement usersPage;
	@FindBy(xpath = "//span[contains(text(),'Settings')]/../parent::a")
	WebElement settingsPage;
	
	@FindBy(css="app-root mat-progress-bar")
	WebElement progressBar;

	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver clickToNavigateTo_Overview() {
		overviewPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_EditReview() {
		ReusableMethods reuse = new ReusableMethods(driver);
		reuse.explicit_wait_ele_invisble(progressBar, 30);
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

	public WebDriver clickToNavigateTo_QuestionsAnswers() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
		questionsPage.click();
		return driver;
	}

	public WebDriver clickToNavigateTo_Sync() {
		
		ReusableMethods reuse = new ReusableMethods(driver);
		reuse.explicit_wait_ele_invisble(progressBar, 30);
		reuse.explicit_wait_ele_displayed(syncPage, 30);
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
