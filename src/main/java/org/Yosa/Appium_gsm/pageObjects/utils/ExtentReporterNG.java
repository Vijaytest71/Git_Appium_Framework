package org.Yosa.Appium_gsm.pageObjects.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;

public class ExtentReporterNG {
	
	
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+ "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setTheme(Theme.DARK);
		//extent.setSystemInfo("UserName ", "root");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Vijay Badgujar");
		return extent;
	}


}
