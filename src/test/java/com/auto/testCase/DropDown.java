package com.auto.testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.auto.util.Dropdown;

public class DropDown {
  @Test
  public void dropdown() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Java Libraries\\Drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("file:///C:/Users/ssidappa/Desktop/dropdown.html");
	  WebElement dropdown = driver.findElement(By.id("singleselect"));
	  Dropdown.singleSelectDropDown(dropdown, 2);
	  Thread.sleep(5000);

	  Dropdown.singleSelectDropDown(dropdown, "ho");
	  	
	  Thread.sleep(5000);
	  Dropdown.singleSelectDropDownByVisibleText(dropdown, "Kia");
//	  WebElement x = ss.getFirstSelectedOption();
//	  System.out.println("Value which is selected : "+x.getText());
	  System.out.println("Single sected completed ");
//	  
//	  
//	  System.out.println("Multi sected Started ");
//	  WebElement msDropdown = driver.findElement(By.id("multiselect"));
//	  Select ms = new Select(msDropdown);
//	  ms.selectByIndex(4);
//	  Thread.sleep(5000);
//	  ms.selectByValue("Mahindra");
//	  Thread.sleep(1000);
//	  ms.selectByIndex(4);
//	  Thread.sleep(1000);
//	  ms.selectByVisibleText("Honda");
//	  Thread.sleep(1000);
////	  ms.deselectAll();
//	  
////	  Thread.sleep(5000);
//	  System.out.println("first selected option : "+ms.getFirstSelectedOption().getText());
//	  List<WebElement> selectedOptions = ms.getAllSelectedOptions();
//	  for(WebElement ob:selectedOptions) {
//		  System.out.println(ob.getText());
//	  }
//	  System.out.println("to get all lilsted options");
//	  List<WebElement> getalloptions = ms.getOptions();
//	  for (WebElement we : getalloptions) {
//		  System.out.println(we.getText());
//	  }
//	  
	 
	  
	  

	  
  }
  
}
