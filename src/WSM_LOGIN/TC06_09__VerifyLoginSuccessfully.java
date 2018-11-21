package WSM_LOGIN;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.*;

public class TC06_09__VerifyLoginSuccessfully extends Common {

	public String title;

	// Verify that users can login successfully with valid user Email and
	// password.
	@Test(priority = 4, dataProvider = "setLogin")
	public void LOGIN_006(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flash-message']")));
		successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), LOGIN_successMsg);
	}

	// Verify that User is redirected to appropriate page after successful
	// login.
	@Test(priority = 5)
	public void LOGIN_007() throws InterruptedException {
		title = driver.getTitle();
		assertEquals(title, YOUR_TIMESHEET_title);
		Thread.sleep(2000);
	}

	// Verify that clicking on browser back button after successful logout
	// should not take User to logged in mode.
	@Test(priority = 6)
	public void LOGIN_008() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
		title = driver.getTitle();
		assertEquals(title, YOUR_TIMESHEET_title);
	}

	// Verify that whether User is still logged in after series of actions such
	// as sign in, close browser and reopen the application.
	@Test(priority = 7)
	public void LOGIN_009() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);

		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.get("https://edev.framgia.vn/en");

		title = driver.getTitle();
		assertEquals(title, YOUR_TIMESHEET_title);
		Thread.sleep(2000);
	}
}
