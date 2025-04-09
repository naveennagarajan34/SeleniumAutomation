package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.NavigationMenu;
import pages.SyncPage;
import utilities.WebDriverSetup;

public class SyncPageStepDefinitions {

	WebDriver driver;
	
	SyncPage sync;

	public SyncPageStepDefinitions() {
        this.driver = WebDriverSetup.getDriver();
    }

	@And("click on the sync page")
	public void click_on_the_sync_page() {
		
		NavigationMenu nav = new NavigationMenu(driver);
		nav.clickToNavigateTo_Sync();

	}

	@Then("click on the sync with paratext button")
	public void click_on_the_sycn_with_paratext_button() {
		
		sync = new SyncPage(driver);
		sync.syncBtnClick();

	}

	@Then("verify that the project synced sucessfully")
	public void verify_that_the_project_synced_sucessfully() {

		sync = new SyncPage(driver);
		sync.progressBarInvisible();
	}

}
