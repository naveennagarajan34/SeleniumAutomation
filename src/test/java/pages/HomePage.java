package pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

	@FindBy(xpath = "//a[text()='Help']")
	private WebElement help;

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
		assertTrue(driver.getTitle().contains("Scripture Forge"));
		return driver;
	}

	public WebDriver Terms() {
		driver.navigate().back();
		terms.click();
		return driver;
	}

	public WebDriver verifyUserIsOnTermsMorePage() {
		assertTrue(driver.getCurrentUrl().contains("terms"));
		return driver;
	}

	public WebDriver privacy() {
		driver.navigate().back();
		privacy.click();
		return driver;
	}

	public WebDriver verifyUserIsOnPrivacyMorePage() {
		assertTrue(driver.getCurrentUrl().contains("privacy"));
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
		it.next(); // Switch to current window
		String nextwin = it.next();
		driver.switchTo().window(nextwin);
		assertTrue(driver.getCurrentUrl().contains("community"));
		// driver.close();
		return driver;
	}

	public WebDriver clickHelpPage() throws InterruptedException {
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<>(windows);
		driver.switchTo().window(handlesList.get(0));
		help.click();
		return driver;
	}

	public WebDriver verifyHelpPage() {
		assertTrue(driver.getCurrentUrl().contains("help"));
		return driver;
	}
}
