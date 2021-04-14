package com.NetBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NetBankingV1.pageObjects.BaseClass;
import com.NetBankingV1.pageObjects.LoginPage;
import com.NetBankingV1.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void logingddt(String user, String password) throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username Provided");
		lp.setPassword(password);
		logger.info("Passsword Provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			captureScreen(driver, "TC_LoginDDT_002");
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			

		} else if (isAlertPresent() == false) {
			// Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			// Thread.sleep(3000);
			// driver.switchTo().alert().accept();// close logout alert
			// driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/NetBankingV1/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;

	}
}
