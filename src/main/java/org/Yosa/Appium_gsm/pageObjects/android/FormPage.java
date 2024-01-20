package org.Yosa.Appium_gsm.pageObjects.android;

import org.Yosa.Appium_gsm.pageObjects.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;

public class FormPage extends AndroidActions {

	AndroidDriver driver;


	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath= "//android.widget.Button[@content-desc=\"SignIn\"]")
	private WebElement signinField;
	//	driver.findElement(AppiumBy.accessibilityId("SignIn")).click();

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email / Mobile']")
	private WebElement emailField;
	//driver.findElement(By.xpath("//android.widget.EditText[@text='Email / Mobile']")).click();

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password / OTP']")
	private WebElement enter_password;
	//driver.findElement(By.xpath("//android.widget.EditText[@text='Password / OTP']")).click();

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='SignIn']")
	private WebElement SignIn_button; 
	//driver.findElement(By.xpath("//android.view.View[@content-desc='SignIn']")).click();

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='SignIn']")
	private WebElement Countryname; 
	//driver.findElement(By.xpath("//android.view.View[@content-desc='SignIn']")).click();


	@AndroidFindBy(xpath = "abc")
	private WebElement femaleoption;

	@AndroidFindBy(xpath = "abc")
	private WebElement maleoption;
	// male female xpath

	public void login(String name, String password)
	{
		signinField.click();
		emailField.click();		
		emailField.sendKeys(name); // enter Email or phone 
		enter_password.click();
		enter_password.sendKeys(password); // enter password
		SignIn_button.click(); // click on SignIn button
	}


	public void Setgender(String gender)
	{
		if(gender.contains("Male"))
			maleoption.click();
		else
			femaleoption.click();
	}



	public void setCountryselection(String countryName)
	{
		Countryname.click();
		scrollToText(countryName);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ countryName+"\"));"));
	}



}
