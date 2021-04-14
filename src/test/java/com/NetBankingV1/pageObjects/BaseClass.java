package com.NetBankingV1.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.NetBankingV1.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	String className;

	public static Logger logger;

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("InternetExplorer")) {
			System.setProperty("webdriver.msedgedriver.driver", readconfig.getIEPath());
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	
}
