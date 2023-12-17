package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	protected static WebDriver driver;
	protected Logger logger;
	protected static ResourceBundle resourceBundle;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void setUp(String browser, String url) {
		logger = LogManager.getLogger(this.getClass());
		resourceBundle = ResourceBundle.getBundle("config");
		if("chrome".equals(browser)) {
			driver = new ChromeDriver();
		} else if("edge".equals(browser)) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static String captureScreenshot(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddmmss");
		String dateWithTimestamp = df.format(new Date());
		String dest = resourceBundle.getString("screenshotsPath")+ tname + "_" + dateWithTimestamp;
		File trgt = new File(dest);
		FileUtils.copyFile(src, trgt);
		return dest;
	}

}
