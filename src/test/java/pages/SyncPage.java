package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableMethods;

public class SyncPage {
	
	private WebDriver driver;
	
	public SyncPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Sync')]/ancestor::button")
	private WebElement syncBtn;
	
	@FindBy(css="app-sync-progress mat-progress-bar")
	private WebElement progressBar;
	
	
	public void syncBtnClick() {
		
		ReusableMethods reuse = new ReusableMethods(driver);
		reuse.explicit_wait_ele_visible(syncBtn, 30);
		syncBtn.click();
	}
	
	public void progressBarInvisible() {
		
		ReusableMethods reuse = new ReusableMethods(driver);
		reuse.explicit_wait_ele_invisble(progressBar, 50);
	}

}
