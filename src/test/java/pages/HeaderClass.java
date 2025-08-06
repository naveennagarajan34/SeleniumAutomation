package pages;

import utilities.ReusableMethods;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderClass {

	@FindBy(css = "#sf-logo-button .mat-icon")
	private WebElement sfLogoElement;
	@FindBy(css = "[title=\"Language\"]")
	private WebElement sfUiElement;
	@FindBy(css = "#avatarId")
	private WebElement avatarIcon;
	@FindBy(css = "#edit-name-btn")
	private WebElement editNameIcon;
	@FindBy(css = "input.mat-mdc-form-field-input-control")
	private WebElement nameTextBox;
	@FindBy(css = "#submit-button span.mdc-button__label")
	private WebElement updateButton;
	@FindBy(css = "div#user-menu-name")
	private WebElement nameTextUI;
	@FindBy(css = "header .mat-toolbar")
	private WebElement header;

	WebDriver driver;

	public HeaderClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver sfLogo() {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(sfLogoElement.isDisplayed());
		actions.moveToElement(sfLogoElement).click().perform();
		return driver;
	}

	public WebDriver sfUi(WebDriver driver) {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(sfUiElement.isDisplayed());
		actions.moveToElement(sfUiElement).click().perform();
		return driver;
	}

	public WebDriver clickProfile() {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		actions.moveToElement(avatarIcon).click().perform();
		return driver;
	}

	public WebDriver changeName(String name) {
		editNameIcon.click();
		nameTextBox.clear();
		nameTextBox.sendKeys(name);
		updateButton.click();
		return driver;
	}
	
	public WebDriver verifyNameIsUpdated(String newname) {
		clickProfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualName = nameTextUI.getText();
		System.out.println(actualName);
		assertTrue(actualName.equals(newname));
		return driver;
	}
	
	public void verifyHeaderIsVisible() {
		ReusableMethods reuse = new ReusableMethods(driver);
		reuse.explicit_wait_ele_displayed(header, 30);
	}
}
