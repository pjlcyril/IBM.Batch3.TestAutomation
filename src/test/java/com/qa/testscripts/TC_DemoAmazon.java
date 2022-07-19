package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_DemoAmazon {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "D:\\Tools\\SeleniumDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	 // Launch the browser
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		driver.get("http://www.amazon.in/"); // Open an URL
		
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		String title = driver.getTitle(); // fetch the title of webpage in the String format
		System.out.println(title);
		Thread.sleep(3000);
		if(title.contains("Amazon")) {
			System.out.println("The user is on Amazon home page");
		}else {
			System.out.println("The user is not on Amazon home page");
		}
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Thread.sleep(3000);
		
		System.out.println(driver.getWindowHandle()); // Window ID of the driver, return string
		Thread.sleep(3000);
		
		// driver.getWindowHandles(); // Window ID of all windows / tabs that opened on the driver
		// Set<String>
		
		//System.out.println(driver.getPageSource()); // HTML code of the web page, return String
		
		
		//driver.findElement(Locator); // Method used to reach the WebElement present on the page matching the locator
		// single element / first element matching the locator
		// returns WebElement
		// We need to different abstract methods of WebElement interface to interact with the element.
		
		// driver.findElements(Locator); // method returns one or more WebElement matching a locator
		// List<WebElement>
		
		
		//driver.switchTo().window("Window ID"); // switchTo from the driver to a tab / window
		
		//driver.switchTo().frame(id/name/element ref); // switchTO from driver to the frames present in the page
		
		//driver.switchTo().alert(); // switchTo from driver to an alert window(java script alert)
		
		
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward(); 
		Thread.sleep(3000);		
		
		
		
		driver.close(); // Close the browser / driver or current window
		
		driver.quit(); // closes all the tabs and window opened on the browser instance
	
		/*
		//System.setProperty("webdriver.edge.driver", "D:\\Tools\\SeleniumDrivers\\msedgedriver.exe");
		
		WebDriverManager.edgedriver().setup();
		WebDriver eDriver = new EdgeDriver();
		eDriver.get("https://www.google.com/");
	
		eDriver.close();*/
	}

}
