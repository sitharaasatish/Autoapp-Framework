package com.auto.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.auto.config.Config;
import com.auto.util.Timeouts;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Logger log = Logger.getLogger(TestBase.class);

	public static WebDriver driver;
	static Properties configProperties;
	static String browser;
	
	public TestBase() {
		configProperties = Config.loadConfigProperties();
	}

	public static void init() {
		browser = configProperties.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Initialized "+browser+" Browser");
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Initialized "+browser+" Browser");
		}else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info("Initialized "+browser+" Browser");
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Initialized "+browser+" Browser");
		}
		driver.manage().window().maximize();
		log.info("Maximized the "+browser+" Window");
		driver.manage().deleteAllCookies();
		log.info("Deleted all Cookies in "+browser);
		driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.info("Initialized PageLoadTimeout to "+Timeouts.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Initialized ImplicitlyWait to "+Timeouts.IMPLICIT_WAIT);
		driver.get(configProperties.getProperty("url"));
		log.info("Opening the URL : "+configProperties.get("url"));
	}
}
