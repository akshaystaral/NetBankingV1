package com.NetBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.NetBankingV1.pageObjects.BaseClass;
import com.NetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(Username);
		logger.info("Entered Username");
		lp.setPassword(Password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on Submit Button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		} else {
			captureScreen(driver, "TC_LoginTest_001");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}

	}
}
