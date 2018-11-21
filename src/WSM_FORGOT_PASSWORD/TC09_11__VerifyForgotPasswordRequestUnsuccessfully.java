package WSM_FORGOT_PASSWORD;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Common.Common;

public class TC09_11__VerifyForgotPasswordRequestUnsuccessfully extends Common {

	@Test(priority = 8)
	public void FOR_PASS_009() throws InterruptedException {

		 driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[6]/a")).click();
		 driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[6]/div/div[4]/a")).click();

//		driver.get("https://edev.framgia.vn/");
		 wait();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btn-forgot-password")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[2]/button")).click();
		Thread.sleep(2000);
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[1]/p"))
				.getText();
		assertEquals(actualMessage, fpEmailRequired);

	}

	@Test(priority = 9)
	public void FOR_PASS_010() throws InterruptedException {

		driver.navigate().refresh();
		waittt();

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btn-forgot-password")).click();
		Thread.sleep(1000);

		driver.findElement(
				By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email"))
				.sendKeys("abc@");

		driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[2]/button")).click();
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[1]/p"))
				.getText();
		assertEquals(actualMessage, fpWrongEmail);

	}

	@Test(priority = 10)
	public void FOR_PASS_011() throws InterruptedException {

		driver.navigate().refresh();
		waittt();

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btn-forgot-password")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email"))
				.sendKeys("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[2]/button")).click();
		Thread.sleep(1000);

		String actualMessage = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/div/p")).getText();
		assertEquals(actualMessage, fpEmailNotFound);

	}

}
