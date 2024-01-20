package org.Yosa.Appium_gsm;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.Yosa.Appium_gsm.pageObjects.utils.AppiumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import freemarker.template.SimpleDate;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest  {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public ExtentReports extent;
	public ExtentTest extentTest;


	@BeforeClass
	@SuppressWarnings("deprecation")
	public void CofigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//vijay//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();

		service.start();	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("VijayEmulator");

		//New Apk Yosa

		options.setApp("P://Eclipse_Project//Appium_GSM//Resource_Apk//app-release.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723") ,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
					ImmutableMap.of("left",100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		}while(canScrollMore);
	}

	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(), 

				"direction", "left",
				"percent", 0.75
				));
	}



	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);

		driver.quit();
		service.stop();
	}
}