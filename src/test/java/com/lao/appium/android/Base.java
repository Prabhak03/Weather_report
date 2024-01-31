package com.lao.appium.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.appium.java_client.android.AndroidDriver;


public class Base {
	 
	//Locator for ID 
	
	public static void performClickID(AndroidDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}

	//Locator for xpath
	
	public static void performClickXpath(AndroidDriver driver, String id) {
		driver.findElement(By.xpath(id)).click();
	}
	
	//Locator for sendkeys
	
	public static void sendKeys(AndroidDriver driver, String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}


	
	//public static WebDriver performClickXpath1(AndroidDriver driver, String textValue) {
	//  String xpath = "//android.widget.Toast[@text=\"Wet temperature should be lower than dry temperature\"]";
	// driver.findElement(By.xpath(xpath)).click();
    //return driver;
	//}
	
	
}
