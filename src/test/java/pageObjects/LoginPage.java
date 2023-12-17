package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")
	WebElement logo;
	
	public void setUserName(String userNameVal) {
		userName.sendKeys(userNameVal);
	}
	
	public void setPassword(String passwordVal) {
		password.sendKeys(passwordVal);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

}
