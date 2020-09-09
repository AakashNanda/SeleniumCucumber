package com.fedex.test.shipping.ResuableJavaFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class SharedDriverManager {

	public SharedDriverManager() throws Exception {
		if (DriverGenerator.getDriver() == null) {
			if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
				if(Property.getProp("mode").equalsIgnoreCase("jenkins")) {
					String browserName = System.getProperty("propertyName");
					WebDriver driver = new DriverFactory().getInstance(browserName);
					DriverGenerator.addDriver(driver);
				} else {
					WebDriver driver = new DriverFactory().getInstance(Property.getProp("browser"));
					DriverGenerator.addDriver(driver);
				}
			}else{
				WebDriver driver = new DriverFactory().getBrowserName(Property.getProp("mobileBrowser"));
				DriverGenerator.addDriver(driver);
			}
		}
	}
}
