package com.fedex.test.shipping.ResuableJavaFactory;

import com.experitest.selenium.MobileWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@SuppressWarnings( "deprecation" )
public class DriverFactory extends Property{
	private WebDriver driver = null;


	@SuppressWarnings("deprecation")
	public WebDriver getInstance(String BrowserName) throws Exception {
		if (BrowserName.equalsIgnoreCase("IE")
				|| BrowserName.equalsIgnoreCase("InternetExplorer")) {

			//WebDriverManager.iedriver().proxy("172.26.30.153:8080").setup();
		//	WebDriverManager.iedriver().proxy("internet.proxy.fedex.com:3128").setup();
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			capabilities.setCapability(InternetExplorerDriver.SILENT, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			setTimeouts();
		} else if (BrowserName.equalsIgnoreCase("Chrome")
				|| BrowserName.equalsIgnoreCase("GoogleChrome")) {

//			WebDriverManager.chromedriver().proxy("172.26.30.153:8080").setup();
			WebDriverManager.chromedriver().proxy("internet.proxy.fedex.com:3128").setup();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized","--headless", "--disable-extensions","--incognito"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--test-type");
			options.addArguments("--disable-gpu");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			setTimeouts();
		} else if(BrowserName.equalsIgnoreCase("FireFox")||BrowserName.equalsIgnoreCase
		  ("MozillaFirefox")) {

			//WebDriverManager.firefoxdriver().proxy("172.26.30.153:8080").setup();
			WebDriverManager.firefoxdriver().proxy("internet.proxy.fedex.com:3128").setup();
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			FirefoxOptions options=new FirefoxOptions(capabilities);
			driver=new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			setTimeouts();

		} else if (BrowserName.equalsIgnoreCase("Remote")) {

			String remWinIP = getProp("remoteWinIP");
			String remWinPort = getProp("remoteWinPort");

			if (BrowserName.toLowerCase().equalsIgnoreCase("firefox")) {
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(Platform.WIN10);
				capability.setCapability("marionette", true);
				driver = new RemoteWebDriver(
						new URL("http://" + remWinIP + ":" + remWinPort + "/wd/hub"), capability);
			} else if (BrowserName.toLowerCase().equalsIgnoreCase("chrome")) {
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(
						new URL("http://" + remWinIP + ":" + remWinPort + "/wd/hub"), capability);
			} else if (BrowserName.toLowerCase().equalsIgnoreCase("ie")) {
				DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(
						new URL("http://" + remWinIP + ":" + remWinPort + "/wd/hub"), capability);
			} else if (BrowserName.toLowerCase().equalsIgnoreCase("edge")) {
				DesiredCapabilities capability = DesiredCapabilities.edge();
				capability.setBrowserName("edge");
				capability.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(
						new URL("http://" + remWinIP + ":" + remWinPort + "/wd/hub"), capability);
			}
			setTimeouts();
		} else
			throw new Exception("Kindly mention the valid Browser Name");
		return driver;
	}


	public MobileWebDriver getBrowserName(String BrowserName) throws IOException {

		String host = "localhost";
		int port = 8889;
		MobileWebDriver driver = null;

		driver = new MobileWebDriver(host, port);
		driver.setDevice(getProp("mobileDevice"));
		if(BrowserName.equalsIgnoreCase("Android") || BrowserName.equalsIgnoreCase("android")){
			String mobileBrowser = "chrome";
			driver.application(mobileBrowser + ":" + getProp(getProp("level"))).launch( true, true);
		}else{
			String mobileBrowser = "safari";
			driver.application(mobileBrowser + ":" + getProp(getProp("level"))).launch( true, true);
		}
		((MobileWebDriver) driver).useWebIdentification();
		driver.client.setSpeed("fast");

		return driver;
	}

	private void setTimeouts() {
		driver.manage().timeouts()
				.implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.setScriptTimeout(scriptTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
	}
}