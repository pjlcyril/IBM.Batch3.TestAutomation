package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_AmazonDemo_001 {

	public static void main(String[] args) throws InterruptedException {

		//1. Open the browser (IE / Chrome/ FF / Edge)
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//2. Launch amazon web site "http://www.amazon.in/"	
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		//3. Check if the user is landed on the amazon home page
		
		boolean contains = driver.getTitle().contains("Amazon");
		if(contains) {
			System.out.println("The user is on Amazon home page");
		}else {
			System.out.println("The user is not on Amzon home page");
		}
		
		Select Category = new Select(driver.findElement(By.name("url")));
		Category.selectByVisibleText("Books");
		Thread.sleep(3000);
		
		// 5. Enter Da vinci code the search item text field 
		WebElement SearchTextField = driver.findElement(By.id("twotabsearchtextbox"));
		SearchTextField.sendKeys("Da Vinci Code");
		Thread.sleep(3000);
		
		// 6. Click the magnifier button 	
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		
		// 7. The items related to search term should be loaded 
		boolean contains2 = driver.getTitle().contains("Da Vinci Code");
		if(contains2) {
			System.out.println("Item is searched");
		}else {
			System.out.println("Item is not searched");
		}
		
		List<WebElement> AllItems = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int size = AllItems.size();
		System.out.println("Total no. of items loaded are : " + size);
		
		for(WebElement item:AllItems) {
			System.out.println(item.getText());
		}
		
		// 8. close the browser	
		driver.close();
	}

}
