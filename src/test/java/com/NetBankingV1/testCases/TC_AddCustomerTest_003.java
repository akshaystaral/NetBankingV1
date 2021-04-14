package com.NetBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBankingV1.pageObjects.AddCustomerPage;
import com.NetBankingV1.pageObjects.BaseClass;
import com.NetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(Username);
		lp.setPassword(Password);
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addCust = new AddCustomerPage(driver);

		addCust.clickAddNewCustomer();
		logger.info("Entered in Add Customer Page:");

		addCust.custName("Akshay");
		addCust.custgender("male");
		addCust.custdob("10", "29", "1994");
		Thread.sleep(5000);
		addCust.custaddress("INDIA");
		addCust.custcity("MUM");
		addCust.custstate("MH");
		addCust.custpinno("400028");
		addCust.custtelephoneno("9112458974");

		String email = randomestring() + "@gmail.com";
		addCust.custemailid(email);
		addCust.custpassword("abcdef");
		addCust.custsubmit();

		Thread.sleep(3000);
		logger.info("Validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}
}
