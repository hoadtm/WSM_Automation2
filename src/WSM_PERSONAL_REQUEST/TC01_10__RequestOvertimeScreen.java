package WSM_PERSONAL_REQUEST;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Common;

public class TC01_10__RequestOvertimeScreen extends Common{
	
	
	public boolean expect = true;
	public boolean actual;

	// Verify that users can login successfully with valid user Email and
	// password.
	@Test(priority = 1, dataProvider = "setLogin")
	public void LOGIN(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flash-message']")));
		successMsg = driver.findElement(By.xpath("//*[@id='flash-message']"));
		assertEquals(successMsg.getText(), LOGIN_successMsg);
		Thread.sleep(2000);
	}

	// Verify that "Request overtime" screen displays when clicking on
	// "Overtime" link.
	@Test(priority = 2)
	public void PER_REQ_OT_001() throws InterruptedException {
		WebElement menuPersonalRequet = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/a/span"));
		menuPersonalRequet.click();
		WebElement menuOvertime = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/ul/li[1]/a"));
		menuOvertime.click();

		String title = driver.getTitle();
		assertEquals(title, REQUEST_OVERTIME_title);
		Thread.sleep(2000);

		driver.quit();
	}

	// Verify that "Login" screen displays when accessing to "Overime" screen
	// without Login session.
	@Test(priority = 3)
	public void PER_REQ_OT_002() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://edev.framgia.vn/en/dashboard/users/367/request_ots");
		Thread.sleep(2000);

		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

	// Verify that "New request for overtime" screen displays when clicking on
	// "Create" btn.
	@Test(priority = 4, dataProvider = "setLogin")
	public void PER_REQ_OT_003(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		Thread.sleep(2000);

		WebElement menuPersonalRequet = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/a/span"));
		menuPersonalRequet.click();
		Thread.sleep(2000);
		WebElement menuOvertime = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/ul/li[1]/a"));
		menuOvertime.click();
		Thread.sleep(2000);

		WebElement btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/a")); 
		btnCreate.click();
		Thread.sleep(2000);

		WebElement screenName = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[1]/h3"));
		System.out.println(screenName.getText());
		assertEquals(screenName.getText(), "New request for overtime"); 
	}

	// Verify that the "New request for overtime" screen contains elements.
	@Test(priority = 5)
	public void PER_REQ_OT_004() throws InterruptedException {
		WebElement lblStaffname = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[1]/div[1]/label")); 
		actual = lblStaffname.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtStaffname = driver.findElement(By.xpath("//*[@id='employee_name']"));
		actual = txtStaffname.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblStaffcode = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[1]/div[2]/label"));
		actual = lblStaffcode.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtStaffcode = driver.findElement(By.xpath("//*[@id='employee_code']"));
		actual = txtStaffcode.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblBranch = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[2]/div[1]/div/label"));
		actual = lblBranch.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtBranch = driver.findElement(By.xpath("//*[@id='select2-chosen-1']"));
		actual = txtBranch.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblGroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[2]/div[2]/div/label"));
		actual = lblGroup.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtGroup = driver.findElement(By.xpath("//*[@id='select2-chosen-2']"));
		actual = txtGroup.isDisplayed();
		assertEquals(actual, expect);

		WebElement ckbOTforOthergroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[3]/label"));
		actual = ckbOTforOthergroup.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblProject = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[5]/label"));
		actual = lblProject.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));
		actual = txtProject.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblFrom = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[6]/div[1]/label"));
		actual = lblFrom.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		actual = txtFrom.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblTo = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[6]/div[2]/label"));
		actual = lblTo.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		actual = txtTo.isDisplayed();
		assertEquals(actual, expect);

		WebElement lblReason = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[7]/label"));
		actual = lblReason.isDisplayed();
		assertEquals(actual, expect);
		WebElement txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
		actual = txtReason.isDisplayed();
		assertEquals(actual, expect);
	}

	// Verify that "Do you OT for other group?" checkbox is unselected by
	// default.
	@Test(priority = 6)
	public void PER_REQ_OT_005() throws InterruptedException {
		int isCheck;
		WebElement ckb = driver.findElement(By.id("choose_other_group"));
		if (ckb.isSelected()) {
			isCheck = 1;
		} else {
			isCheck = 0;
		}
		assertEquals(isCheck, 0);
	}

	// Verify that "Staff name" data is correct and uneditable.
	@Test(priority = 7)
	public void PER_REQ_OT_006() throws InterruptedException {
		WebElement txtStaffname = driver.findElement(By.xpath("//*[@id='employee_name']"));
		System.out.println(txtStaffname.getAttribute("value"));
		assertEquals(txtStaffname.getAttribute("value"), "Do Thi Minh Hoa");
		int isEnable;
		if (txtStaffname.isEnabled()) {
			isEnable = 1;
		} else {
			isEnable = 0;
		}
		assertEquals(isEnable, 0);
	}

	// Verify that "Staff code" data is correct and uneditable.
	@Test(priority = 8)
	public void PER_REQ_OT_007() throws InterruptedException {
		WebElement txtStaffcode = driver.findElement(By.xpath("//*[@id='employee_code']"));
		System.out.println(txtStaffcode.getAttribute("value"));
		assertEquals(txtStaffcode.getAttribute("value"), "B120839");
		int isEnable;
		if (txtStaffcode.isEnabled()) {
			isEnable = 1;
		} else {
			isEnable = 0;
		}
		assertEquals(isEnable, 0);
	}

	// Verify that "Branch" data is correct and uneditable.
	@Test(priority = 9)
	public void PER_REQ_OT_008() throws InterruptedException {
		WebElement txtBranch = driver.findElement(By.xpath("//*[@id='select2-chosen-1']"));
		System.out.println(txtBranch.getText());
		assertEquals(txtBranch.getText(), "Da Nang Office");
	}

	// Verify that "Group" dropdown list displays when checking on "Do you OT
	// for other group” checkbox.
	@Test(priority = 10)
	public void PER_REQ_OT_009() throws InterruptedException {
		WebElement OtherGroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[4]"));
		int isDisplay;
		if (OtherGroup.isDisplayed()) {
			isDisplay = 1;
		} else {
			isDisplay = 0;
		}
		assertEquals(isDisplay, 0);

		WebElement ckb = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[3]/label/span"));
		ckb.click();
		Thread.sleep(2000);

		if (OtherGroup.isDisplayed()) {
			isDisplay = 1;
		} else {
			isDisplay = 0;
		}
		assertEquals(isDisplay, 1);
	}

	// Verify that "Group" dropdown list displays with correct data when
	// clicking on "Group" dropdown list
	@Test(priority = 11)
	public void PER_REQ_OT_0010() throws InterruptedException {
		WebElement lblOtherGroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[4]/label"));
		actual = lblOtherGroup.isDisplayed();
		assertEquals(actual, expect);
		WebElement drdOtherGroup = driver.findElement(By.xpath("//*[@id='s2id_request_ot_other_group_id']"));
		actual = drdOtherGroup.isDisplayed();
		assertEquals(actual, expect);

	}

}
