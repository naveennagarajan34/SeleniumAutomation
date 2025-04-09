package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableMethods;

public class EditAndReviewPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//mat-select[@panelclass='book-select-menu']")
	private WebElement bookDropdown;
	
	@FindBy(xpath="//mat-select[@panelclass='chapter-select-menu']")
	private WebElement chapterDropdown;
	
	public EditAndReviewPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickBook(String bookName, String chapterNo, String verseNo) {
		
	bookDropdown.click();
	
	WebElement book = driver.findElement(By.xpath("//span[text()='"+bookName+"']/parent::mat-option"));
	
	ReusableMethods reuse = new ReusableMethods(driver);
	reuse.explicit_wait_ele_visible(book, 30);
	
	book.click();
	
	chapterDropdown.click();
	
	WebElement chapter = driver.findElement(By.xpath("//span[text()='"+chapterNo+"']/parent::mat-option"));
	
	chapter.click();
	
	WebElement verse = driver.findElement(By.xpath("//usx-segment[@data-segment='verse_2_"+verseNo+"']"));
	
	verse.click();
	
	}

}
