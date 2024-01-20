package org.Yosa.Appium_gsm.pageObjects.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener{


	ExtentReports extent =  ExtentReporterNG.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;

	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver),
					result.getMethod().getMethodName());
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext result)
	{
		extent.flush();
	}
}

