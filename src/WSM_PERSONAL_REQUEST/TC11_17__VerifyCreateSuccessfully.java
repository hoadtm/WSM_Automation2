package WSM_PERSONAL_REQUEST;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Common;

public class TC11_17__VerifyCreateSuccessfully extends Common {

	public WebElement menuPersonalRequet;
	public WebElement menuOvertime;
	public WebElement btnCreate;

	public WebElement txtProject;
	public WebElement txtFrom;
	public WebElement txtTo;
	public WebElement txtReason;

	public WebElement btnSave;
	public WebElement successMsg;

	public WebElement ckb;
	public WebElement drdOtherGroup;
	
	public boolean expect = true;
	public boolean actual;

	// Verify that users can login successfully with valid user Email and
	// password.
	@Test(priority = 1, dataProvider = "SetLogin")
	public void LOGIN(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flash-message']")));
		successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		System.out.println(successMsg.getText());
		assertEquals(successMsg.getText(), LOGIN_successMsg);
	}

	// Verify that users can create an OT request successfully without selecting
	// "Do you OT for other group?' checkbox
	@Test(priority = 2)
	public void PER_REQ_OT_011() throws InterruptedException {
		menuPersonalRequet = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/a/span"));
		menuPersonalRequet.click();
		Thread.sleep(1000);
		menuOvertime = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/ul/li[1]/a"));
		menuOvertime.click();
		Thread.sleep(1000);

		btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/a"));
		btnCreate.click();
		Thread.sleep(1000);

		txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));
		txtProject.sendKeys("Azui");
		Thread.sleep(1000);

		txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		txtTo.sendKeys("2018/11/11 08:15");
		Thread.sleep(1000);
		txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		txtFrom.sendKeys("2018/11/11 08:00");
		Thread.sleep(1000);

		txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
		txtReason.sendKeys("Verify ticket");
		Thread.sleep(1000);

		btnSave = driver.findElement(By.xpath("//*[@id='new_request_ot']/input[3]"));
		btnSave.click();

		WebElement successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), REQUEST_OVERTIME_successMsg);
	}

	// Verify that users can create an OT request successfully when selecting
	// "Do you OT for other group?' checkbox
	@Test(priority = 3)
	public void PER_REQ_OT_012() throws InterruptedException {
		btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/a"));
		btnCreate.click();
		Thread.sleep(2000);

		ckb = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[3]/label/span"));
		ckb.click();
		Thread.sleep(2000);
		drdOtherGroup = driver.findElement(By.xpath("//*[@id='s2id_request_ot_other_group_id']"));
		drdOtherGroup.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='s2id_autogen3_search']")).sendKeys("Software Development Division 3");
		driver.findElement(By.xpath("//*[@id='select2-results-3']")).click();

		txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));
		txtProject.sendKeys("Azui");
		Thread.sleep(1000);

		txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		txtTo.sendKeys("2018/11/11 08:30");
		Thread.sleep(1000);
		txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		txtFrom.sendKeys("2018/11/11 08:15");
		Thread.sleep(1000);

		txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
		txtReason.sendKeys("Verify ticket");
		Thread.sleep(1000);

		btnSave = driver.findElement(By.xpath("//*[@id='new_request_ot']/input[3]"));
		btnSave.click();

		successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), REQUEST_OVERTIME_successMsg);
	}

	// Verify that users can create an OT request successfully with time in
	// current month
	@Test(priority = 4)
	public void PER_REQ_OT_013() throws InterruptedException {
		btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/a"));
		btnCreate.click();
		Thread.sleep(1000);

		txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));
		txtProject.sendKeys("Azui");
		Thread.sleep(1000);

		txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		txtTo.sendKeys("2018/11/04 08:15");
		Thread.sleep(1000);
		txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		txtFrom.sendKeys("2018/11/04 08:00");
		Thread.sleep(1000);

		txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
		txtReason.sendKeys("Verify ticket");
		Thread.sleep(1000);

		btnSave = driver.findElement(By.xpath("//*[@id='new_request_ot']/input[3]"));
		btnSave.click();

		WebElement successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), REQUEST_OVERTIME_successMsg);

	}

	// Verify that users can create an OT request successfully with time in the
	// future
	@Test(priority = 5)
	public void PER_REQ_OT_014() throws InterruptedException {
		btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/a"));
		btnCreate.click();
		Thread.sleep(1000);

		txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));
		txtProject.sendKeys("Azui");
		Thread.sleep(1000);

		txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		txtTo.sendKeys("2018/11/18 08:15");
		Thread.sleep(1000);
		txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		txtFrom.sendKeys("2018/11/18 08:00");
		Thread.sleep(1000);

		txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
		txtReason.sendKeys("Verify ticket");
		Thread.sleep(1000);

		btnSave = driver.findElement(By.xpath("//*[@id='new_request_ot']/input[3]"));
		btnSave.click();

		WebElement successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), REQUEST_OVERTIME_successMsg);
	}

	// Verify that system redirects to "Request overtime" screen after creating
	// a new OT request successfully
	@Test(priority = 6)
	public void PER_REQ_OT_015() throws InterruptedException {
		String title = driver.getTitle();
		assertEquals(title, REQUEST_OVERTIME_title);
		Thread.sleep(2000);
	}

//	Verify that the latest OT request displays at the top of the OT list
//	and Verify that OT request data displays correct at the OT list 
	@Test(priority = 7)
	public void PER_REQ_OT_016_017() throws InterruptedException {
		WebElement dataEmployeeCode = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[1]"));
		assertEquals(dataEmployeeCode.getText(), "B120839");
		WebElement dataStaffName = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[2]"));
		assertEquals(dataStaffName.getText(), "Do Thi Minh Hoa");
		WebElement dataCreationDay = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[3]"));
		assertEquals(dataCreationDay.getText(), "11-12-2018");
		
		WebElement dataFrom = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[4]"));
		assertEquals(dataFrom.getText(), "08:00 11-11-2018");
		WebElement dataTo = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[5]"));
		assertEquals(dataTo.getText(), "08:15 11-11-2018");
		
		WebElement dataProject = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[6]"));
		assertEquals(dataProject.getText(), "Azui");

		WebElement dataReason = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[7]"));
		assertEquals(dataReason.getText(), "Verify ticket");
		WebElement dataStatus = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[8]"));
		assertEquals(dataStatus.getText(), "Pending");
		
		WebElement dataBeingHandledBy = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[9]"));
		assertEquals(dataBeingHandledBy.getText(), "Team 2(Luu Thi Hoai Thuong)");
		WebElement dataRequestHours = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[9]"));
		assertEquals(dataRequestHours.getText(), "0.25");
		
		WebElement actionShow = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[11]/button"));
		actual = actionShow.isDisplayed();
		assertEquals(actual, expect);
		
		WebElement actionEdit = driver.findElement(By.xpath("///*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[11]/a[1]"));
		actual = actionEdit.isDisplayed();
		assertEquals(actual, expect);
		
		WebElement actionDelete = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[11]/a[2]"));
		actual = actionDelete.isDisplayed();
		assertEquals(actual, expect);
	}
	
}