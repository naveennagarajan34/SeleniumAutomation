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

import utilities.ReusableMethods;

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
	@FindBy (xpath="//span[contains(text(),'Edit roles')]")
	private WebElement EditPermissionsBtn;
	@FindBy (css=".mat-mdc-dialog-content h3")
	private WebElement EditDialog;
	@FindBy(xpath="//span[text()=' Save ']")
	private WebElement saveBtn;
	
	
	By usersLink = By.xpath("//mat-drawer[@id='menu-drawer']//a[contains(@href, '/users')]");
	
	By roleCol = By.xpath("//div[contains(text(),'Checker')]/ancestor::tr/td[contains(@class,'mat-column-role')]/em");
	
	ReusableMethods reuseObj;

	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUsersFromNavBar() throws InterruptedException {
		Thread.sleep(3000);
		
		reuseObj = new ReusableMethods(driver);
		
		reuseObj.explicit_wait_ele_presence(usersLink, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement usersLink = wait.until(ExpectedConditions.presenceOfElementLocated(
//			    By.xpath("//mat-drawer[@id='menu-drawer']//a[contains(@href, '/users')]")
//			));
		
		driver.findElement(usersLink).click();
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
		
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_visible(snackbar, 10);
		
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//	    wait.until(ExpectedConditions.visibilityOf(snackbar));
	    
	    assertTrue(snackbar.getText().contains("email has been sent"),"Snackbar text does not contain expected text");
	}
	
	public void clickShareButton() {

		String inviteUi = "Bahasa";		// need to be updated for dynamic selection
		shareBtn.click();
		uiChange.click();
		
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_visible(uiChange, 10);
		
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//	    wait.until(ExpectedConditions.visibilityOf(uiChange));
		
		WebElement inviteLanguage = driver.findElement(By.xpath("//mat-list-option/span/child::span[contains(text(),'"+inviteUi+"')]/ancestor::mat-list-option"));
		
		reuseObj.explicit_wait_ele_visible(inviteLanguage, 10);
		
	    //wait.until(ExpectedConditions.visibilityOf(inviteLanguage));
		
		inviteLanguage.click();
		
		reuseObj.explicit_wait_ele_visible(copyButton, 10);
		
		//wait.until(ExpectedConditions.visibilityOf(copyButton));
		
		copyButton.click();
	}
	
	public void verifyLinkCopied() {
		
		
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_visible(snackbar, 10);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//	    wait.until(ExpectedConditions.visibilityOf(snackbar));
	    
	    assertTrue(snackbar.getText().contains("copied"),"Snackbar text does not contain expected text");
	}
	
	public void clickThreeDotBtn(String user) {
		
		WebElement threeDotBtn = driver.findElement(By.xpath("//div[contains(text(),'"+user+"')]/ancestor::tr//button"));
		threeDotBtn.click();
	}
	
	public void EditBtnClick() {
		
		EditPermissionsBtn.click();
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_visible(EditDialog,50);
		assertTrue(EditDialog.getText().equals("Roles"));
	}
	
	public void updateRole(String role) {
		
		WebElement userRole =driver.findElement(By.xpath("//span[text()='"+role+"']/ancestor::div[contains(@class,'mat-internal-form-field')]/div/input"));
		userRole.click();
		saveBtn.click();
		
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_invisble(EditDialog,30);
		
		
	}
	
	public void roleVerify(String role,String user)  {
		
		WebElement roleColumn = driver.findElement(By.xpath("//div[contains(text(),'"+user+"')]/ancestor::tr/td[contains(@class,'mat-column-role')]/em"));
		
		reuseObj = new ReusableMethods(driver);
		reuseObj.explicit_wait_ele_presence(roleCol,50);
		assertTrue(roleColumn.getText().equals(role));
	}
	
}
