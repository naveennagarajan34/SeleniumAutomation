package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginSignup {
	
	@FindBy(xpath="//div[@class=\"top-bar\"]//child::a[contains(text(),'Log In')]")
	private WebElement LoginButton;
	
	WebDriver driver;
	
	public LoginSignup(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

	public WebDriver clickOnLoginButton() {
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public WebDriver loginWithCredentials(String username, String password)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement userNameBox = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement passwordBox = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@name=\"submit\"]"));
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(userNameBox));
		
		userNameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
		return driver;
	}

	public WebDriver loginWithParatext(String mailId, String password) {
		password = "nave";
		WebElement ptLoginButton = driver.findElement(By.xpath("//div[contains(text(),'Log in with paratext')]"));
		ptLoginButton.click();
		WebElement emailHolder = driver.findElement(By.xpath("//input[@type='email']"));
		emailHolder.sendKeys(mailId + Keys.ENTER);
		WebElement nextButton1 = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton1.click();
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passwordBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordBox.sendKeys(password);

		WebElement nextButton2 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		nextButton2.click();

		return driver;
	}


}
