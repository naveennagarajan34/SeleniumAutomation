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

import utilities.ReusableMethods;

public class ProjectPage {

	@FindBy(xpath = "//app-navigation")
	private WebElement navigationMenu;

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;
	
	ReusableMethods reuseObj;

	public WebDriver connectToTheProject(String projectCode) {
		
		reuseObj = new ReusableMethods(driver);
		
		reuseObj.implicit_wait_ele(30);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement projName = driver
				.findElement(By.xpath("//b[text()='" + projectCode + "']/parent::span/parent::div//a//span[2]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", projName);
		
		reuseObj.implicit_wait_ele(50);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		System.out.println("Connect button enabled ? " + projName.isEnabled());
		projName.click();
		
		reuseObj.implicit_wait_ele(10);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement connectButton = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
		connectButton.click();

		return driver;
	}

	public void openProject(String projectCode) {
		
//		reuseObj.implicit_wait_ele(30);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String xpath = "//mat-card//b[contains(text(),'" + projectCode + "')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // 15 seconds timeout
	    WebElement projectCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath(xpath)
	    ));
		projectCard.click();
	}

	public WebDriver verifyProjectIsConnected() {
		
		reuseObj = new ReusableMethods(driver);
		
		reuseObj.explicit_wait_ele_visible(navigationMenu, 60);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOf(navigationMenu));
		

		Assert.assertTrue(navigationMenu.isDisplayed(), "Project is not connected successfully");
		return driver;
	}

}
