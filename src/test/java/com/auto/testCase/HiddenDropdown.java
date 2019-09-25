package com.auto.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HiddenDropdown {
	@Test
	void Hovertodropdown() throws InterruptedException{
		 System.setProperty("webdriver.chrome.driver","C:\\Java Libraries\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("C:\\Personal\\Learning\\Autoapp\\Autoapp-Framework\\HTML Proj\\index.html");
		  Actions action = new Actions(driver);
		  WebElement dropdownLocation = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		  action.moveToElement(dropdownLocation).perform();
		  Thread.sleep(5000);

		  WebElement link3 = driver.findElement(By.xpath("//a[text()='Link 3']"));
		  action.moveToElement(link3).build().perform();
		  action.contextClick(link3).sendKeys(Keys.ARROW_DOWN).build().perform();
//		  action.sendKeys(Keys.ARROW_DOWN).perform();
		  Thread.sleep(10000);
	}
}
