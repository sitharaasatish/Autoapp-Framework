package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutoApp_Login  {
	
	//Properties file
			

		
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Java Libraries\\Selenium\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(options);
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Sithara-Parctice\\src\\main\\resources\\configTest.properties");
		p.load(fis);		
			


		// Valid Title
		driver.get(p.getProperty("url"));
		String title = driver.getTitle();
		if (title.contains("Citron")) {

			System.out.println("Valid Title " + title);
		} else {

			driver.quit();
		}

		// Login
		try {
			driver.findElement(By.id("username")).sendKeys(p.getProperty("username"));
			driver.findElement(By.id("password")).sendKeys("sithara1");
			driver.findElement(By.xpath("//div/button[text()='Sign in']")).click();
			System.out.println("Login Successful");
		} catch (Exception e) {
			driver.quit();
		}

		// Hamburger Navigation and Listing options
		driver.findElement(By.xpath("//div[@class='row app-navigator']")).click();
		List<WebElement> hamburgerList = driver.findElements(By.xpath("//div[@class='app-list row']"));
		for (int i = 0; i < hamburgerList.size(); i++) {
			System.out.println("Hamburger List Options " + hamburgerList.get(i).getText());
		}

		// Mouse Action - Moving to Sales options

		try {
			Actions action = new Actions(driver);
			WebElement sales = driver.findElement(By.xpath("//div[@id='SALES_modules_dropdownMenu']"));
			action.moveToElement(sales).click().build().perform();
			System.out.println("Mouse hoverd to Sales");
		}

		catch (Exception e) {
			System.out.println("Unable to perform mouse action");
			driver.quit();
		}

		// Selecting Sales and navigating to Products

		List<WebElement> subSaleOptions = driver.findElements(By.xpath("//*[contains(@class,'module-qtip')]"));
		for (WebElement optionsName : subSaleOptions) {
			System.out.println("Sub Sale Options " + optionsName.getText());
		}

		// Selecting Product option
		try {
			driver.findElement(By.xpath("//ul[@class='module-qtip' and @data-hasqtip='2']")).click();
			System.out.println("Navigated to Product option");
		} catch (Exception e) {
			driver.quit();
		}

		// Expanding Product Slider
		Thread.sleep(10000);

		if (driver.findElement(By.xpath("//div[@id='sidebar-essentials']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@id='createFilter']")).click();
		} else {
			driver.findElement(By.xpath("//div[@title='Left Panel Show/Hide']")).click();
			Thread.sleep(10000);
			System.out.println("Panel Expanded");
			driver.findElement(By.xpath("//button[@id='createFilter']")).click();
		}
		Thread.sleep(10000);
		System.out.println("Create Filter Form opened");

//		if(driver.findElement(By.xpath("//div/span[@class='essentials-toggle-marker fa fa-chevron-right cursorPointer']")).isDisplayed())
//		{
//			driver.findElement(By.xpath("//div/span[@class='essentials-toggle-marker fa fa-chevron-right cursorPointer']")).click();
//			Thread.sleep(10000);
//				driver.findElement(By.xpath("//button[@id='createFilter']")).click();
//			}
//		
//		else if(driver.findElement(By.xpath("//div/span[@class='essentials-toggle-marker fa cursorPointer fa-chevron-left']")).isDisplayed())
//		{
//			driver.findElement(By.xpath("//button[@id='createFilter']")).click();
//		}

		// Drag and Drop elements

		try {
			WebElement firstElement = driver.findElement(
					By.xpath("//li[@class='select2-search-choice ui-sortable-handle']/div[text()='Product Number']"));
			WebElement secondElement = driver.findElement(
					By.xpath("//li[@class='select2-search-choice ui-sortable-handle']/div[text()='Qty. in Stock']"));
			Actions move = new Actions(driver);
			move.dragAndDrop(firstElement, secondElement).build().perform();
		} catch (Exception e) {
			driver.quit();
		}

		// Add condition
		try {
			driver.findElement(By.xpath("//div/div[1]/div[2]/div[3]/button")).click();
			System.out.println("Added Condition");
			// Select Dropdown
			driver.findElement(By.xpath("//span[text()='Select Field']")).click();
			List<WebElement> selectionOption = driver.findElements(By.xpath("//*[contains(@id,'select2-drop')]/ul"));
			for (WebElement printOptions : selectionOption) {
				System.out.println("Selection Dropdown Options " + printOptions.getText());
			}
			Thread.sleep(5000);
			WebElement value = driver.findElement(By.xpath("//*[contains(@id,'select2-drop')]/div/input"));
			value.click();
			value.sendKeys("Product Name");
			value.sendKeys(Keys.ENTER);
			System.out.println("Enter required option");
		} catch (Exception e) {
			driver.quit();
		}

//Further Filtering options
		try {
			driver.findElement(By.xpath("//div/div[2]/div/a/span[2]")).click();
			List<WebElement> filteringOptions = driver.findElements(By.xpath("//*[contains(@id,'select2-drop')]/ul"));
			for (WebElement allFilters : filteringOptions) {
				System.out.println("All Filtering Options " + allFilters.getText());
			}
			WebElement enterFilter = driver.findElement(By.xpath("//*[contains(@id,'select2-drop')]/div/input"));
			enterFilter.click();
			enterFilter.sendKeys("starts with");
			enterFilter.sendKeys(Keys.ENTER);
			System.out.println("Entered Filter Options");
		} catch (Exception e) {
			driver.quit();
		}

		// Enter Text Field
		WebElement textbox = driver.findElement(
				By.xpath("//div/div[2]/div/div/div[3]/input[@class='inputElement row-fluid ignore-validation']"));
		if (textbox.isDisplayed()) {
			textbox.click();
			textbox.sendKeys("Sithara");
			textbox.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Text Box not found");
		}

		// Move To List Name TextBox
		WebElement listName = driver.findElement(By.xpath("//div[@class='row']/div/input"));
		listName.sendKeys("Sithara A Satish");
		System.out.println("Entered List Name");
		Thread.sleep(5000);

		// Checkbox list
		List<WebElement> allCheckbox = driver
				.findElements(By.xpath("//label[contains(@class,'checkbox')]/ancestor::div[contains(@class,'col')]"));
		for (WebElement checkboxes : allCheckbox) {
			System.out.println("All Checkbox Options " + checkboxes.getText());
		}

		// Checkbox Check
		WebElement checkbox1 = driver.findElement(By.xpath("//label[1][contains(@class,'checkbox')]/input"));
		checkbox1.click();
		if (checkbox1.isSelected()) {
			System.out.println("Set as Default Checkbox selected");
		} else {
			checkbox1.click();
			System.out.println("Set as Default Checkbox is now selected");
		}

		// ListName Enter Action and Save using Keyboard
		listName.click();
		listName.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		// Created My-List options
		List<WebElement> myList = driver.findElements(By.xpath("//div[@id='myList']/ul"));
		for(WebElement allmylist:myList)
		{
			System.out.println("All My list " +allmylist.getText());
		}
		WebElement mylistdisplay = driver.findElement(By.xpath("//div[@id='myList']/ul"));
		if(mylistdisplay.isDisplayed()) {
		driver.findElement(By.xpath("//div[@id='myList']/ul/li[1]/div[1]/span[1]")).click();
		}
		Thread.sleep(5000);
		List<WebElement> popOverContents = driver.findElements(By.xpath("//div[@class='popover-content']/ul"));
		for (WebElement contents : popOverContents) {
			System.out.println("All popover Options " + contents.getText());
		}

		// Delete My-List
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='popover-content']/ul/li[2]")).click();
		System.out.println("Alert Displayed");

		// Alert window
		WebElement alertMessage = driver.findElement(By.xpath("//div[@class='modal-content']/div[1]/div"));
		System.out.println(alertMessage.getText());
		driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/button[2]")).click();
		Thread.sleep(10000);
		driver.quit();
		
//		//Add Product form
//		driver.findElement(By.xpath("//div/div/ul/li[1]/button[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//tr[2]/td[4]/div/span[1][@class='input-group-addon']")).click();
//		List<WebElement> date = driver.findElements(By.xpath("//div/div[1][@class='datepicker-days']/table/tbody"));
//		for(WebElement chooseDate:date)
//		{
//			if(chooseDate.getText().contentEquals("today active day"))
//				chooseDate.click();
//		}
		
	}

}
