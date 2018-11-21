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

	
	public WebElement lblStaffname = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[1]/div[1]/label"));
	public WebElement txtStaffname = driver.findElement(By.xpath("//*[@id='employee_name']"));

	public WebElement lblStaffcode = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[1]/div[2]/label"));
	public WebElement txtStaffcode = driver.findElement(By.xpath("//*[@id='employee_code']"));

	public WebElement lblBranch = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[2]/div[1]/div/label"));
	public WebElement txtBranch = driver.findElement(By.xpath("//*[@id='select2-chosen-1']"));

	public WebElement lblGroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[2]/div[2]/div/label"));
	public WebElement txtGroup = driver.findElement(By.xpath("//*[@id='select2-chosen-2']"));

	public WebElement ckbOTforOthergroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[3]/label"));
	public WebElement ckb = driver.findElement(By.id("choose_other_group"));
	public WebElement lblOtherGroup = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[4]/label"));
	public WebElement drdOtherGroup = driver.findElement(By.xpath("//*[@id='s2id_request_ot_other_group_id']"));

	public WebElement lblProject = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[5]/label"));
	public WebElement txtProject = driver.findElement(By.xpath("//*[@id='request_ot_project_name']"));

	public WebElement lblFrom = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[6]/div[1]/label"));
	public WebElement txtFrom = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));

	public WebElement lblTo = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[6]/div[2]/label"));
	public WebElement txtTo = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));

	public WebElement lblReason = driver.findElement(By.xpath("//*[@id='new_request_ot']/div[7]/label"));
	public WebElement txtReason = driver.findElement(By.xpath("//*[@id='request_ot_reason']"));
	
	
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
		driver.get("https://wsm.framgia.vn/en/dashboard/users/367/request_ots");
		Thread.sleep(2000);

		String title = driver.getTitle();
		assertEquals(title, LOGIN_title);
	}

	// Verify that "New request for overtime" screen displays when clicking on
	// "Create" btn.
	@Test(priority = 4, dataProvider = "SetLogin")
	public void PER_REQ_OT_003(String email, String pass) throws InterruptedException {
		super.testLogin(email, pass);
		Thread.sleep(2000);

		WebElement menuPersonalRequet = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/a/span"));
		menuPersonalRequet.click();
		Thread.sleep(2000);
		WebElement menuOvertime = driver.findElement(By.xpath("//*[@id='sidebar-scroll']/div/ul/li[4]/ul/li[1]/a"));
		menuOvertime.click();
		Thread.sleep(2000);

		WebElement btnCreate = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[1]/a"));
		btnCreate.click();
		Thread.sleep(2000);

		WebElement screenName = driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div/div/div/div[1]/h3"));
		System.out.println(screenName.getText());
		assertEquals(screenName.getText(), "New request for overtime");
	}

	// Verify that the "New request for overtime" screen contains elements.
	@Test(priority = 5)
	public void PER_REQ_OT_004() throws InterruptedException {
		actual = lblStaffname.isDisplayed();
		assertEquals(actual, expect);
		actual = txtStaffname.isDisplayed();
		assertEquals(actual, expect);

		actual = lblStaffcode.isDisplayed();
		assertEquals(actual, expect);
		actual = txtStaffcode.isDisplayed();
		assertEquals(actual, expect);

		actual = lblBranch.isDisplayed();
		assertEquals(actual, expect);
		actual = txtBranch.isDisplayed();
		assertEquals(actual, expect);

		actual = lblGroup.isDisplayed();
		assertEquals(actual, expect);
		actual = txtGroup.isDisplayed();
		assertEquals(actual, expect);

		actual = ckbOTforOthergroup.isDisplayed();
		assertEquals(actual, expect);

		actual = lblProject.isDisplayed();
		assertEquals(actual, expect);
		actual = txtProject.isDisplayed();
		assertEquals(actual, expect);

		actual = lblFrom.isDisplayed();
		assertEquals(actual, expect);
		actual = txtFrom.isDisplayed();
		assertEquals(actual, expect);

		actual = lblTo.isDisplayed();
		assertEquals(actual, expect);
		actual = txtTo.isDisplayed();
		assertEquals(actual, expect);

		actual = lblReason.isDisplayed();
		assertEquals(actual, expect);
		actual = txtReason.isDisplayed();
		assertEquals(actual, expect);
	}

	// Verify that "Do you OT for other group?" checkbox is unselected by
	// default.
	@Test(priority = 6)
	public void PER_REQ_OT_005() throws InterruptedException {
		int isCheck;
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
		actual = lblOtherGroup.isDisplayed();
		assertEquals(actual, expect);
		actual = drdOtherGroup.isDisplayed();
		assertEquals(actual, expect);

	}

}
