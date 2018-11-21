package WSM_LOGOUT;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Common;

public class TC01_05__VerifyLogOutFunction extends Common {

	// Verify that user logs out successfully when click to Log out button
	@Test(priority = 1, dataProvider = "setLogin")
	public void LOGOUT_001(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement userPhoto = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='User avatar default']")));
		userPhoto.click();

		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
		Thread.sleep(2000);

		WebElement msg_LogOut = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flash-message']")));

		assertEquals(msg_LogOut.getText(), "You need to sign in or sign up before continuing.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Verify that system redirects to Login page when logged out successfully
	@Test(priority = 2, dataProvider = "setLogin")
	public void LOGOUT_002(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userPhoto = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='User avatar default']")));
		userPhoto.click();

		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();

		Thread.sleep(2000);
		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

	// Verify that user session is cleared when user logged out successfully
	@Test(priority = 3, dataProvider = "setLogin")
	public void LOGOUT_003(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userPhoto = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='User avatar default']")));
		userPhoto.click();

		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
		Thread.sleep(2000);

		driver.get("https://edev.framgia.vn/en/dashboard/user_settings/edit");
		Thread.sleep(2000);
		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

	// Verify that system redirects to Login page when clicking Log out button
	// at any page of WSM application
	@Test(priority = 4, dataProvider = "setLogin")
	public void LOGOUT_004(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userPhoto = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='User avatar default']")));
		 driver.get("https://edev.framgia.vn/en/dashboard/import_timesheets");
		Thread.sleep(5000);
	
		userPhoto = driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[6]/a/img"));
		userPhoto.click();

		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();

		Thread.sleep(2000);
		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

	// Verify that system does not redirect to any page when clicking on Back
	// button of browser after logged out successfully
	@Test(priority = 5, dataProvider = "setLogin")
	public void LOGOUT_005(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userPhoto = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img[@alt='User avatar default']")));
		userPhoto.click();

		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
		driver.navigate().back();

		Thread.sleep(2000);
		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

}
