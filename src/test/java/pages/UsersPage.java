package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {
	
	WebDriver driver;
	
	@FindBy(css="#invitation-language .mat-mdc-text-field-wrapper")
	private WebElement localeBox;
	@FindBy(css = "input[type='email']")
	private WebElement emailField;
	@FindBy(xpath = "//mat-select[@formcontrolname='role']")
	private WebElement roleBox;
	@FindBy(css = "button#send-btn")
	private WebElement sendButton;
	@FindBy(css="div.mat-mdc-snack-bar-label[matsnackbarlabel]")
	private WebElement snackbar;
	@FindBy(xpath="//span[text()=' Share ']/parent::button")
	private WebElement shareBtn;
	@FindBy(css="a[title='Change invitation language']")
	private WebElement uiChange;
	@FindBy(css="div.mat-mdc-dialog-actions button.mat-unthemed")
	private WebElement copyButton;

	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUsersFromNavBar() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usersLink = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("//mat-drawer[@id='menu-drawer']//a[contains(@href, '/users')]")
			));
		usersLink.click();
	}
	
	public void sendEmailSelectRoleAndInviteLanguage() {
		String role = "Viewer";				// need to be updated to dynamic
		String locale = "Bahasa";			// need to be updated to dynamic
		String recipientMailId = "Naveen@naveen.com"; // need to be updated to dynamic
		
		emailField.sendKeys(recipientMailId);
		
		roleBox.click();
		WebElement roleSelect = driver.findElement(By.xpath("//mat-option//div[contains(text(),'"+role+"')]"));
		roleSelect.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		localeBox.click();
		WebElement localeSelect = driver.findElement(By.xpath("//mat-option//span[contains(text(),'"+locale+"')]"));
		localeSelect.click();
		
		sendButton.click();
	}
	public void verifyInviteSent() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	    wait.until(ExpectedConditions.visibilityOf(snackbar));
	    
	    assertTrue(snackbar.getText().contains("email has been sent"),"Snackbar text does not contain expected text");
	}
	
	public void clickShareButton() {

		String inviteUi = "Bahasa";		// need to be updated for dynamic selection
		shareBtn.click();
		uiChange.click();
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	    wait.until(ExpectedConditions.visibilityOf(uiChange));
		
		WebElement inviteLanguage = driver.findElement(By.xpath("//mat-list-option/span/child::span[contains(text(),'"+inviteUi+"')]/ancestor::mat-list-option"));
		
	    wait.until(ExpectedConditions.visibilityOf(inviteLanguage));
		
		inviteLanguage.click();
		wait.until(ExpectedConditions.visibilityOf(copyButton));
		copyButton.click();
	}
	
	public void verifyLinkCopied() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	    wait.until(ExpectedConditions.visibilityOf(snackbar));
	    
	    assertTrue(snackbar.getText().contains("copied"),"Snackbar text does not contain expected text");
	}
	
}
