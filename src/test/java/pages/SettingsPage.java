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

import utilities.ReusableMethods;

public class SettingsPage {
	WebDriver driver;
	
	ReusableMethods reuseobj;

//	@FindBy(xpath = "//mat-drawer[@id='menu-drawer']//a[contains(@href, '/settings')]")
//	private WebElement settingsMenu;

	@FindBy(css = "#delete-btn")
	private WebElement deleteProjectBtn;

	@FindBy(xpath = "//mat-dialog//input")
	private WebElement projectNameBox;

	@FindBy(css = "#project-delete-btn")
	private WebElement confirmDeleteProjectBtn;

	@FindBy(css = "input[role='combobox'][type='text']")
	private WebElement sourceProjectField;

	@FindBy(css = "div[role='listbox'].project-select")
	private WebElement projectsListDialog;

	@FindBy(xpath = "//app-project-select/following-sibling::app-write-status//mat-icon")
	private WebElement sourceCheck;

	@FindBy(css = "mat-checkbox#checkbox-translation-suggestions input[type='checkbox']")
	private WebElement translationCheckBox;
	
	@FindBy(css = "mat-checkbox#checkbox-biblical-terms input[type='checkbox']")
	private WebElement btCheckBox;
	
	@FindBy(css = "mat-checkbox#checkbox-community-checking input[type='checkbox']")
	private WebElement ccCheckBox;

//	@FindBy(xpath="")
//	private WebElement projectName;
	
	@FindBy(xpath="//mat-drawer[@id='menu-drawer']//a[contains(@href, '/settings')]")
	private WebElement settingsPage;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver clickSettingsButton() throws InterruptedException {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(Duration.ofSeconds(3));
//
//		WebElement settingsLink = wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//mat-drawer[@id='menu-drawer']//a[contains(@href, '/settings')]")));
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(settingsPage, 30);

		settingsPage.click();
		return driver;
	}

	public WebDriver clickDeleteButton() {

		String projectName = "Projet de Robotica";

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> deleteProjectBtn.isEnabled()); // Wait until the button is enabled
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(deleteProjectBtn, 30);
		
		deleteProjectBtn.click();

		projectNameBox.sendKeys(projectName);
		confirmDeleteProjectBtn.click();

		return driver;
	}

	public void clickOnTheSourceProjectField() {
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(sourceProjectField, 30);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> sourceProjectField.isEnabled());
	}

	public void selectSourceProject(String source) {
		sourceProjectField.clear();
		sourceProjectField.sendKeys(source);
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_displayed(projectsListDialog, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> projectsListDialog.isDisplayed());
		
		WebElement sourceElement = driver
				.findElement(By.xpath("//mat-optgroup/child::mat-option/span[contains(text(),'" + source + "')]"));
		sourceElement.click();
	}

	public void verifySourceAdded() {
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_displayed(sourceCheck, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> sourceCheck.isDisplayed());
	}

	public void enableOrDisableTranslationSuggestion(String status) {
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(translationCheckBox, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> translationCheckBox.isEnabled());
		
		if (status.equalsIgnoreCase("enable")) {
			if (translationCheckBox.isSelected()) {
				return;
			} else {
				translationCheckBox.click();
			}
		} else {
			if (translationCheckBox.isSelected()) {
				translationCheckBox.click();
			} else {
				return;
			}
		}
	}
	
	public void enableOrDisableBiblicalTerms(String status) {
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(btCheckBox, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> btCheckBox.isEnabled());
		
		if (status.equalsIgnoreCase("enable")) {
			if (btCheckBox.isSelected()) {
				return;
			} else {
				btCheckBox.click();
			}
		} else {
			if (btCheckBox.isSelected()) {
				btCheckBox.click();
			} else {
				return;
			}
		}
	}
	
	public void enableOrDisableCommunityChecking(String status) {
		
		reuseobj=new ReusableMethods(driver);
		reuseobj.explicit_wait_ele_enabled(ccCheckBox, 30);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
//		wait.until(driver -> ccCheckBox.isEnabled());
		
		if (status.equalsIgnoreCase("enable")) {
			if (ccCheckBox.isSelected()) {
				return;
			} else {
				ccCheckBox.click();
			}
		} else {
			if (ccCheckBox.isSelected()) {
				ccCheckBox.click();
			} else {
				return;
			}
		}
	}
}
