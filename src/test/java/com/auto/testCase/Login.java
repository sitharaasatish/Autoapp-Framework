package com.auto.testCase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.auto.config.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	@Test
	public void login() {
		Config conf = new Config(); 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//notifications - enabling/disabling notifications
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");

		options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Note: Chrome doesent support Eager in page load strategy
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"null");
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(conf.AppURL);
		
	}
}
