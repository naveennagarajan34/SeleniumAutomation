package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderClass {

	@FindBy(xpath = "//a[@id='sf-logo-button']//mat-icon")
	private WebElement sfLogoElement;
	@FindBy(xpath = "//mat-toolbar-row//button[@title='Language']")
	private WebElement sfUiElement;
	@FindBy(xpath = "//app-avatar")
	private WebElement avatarIcon;
	@FindBy(xpath = "//mat-icon[text()='edit']/ancestor::button")
	private WebElement editNameIcon;
	@FindBy(xpath = "//h1[contains(text(),'Update your name')]/..//input")
	private WebElement nameTextBox;
	@FindBy(xpath = "//button//span[contains(text(),'Update')]")
	private WebElement updateButton;

	WebDriver driver;

	public HeaderClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver sfLogo(WebDriver driver) {
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

	public WebDriver clickProfile(WebDriver driver) {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(avatarIcon.isDisplayed());
		actions.moveToElement(avatarIcon).click().perform();
		return driver;
	}

	public WebDriver changeName(WebDriver driver, String name) {
		editNameIcon.click();
		nameTextBox.clear();
		nameTextBox.sendKeys(name);
		updateButton.click();
		return driver;
	}
}
