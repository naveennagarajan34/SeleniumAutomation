package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	WebDriver driver;

	public ReusableMethods(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void explicit_wait_ele_visible(WebElement element, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void explicit_wait_ele_enabled(WebElement element, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(driver -> element.isEnabled());

	}

	public void explicit_wait_ele_displayed(WebElement element, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(driver -> element.isDisplayed());

	}

	public void explicit_wait_ele_presence(By element, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}

	public void implicit_wait_ele(int sec) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}

	public void explicit_wait_ele_invisble(WebElement element, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	

}
