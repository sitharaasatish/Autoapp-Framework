package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Calender {

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
			action.moveToElement(sales).build().perform();
			System.out.println("Mouse hoverd to Sales");
		}

		catch (Exception e) {
			System.out.println("Unable to perform mouse action");
			driver.quit();
		}

		//Products Click - Mouse Action
		Thread.sleep(10000);
		Actions action1 = new Actions(driver);
		WebElement products = driver.findElement(By.xpath("//li[3]/a/span[text()=' Products']"));
		action1.moveToElement(products).click().build().perform();
		System.out.println("Products options clicked");
		//driver.quit();
		
		//Add Product form
				driver.findElement(By.xpath("//div/div/ul/li[1]/button[1]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//tr[2]/td[4]/div/span[1][@class='input-group-addon']")).click();
				List<WebElement> date = driver.findElements(By.xpath("//div/div[1][@class='datepicker-days']/table/tbody"));
				for(WebElement chooseDate:date)
				{
					if(chooseDate.getText().contains("today day"))
						chooseDate.findElement(By.xpath("//td[@class='today day']")).click();
				}
		
		

	}

}
