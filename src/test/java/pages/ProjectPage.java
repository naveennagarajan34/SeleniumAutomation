package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {

	//
//	private WebElement learnMoreFooter;

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	public WebDriver connectToTheProject(String projectCode) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement projName = driver
				.findElement(By.xpath("//*[text()='" + projectCode + "']/parent::span/parent::div//a//span[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", projName);
		projName.click();

		WebElement connectButton = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
		connectButton.click();

		return driver;
	}

}
