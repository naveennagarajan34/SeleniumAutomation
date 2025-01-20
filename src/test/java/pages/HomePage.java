package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//ul[@class = 'links']//a[contains(text(),'Learn')]")
	private WebElement learnMoreFooter;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver navigateToHomePage(WebDriver driver) {
		driver.navigate().to("https://qa.scriptureforge.org/");
		return driver;
	}
	
	public WebDriver clickLearnMore(WebDriver driver) {
		learnMoreFooter.click();
		return driver;
	}
	
	public WebDriver verifyUserIsOnLearnMorePage(WebDriver driver) {
		System.out.println("Title is :"+ driver.getTitle());
		assertTrue(driver.getTitle().contains("Getting Started"));
		return driver;
	}


	
}
