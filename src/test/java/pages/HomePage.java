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
	
	public WebDriver navigateToHomePage(String baseURL) {
		driver.navigate().to(baseURL);
		return driver;
	}
	
	public WebDriver clickLearnMore() {
		learnMoreFooter.click();
		return driver;
	}
	
	public WebDriver verifyUserIsOnLearnMorePage() {
		System.out.println("Title is :"+ driver.getTitle());
		assertTrue(driver.getTitle().contains("Getting Started"));
		return driver;
	}


	
}
