package WSM_LOGIN;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.*;

public class TC10_13__VerifyLoginUnsuccessfully extends Common {
	public WebElement btnLogin;
	public WebElement buttonLogin;
	public WebElement txtEmail;
	public WebElement txtPass;

	public WebElement errorEmail;
	public WebElement errorPass;
	public WebElement errorGeneral;

	// Verify that User is not able to Login with blank Email or Password
	@Test(priority = 1)
	public void LOGIN_010() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/a")));

		btnLogin = driver.findElement(By.xpath("/html/body/div[2]/div[3]/a"));
		btnLogin.click();
		Thread.sleep(2000);
		buttonLogin = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[4]/button"));
		buttonLogin.click();
		Thread.sleep(2000);

		errorEmail = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[1]/p"));
		assertEquals(errorEmail.getText(), LOGIN_errorEmail);
		errorPass = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[2]/p"));
		assertEquals(errorPass.getText(), LOGIN_errorPass);
	}

	// Verify that User is not able to Login with invalid Email and invalid
	// Password
	@Test(priority = 2)
	public void LOGIN_011() throws InterruptedException {
		txtEmail = driver.findElement(By.id("user_email"));
		txtEmail.sendKeys("abc@framgia.com");

		txtPass = driver.findElement(By.id("user_password"));
		txtPass.sendKeys("Framgia123");

		buttonLogin.click();
		Thread.sleep(2000);

		errorGeneral = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/p"));
		assertEquals(errorGeneral.getText(), LOGIN_errorGeneral);
	}

	// Verify that User is not able to Login with Valid Email and invalid
	// Password
	@Test(priority = 3)
	public void LOGIN_012() throws InterruptedException {
		txtEmail = driver.findElement(By.id("user_email"));
		txtEmail.clear();
		txtEmail.sendKeys("do.thi.minh.hoa@framgia.com.edev");

		txtPass = driver.findElement(By.id("user_password"));
		txtPass.clear();
		txtPass.sendKeys("Framgia123");

		buttonLogin.click();
		Thread.sleep(1000);

		errorGeneral = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/p"));
		assertEquals(errorGeneral.getText(), LOGIN_errorGeneral);
	}

	// Verify that User is not able to Login with invalid Email and Valid
	// Password
	@Test(priority = 4)
	public void LOGIN_013() throws InterruptedException {
		txtEmail = driver.findElement(By.id("user_email"));
		txtEmail.clear();
		txtEmail.sendKeys("abc@framgia.com");

		txtPass = driver.findElement(By.id("user_password"));
		txtPass.clear();
		txtPass.sendKeys("123456");

		buttonLogin.click();
		Thread.sleep(1000);

		errorGeneral = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/p"));
		assertEquals(errorGeneral.getText(), LOGIN_errorGeneral);
	}

}
