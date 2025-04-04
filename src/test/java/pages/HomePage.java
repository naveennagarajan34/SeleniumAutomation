package pages;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//ul[@class = 'links']//a[contains(text(),'Learn')]")
	private WebElement learnMoreFooter;

	@FindBy(xpath = "//a[text()='Terms']")
	private WebElement terms;

	@FindBy(xpath = "//a[text()='Privacy']")
	private WebElement privacy;
		
	@FindBy(xpath = "//a[text()='Community Support']")
	private WebElement communitySupport;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver navigateToHomePage(String baseURL) {
		driver.navigate().to(baseURL);
		return driver;
	}

	public WebDriver clickLearnMore() {
		learnMoreFooter.click();
		return driver;
	}

	public WebDriver verifyUserIsOnLearnMorePage() {
		System.out.println("Title is :" + driver.getTitle());
		assertTrue(driver.getTitle().contains("Scripture Forge"));
		return driver;
	}

	public WebDriver Terms() {

		driver.navigate().back();
		terms.click();
		return driver;

	}

	public WebDriver verifyUserIsOnTermsMorePage() {

		System.out.println("Current URL is :" + driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains("Terms"));
		return driver;
	}

	public WebDriver privacy() {

		driver.navigate().back();
		privacy.click();
		return driver;

	}
	
	public WebDriver verifyUserIsOnPrivacyMorePage() {

		System.out.println("Current URL is :" + driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains("Privacy"));
		return driver;
	}
	
	public WebDriver communitySupport() {

		driver.navigate().back();
		communitySupport.click();
		return driver;

	}
	
	public WebDriver verifyUserIscommunitySupportPage() throws InterruptedException {
		
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		it.next();										// Switch to current window
		String nextwin = it.next();
		driver.switchTo().window(nextwin);
		System.out.println("Current URL is :" + driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains("community"));
		return driver;
	}
}
