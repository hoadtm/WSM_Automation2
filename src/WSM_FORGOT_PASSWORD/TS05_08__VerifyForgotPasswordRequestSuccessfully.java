package WSM_FORGOT_PASSWORD;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Common;

public class TS05_08__VerifyForgotPasswordRequestSuccessfully extends Common {

	@Test(priority = 1)
	public void FOR_PASS_005() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btn-forgot-password")).click();
		Thread.sleep(1000);

		driver.findElement(
				By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email"))
				.sendKeys("hoangk46b52@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[2]/button")).click();
		waittt();

		String actualMessage = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/div/p")).getText();
		assertEquals(actualMessage, forgotPassword);

	}

	@Test(priority = 2)
	public void FOR_PASS_006() throws InterruptedException {

		driver.navigate().refresh();
		waittt();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btn-forgot-password")).click();
		Thread.sleep(1000);

		driver.findElement(
				By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email"))
				.sendKeys("hoangk46b52@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"devise-forgot-password-form\"]/div[2]/button")).click();
		waittt();

		driver.get("https://mail.google.com");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("hoangk46b52@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("password")).sendKeys("hoangpro");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		Thread.sleep(6000);

		actualResult = driver.findElement(By.id(":35")).isDisplayed();
		assertEquals(actualResult, expectResult);
//		driver.findElement(By.id(":35")).click();

	}

	@Test(priority = 3)
	public void FOR_PASS_007() throws InterruptedException {
		driver.findElement(By.id(":35")).click();
		driver.findElement(By.linkText("CHANGE PASSWORD")).click();
		Thread.sleep(10000);

		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));

		String actualLabel = driver.findElement(By.xpath("/html/body/div/section/div[2]/label")).getText();
		assertEquals(actualLabel, changePasswordLabel);
	}

	@Test(priority = 4, dataProvider = "setLogin")
	public void FOR_PASS_008(String user, String pass) throws InterruptedException {

		driver.get("https://edev.framgia.vn/");
		waittt();
		super.testLogin(user, pass);
		waittt();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, titleWeb);

	}

}