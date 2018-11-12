package Common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public abstract class Common extends CollectionMessage{

	public static WebDriver driver = null;
	public static boolean expectResult = true;
	public static boolean expectResultDisplay = false;
	public static boolean actualResult;
	

	@BeforeTest
	public void beforeTest() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.get("https://edev.framgia.vn/");
	}

	@AfterTest
	public void end() {
		driver.quit();
	}

	@DataProvider
	public static Object[][] setLogin() {

		return new Object[][] { { "framgia.qa@gmail.com", "123456" } };

	}

	public void testLogin(String email, String password) throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		WebElement txtEmail = driver.findElement(By.id("user_email"));
		txtEmail.sendKeys(email);

		WebElement txtPass = driver.findElement(By.id("user_password"));
		txtPass.sendKeys(password);

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[4]/button"));
		buttonLogin.click();

		waittt();
	}

	public void waittt() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
