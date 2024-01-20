package org.Yosa.Appium_gsm;

import java.net.MalformedURLException;

import org.Yosa.Appium_gsm.pageObjects.android.FormPage;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(org.Yosa.Appium_gsm.pageObjects.utils.Listeners.class)

public class Yosa_Apk_tc_1 extends BaseTest{

	

	@Test
	public void SignIn() throws MalformedURLException
	{
	
	
		FormPage formpage = new FormPage(driver);
		formpage.login("ABC@gmail.com", ""); // we can add password in second parameter

		String toastmessage =  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Enter Password or OTP.\"]")).getText();
		AssertJUnit.assertEquals(toastmessage, "Please enter name");

		
		// Extent Report -> https://advancedmd.udemy.com/course/mobile-automation-using-appiumselenium-3/learn/lecture/33022824#overview
		//formpage.setCountryselection("India");

		// Need to add confirmation popup

		/*	Used in Form page
	  // Sign in User

		driver.findElement(AppiumBy.accessibilityId("SignIn")).click(); 

		driver.findElement(By.xpath("//android.widget.EditText[@text='Email / Mobile']")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@text='Email / Mobile']")).sendKeys("Abcd");

		driver.findElement(By.xpath("//android.widget.EditText[@text='Password / OTP']")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@text='Password / OTP']")).sendKeys("Abcd");


		driver.findElement(By.xpath("//android.view.View[@content-desc='SignIn']")).click();
		 */

		/*
				// New User
				driver.findElement(AppiumBy.accessibilityId("New User")).click();

				driver.findElement(By.xpath("//android.widget.EditText[1]")).click();

				driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("ABCd");

				driver.findElement(By.xpath("//android.widget.EditText[2]")).click();

				driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("Ganesha");
		 */
	}


}
