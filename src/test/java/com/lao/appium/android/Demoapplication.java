package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;  
import org.json.simple.parser.JSONParser;



import java.io.FileReader;

public class Demoapplication {
	public static AndroidDriver driver;


	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		//INITILAIZATION

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability("appPackage", "com.eeki.dev");
		dc.setCapability("appActivity", "com.eekifoods.MainActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);

		//INTILAIZATION END

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(3000);

		//COMMON LOCATORS

		Base.performClickID(driver, Locators.L_PATH);
		Thread.sleep(2000);
		Base.performClickXpath(driver, Locators.CLICK_BTN);
		Thread.sleep(5000);
		Base.performClickXpath(driver, Locators.DOME_BTN);
		Thread.sleep(2000);
		Base.performClickXpath(driver, Locators.DROPDOWN);
		Thread.sleep(2000);
		Base.performClickXpath(driver, Locators.NANTA_A);
		Thread.sleep(2000);



		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Venkatraman\\eclipse-workspace\\Json_weather_report\\src\\test\\java\\com\\lao\\appium\\android\\input_data.json"));
			JSONObject jsonObject = (JSONObject) obj;

			// Get the array of input sets
			JSONArray inputSets = (JSONArray) jsonObject.get("inputSets");


			//LOOPING LOGIC
			for (int i = 1;  i<=inputSets.size(); i++)
			{ 
				JSONObject inputSet = (JSONObject) inputSets.get(i);
				Base.performClickXpath(driver, Locators.FORM);

				Thread.sleep(5000);

				//IF CONDITION FOR CLEAR INPUTS


				if (i>=2) {  

					WebElement signatureCanvas1 = driver.findElement(By.xpath(Locators.TEMPERATURE_C));
					Actions actions1 = new Actions(driver);

					// Set the xOffset and yOffset values
					int xOffset = 0;
					int yOffset = -50;

					// Perform drag-and-drop
					actions1.dragAndDropBy(signatureCanvas1, xOffset, yOffset).build().perform();

					WebElement element = driver.findElement(By.xpath(Locators.CLEAR_INPUTS));
					Actions actions = new Actions(driver);
					actions.moveToElement(element);
					actions.perform();
					element.click();

				}



				if(i==1){


					Base.performClickXpath(driver, Locators.POLYHOUSE);
					Thread.sleep(3000);

					Base.performClickXpath(driver, Locators.POLYHOUSE_A);	
					Thread.sleep(2000);
				}

				//IF CONDITION FOR B value selection

				if(i==4){

					Base.performClickXpath(driver, Locators.POLYHOUSE_A);
					Thread.sleep(2000);

					Base.performClickXpath(driver, Locators.POLYHOUSE_B);
					Thread.sleep(2000);

				}
				//SELECT DOME

				Base.performClickXpath(driver, Locators.SELECT_DOME);
				Thread.sleep(2000);

				if (i % 5 == 0) {

					Base.performClickXpath(driver, Locators.SELECT_DOME_1);
					Thread.sleep(2000);

				}

				else if (i % 4 == 0){
					Base.performClickXpath(driver, Locators.SELECT_DOME_2);
					Thread.sleep(2000);
				}

				else if (i % 3 == 0){
					Base.performClickXpath(driver, Locators.SELECT_DOME_3);
					Thread.sleep(2000);
				}

				else if (i % 2 == 0){

					Base.performClickXpath(driver, Locators.SELECT_DOME_4);
					Thread.sleep(2000);
				}

				else {
					Base.performClickXpath(driver, Locators.SELECT_DOME_5);
					Thread.sleep(2000);
				}

				//SELECT SECTION

				Base.performClickXpath(driver, Locators.SELECT_SECTION);
				Thread.sleep(2000);

				if (i % 4 == 0) {
					Base.performClickXpath(driver, Locators.SELECT_SECTION_A);
					Thread.sleep(3000);
				}
				else if (i % 3 == 0) {
					Base.performClickXpath(driver, Locators.SELECT_SECTION_B);
					Thread.sleep(5000);

				}
				else if (i % 2 == 0) {
					Base.performClickXpath(driver, Locators.SELECT_SECTION_C);
					Thread.sleep(3000);
				}
				else  {
					Base.performClickXpath(driver, Locators.SELECT_SECTION_D);
					Thread.sleep(3000);

				}

				//INPUT VALUES
				String temperatureValue = inputSet.get("temperatureValue").toString();
				String dryTemperatureValue = inputSet.get("dryTemperatureValue").toString();
				String wetTemperatureValue = inputSet.get("wetTemperatureValue").toString();
				String luxValue = inputSet.get("luxValue").toString();
				String parValue = inputSet.get("parValue").toString();


				Base.sendKeys(driver, Locators.TEMPERATURE_VALUE, temperatureValue);
				Base.sendKeys(driver, Locators.DRY_TEMPERATURE_VALUE, dryTemperatureValue);
				Base.sendKeys(driver, Locators.WET_TEMPERATURE_VALUE, wetTemperatureValue);
				Base.sendKeys(driver, Locators.LUX_VALUE, luxValue);
				Base.sendKeys(driver, Locators.PAR_VALUE, parValue);
				Base.performClickXpath(driver, Locators.SUBMIT);
				Thread.sleep(3000);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//SIGNATURE

		Base.performClickXpath(driver, Locators.SIGN_SUBMIT);
		Thread.sleep(2000);

		Base.performClickID(driver, Locators.SIGNATURE_ALLOW);
		Thread.sleep(2000);

		WebElement signatureCanvas = driver.findElement(By.xpath(Locators.SIGNATURE_VALUE));
		Actions actions = new Actions(driver);
		int xOffset = 200;
		int yOffset = 0;
		actions.dragAndDropBy(signatureCanvas, xOffset, yOffset).build().perform();

		Base.performClickXpath(driver, Locators.SIGNATURE_SUBMIT);
		Thread.sleep(4000);

		Base.performClickID(driver, Locators.RECORD);

		//BACK TO HOME PAGE

		Base.performClickXpath(driver, Locators.ADD_DOME_BACK);
		Base.performClickXpath(driver, Locators.CLIMATE_WISE_BACK);


		Base.performClickXpath(driver, Locators.DATABASE_ICON);

	}



}
