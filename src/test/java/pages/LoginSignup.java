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
	
	@FindBy(css="div.login-buttons a.mdl-button--raised")
	private WebElement LoginButton;
	
	@FindBy(css="input[name='email']")
	private WebElement userNameBox;
	
	@FindBy(css="input[name='password']")
	private WebElement passwordBox;
	
	@FindBy(css="span.auth0-label-submit")
	private WebElement loginButton;
	
	@FindBy(css="#email")
	private WebElement emailHolder;
	
	@FindBy(css="input[name='Passwd']")
	private WebElement pwdTextBox;
	
	
	

	
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

		
	
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(userNameBox));
		
		userNameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
		return driver;
	}

	public WebDriver loginWithParatext(String mailId, String password) {
		password = "naveT23LMN#23";
		WebElement ptLoginButton = driver.findElement(By.xpath("//div[contains(text(),'Log in with paratext')]"));
		ptLoginButton.click();
		
		emailHolder.sendKeys(mailId + Keys.ENTER);
		
		WebElement nextButton1 = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton1.click();
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passwordBox = wait
				.until(ExpectedConditions.elementToBeClickable(pwdTextBox));
		passwordBox.sendKeys(password);

		WebElement nextButton2 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		nextButton2.click();

		return driver;
	}


}
