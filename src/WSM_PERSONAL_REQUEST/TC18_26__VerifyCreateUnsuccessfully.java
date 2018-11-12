package WSM_PERSONAL_REQUEST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Common;

public class TC18_26__VerifyCreateUnsuccessfully extends Common {

	// Verify that User is not able to create new request without entering "Project"
	// info
	@Test(priority = 1, dataProvider = "setLogin")
	public void PER_REQ_OT_019(String email, String password) throws InterruptedException {
		super.testLogin(email, password);
		waittt();
		driver.findElement(By.xpath("//*[@id=\"sidebar-scroll\"]/div/ul/li[4]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/ul/li[4]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();

		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/10/28 20:32");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/10/28 22:33");
		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
		driver.findElement(By.name("commit")).click();

		actualResult = driver.findElement(By.id("request_ot_project_name-error")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
	}

	// Verify that User is not able to create new request without entering "From"
	// info
	@Test(priority = 2)
	public void PER_REQ_OT_020() throws InterruptedException {

		driver.navigate().refresh();

		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/10/28 22:33");
		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
		driver.findElement(By.name("commit")).click();

		actualResult = driver.findElement(By.id("request_ot_from_time-error")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
	}

	// Verify that User is not able to create new request without entering "To" info
	@Test(priority = 3)
	public void PER_REQ_OT_021() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/10/28 20:32");
		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
		driver.findElement(By.name("commit")).click();

		actualResult = driver.findElement(By.id("request_ot_end_time-error")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
	}

	// Verify that User is not able to create new request without entering "Reason"
	// info
	@Test(priority = 4)
	public void PER_REQ_OT_022() throws InterruptedException {
		driver.navigate().refresh();

		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/10/28 20:32");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/10/28 22:33");
		driver.findElement(By.name("commit")).click();

		actualResult = driver.findElement(By.id("request_ot_reason-error")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
	}

	// Verify that User is not able to create new request with time is duplicated
	// with another OT request
	@Test(priority = 5)
	public void PER_REQ_OT_023() throws InterruptedException {
		driver.navigate().refresh();
		// create first time
		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/10/28 22:30");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/10/28 20:30");
		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
		driver.findElement(By.name("commit")).click();

		waittt();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/a")).click();

		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/10/28 22:30");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/10/28 20:30");
		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
		driver.findElement(By.name("commit")).click();

		// error message element
		actualResult = driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/ul/li")).isDisplayed();
		Assert.assertEquals(actualResult, expectResult);
	}

	// Verify that User is not able to create new request with time is in working
	// time
//	@Test(priority = 6)
//	public void PER_REQ_OT_024(){
//		driver.navigate().refresh();
//
//		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azui");
//		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/11/02 22:30");
//		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/11/02 20:30");
//		driver.findElement(By.id("request_ot_reason")).sendKeys("Log and Verify ticket");
//		driver.findElement(By.name("commit")).click();
//		
//		actualResult = driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/ul/li")).isDisplayed();
//		Assert.assertEquals(actualResult, expectResult);
//	}

	// Verify that User is not taken to another screen if there are any error occurs
	@Test(priority = 7)
	public void PER_REQ_OT_025() {

		driver.navigate().refresh();

		driver.findElement(By.name("request_ot[project_name]")).sendKeys("!@#%");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/11/02 19:17");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/11/02 19:17");
		driver.findElement(By.id("request_ot_reason")).sendKeys(" ");
		driver.findElement(By.name("commit")).click();

		String expectTitle = "Set up Holidays | Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectTitle, actualTitle);

		actualResult = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[1]/h3"))
				.isDisplayed();
		Assert.assertEquals(actualResult, expectResult);

	}

	// Verify that OT request is not display in the OT list after creating a new
	// request failed
	@Test(priority = 8)
	public void PER_REQ_OT_026() {

		driver.findElement(By.xpath("//*[@id=\"sidebar-scroll\"]/div/ul/li[4]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/a")).click();

		driver.findElement(By.name("request_ot[project_name]")).sendKeys("Azuiii");
		driver.findElement(By.id("request_ot_end_time")).sendKeys("2018/11/02 19:17");
		driver.findElement(By.id("request_ot_from_time")).sendKeys("2018/11/02 19:17");
		driver.findElement(By.id("request_ot_reason")).sendKeys(" ");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar-scroll\"]/div/ul/li[4]/ul/li[1]/a")).click();

		expectResultDisplay = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr")).isDisplayed();
		Assert.assertEquals(expectResultDisplay, expectResult);

	}

}