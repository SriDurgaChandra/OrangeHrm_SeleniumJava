package pageObjects;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BaseClass{
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement pageHeader;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//li[@class='oxd-userdropdown']")
	WebElement userDropDown;
	
	public boolean isHeaderNameDisplayed() {
		boolean isHeaderNameDisplayed;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			isHeaderNameDisplayed = wait.until(ExpectedConditions.visibilityOf(pageHeader)).isDisplayed();
		} catch (Exception e) {
			isHeaderNameDisplayed = false;
		}
		return isHeaderNameDisplayed;
	}
	
	public void clickLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(logout)).click();
	}
	
	public void clickUserDropDown() {
		userDropDown.click();
	}
}
