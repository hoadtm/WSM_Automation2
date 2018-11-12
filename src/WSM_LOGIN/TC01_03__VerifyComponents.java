package WSM_LOGIN;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Common;

public class TC01_03__VerifyComponents extends Common {

//	Verify that the login screen contains elements
	@Test(priority = 1)
	public void Login_001() {

		String expectTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectTitle, actualTitle);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		
		actualResult = driver.findElement(By.id("user_email")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
		
		actualResult = driver.findElement(By.id("user_password")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
		
		actualResult = driver.findElement(By.name("button")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
		
		actualResult = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[4]/a")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
		
		actualResult = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[3]/label")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
		
		actualResult = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/a")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);

	}


//	Verify that “Remember login” checkbox is unselected by default
	@Test(priority = 2)
	public void Login_002() {

		actualResult = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[3]/label/span")).isSelected();
		Assert.assertEquals(actualResult, expectResultDisplay);
	}

//	Verify that the password is in encrypted form when entered
	@Test(priority = 3)
	public void Login_003() {

		WebElement password = driver.findElement(By.name("user[password]"));
		String actualResult = password.getAttribute("type");
		String expectedPasswordType = "password";
		assertEquals(actualResult, expectedPasswordType);

	}

}
