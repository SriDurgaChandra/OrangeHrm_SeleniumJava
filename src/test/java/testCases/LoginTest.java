package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.TestBase;

//@Listeners(utilities.ExtentReportManager.class)
public class LoginTest extends TestBase {
	
	@Test (dataProvider= "LoginData", dataProviderClass=utilities.DataProviders.class, groups= {"regression", "sanity"})
	public void test_login(String username, String password, String result)  {
		try {
			logger.debug("application logs.........");
			logger.info("******** start login test *************");
			LoginPage lp = new LoginPage(driver);
			Thread.sleep(5000);
			lp.setUserName(username);
			lp.setPassword(password);
			logger.info("entered credentials");
			lp.clickLoginBtn();
			logger.info("clicked login button");
			Thread.sleep(5000);
			dataDrivenLoginTest(result);
			logger.info("validated login");
			logger.info("******** end login test *************");
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("login test failed"+e.getMessage());
			Assert.fail();
		}
	}
	
	private void dataDrivenLoginTest(String result) {
		DashboardPage dp = new DashboardPage(driver);
		if("valid".equalsIgnoreCase(result)) {
			boolean isHeaderDisplayed = dp.isHeaderNameDisplayed();
			if(isHeaderDisplayed) {
				Assert.assertTrue(true);
				dp.clickUserDropDown();
				dp.clickLogout();
			} else {
				Assert.assertTrue(false);
			}
		} else {
			boolean isHeaderDisplayed = dp.isHeaderNameDisplayed();
			if(!isHeaderDisplayed) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				dp.clickUserDropDown();
				dp.clickLogout();
			}
		}
	}

}
