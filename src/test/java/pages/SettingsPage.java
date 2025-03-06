package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
	WebDriver driver;

//	@FindBy(xpath = "//mat-drawer[@id='menu-drawer']//a[contains(@href, '/settings')]")
//	private WebElement settingsMenu;
	
	@FindBy(css="#delete-btn")
	private WebElement deleteProjectBtn;
	
	@FindBy(xpath="//mat-dialog//input")
	private WebElement projectNameBox;
	
	@FindBy(css="#project-delete-btn")
	private WebElement confirmDeleteProjectBtn;
	
//	@FindBy(xpath="")
//	private WebElement projectName;
	
	

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver clickSettingsButton() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(Duration.ofSeconds(3));
		
		WebElement settingsLink = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("//mat-drawer[@id='menu-drawer']//a[contains(@href, '/settings')]")
			));    

		settingsLink.click();
		return driver;
	}

	public WebDriver clickDeleteButton() {
		
		String projectName = "Projet de Robotica";

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));  	// Wait for up to 10 seconds
		wait.until(driver -> deleteProjectBtn.isEnabled());  						// Wait until the button is enabled		
		deleteProjectBtn.click();
		
		projectNameBox.sendKeys(projectName);
		confirmDeleteProjectBtn.click();
		
		return driver;
	}
}
