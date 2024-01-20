package org.Yosa.Appium_gsm.pageObjects.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public  abstract class AppiumUtils {

	AppiumDriver driver;

	/*public AppiumUtils(AppiumDriver driver)
	{
		this.driver = driver;
	}*/

	public void waitforElementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele,"text","cart"));
	}
	public String getScreenshotPath(String testCaseName , AppiumDriver driver) throws IOException
	{
		Calendar cal = Calendar.getInstance();
		java.util.Date dt = cal.getTime();
		String timestamp =  dt.toString().replace(":", "_");

		File source = 	driver.getScreenshotAs(OutputType.FILE);
		
		String destinationfile = System.getProperty("user.dir")+ "./Screenshots"+ "\\Screenshot_" + testCaseName + " " + timestamp +".png";
		System.out.println("Screenshot is captured:" + destinationfile);
		FileUtils.copyFile(source,new File(destinationfile));
		return destinationfile;
	}
}


