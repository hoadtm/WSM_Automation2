package WSM_FORGOT_PASSWORD;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Common;

public class TC01_04__VerifyForgotPasswordScreen extends Common{
	public WebElement btnLogin;
	public WebElement linkForgotPass;
	public String title;

	public boolean expect = true;
	public boolean actual;

	// Verify that User is redirected to "Forgot password" screen when clicking
	// on "Forgot Password" link
	@Test(priority = 1)
	public void FOR_PASS_001() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/a")));

		btnLogin = driver.findElement(By.xpath("/html/body/div[2]/div[3]/a"));
		btnLogin.click();
		Thread.sleep(2000);

		linkForgotPass = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/a"));
		linkForgotPass.click();
		Thread.sleep(2000);

		WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label"));
		System.out.println(title);
		assertEquals(title, "Forgot password");
		Thread.sleep(2000);

	}

	// Verify that the FORGOT PASSWORD screen contains elements
	@Test(priority = 2)
	public void FOR_PASS_002() throws InterruptedException {
		WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label"));
		actual = title.isDisplayed();
		assertEquals(actual, expect);

		WebElement txtEmail = driver.findElement(By.xpath("//*[@id='user_email']"));
		actual = txtEmail.isDisplayed();
		assertEquals(actual, expect);

		WebElement btnOK = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[2]/button"));
		actual = btnOK.isDisplayed();
		assertEquals(actual, expect);

		WebElement btnCancel = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[2]/a"));
		actual = btnCancel.isDisplayed();
		assertEquals(actual, expect);

		WebElement linkBackToLogin = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a"));
		actual = linkBackToLogin.isDisplayed();
		assertEquals(actual, expect);

	}

	// Verify that User is redirected to Login page when clicking on "Back to
	// login" link
	@Test(priority = 2)
	public void FOR_PASS_004() throws InterruptedException {

		WebElement linkBackToLogin = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a"));
		linkBackToLogin.click();
		Thread.sleep(2000);
		
		WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div[1]/label"));
		assertEquals(title, "LOGIN");
		Thread.sleep(2000);
	}

}
