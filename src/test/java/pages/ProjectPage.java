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
import org.testng.Assert;

public class ProjectPage {

	@FindBy(xpath = "//app-navigation")
	private WebElement navigationMenu;

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	public WebDriver connectToTheProject(String projectCode) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement projName = driver
				.findElement(By.xpath("//b[text()='" + projectCode + "']/parent::span/parent::div//a//span[2]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", projName);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println("Connect button enabled ? "+projName.isEnabled());
		projName.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement connectButton = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
		connectButton.click();

		return driver;
	}

	public WebDriver verifyProjectIsConnected() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(navigationMenu));
		
		Assert.assertTrue(navigationMenu.isDisplayed(), "Project is not connected successfully");
		return driver;
	}

}
