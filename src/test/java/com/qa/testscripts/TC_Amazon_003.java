package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_003 extends TestBase {

	// Working with different abstract methods of Select class

	@Test(priority=1)
	public void ItemsInCategoryList() throws IOException{

		Select Category = AmazonOR.getCategory();

		WebElement firstSelectedOption = Category.getFirstSelectedOption();
		System.out.println("The first selected option is : " + firstSelectedOption.getText());


		List<WebElement> allSelectedOptions = Category.getAllSelectedOptions();
		System.out.println("Total no. of items selected are : " + allSelectedOptions.size());		

		for(WebElement item:allSelectedOptions) {
			System.out.println(item.getText());
		}

		List<WebElement> AllOptions = Category.getOptions();

		System.out.println("Total no. of items present in the category select element are : " + AllOptions.size());
		boolean condition = AllOptions.size()<=50;
		if(condition) {
			sAssert.assertTrue(condition);
			Reporter.log("Items are present in the list");
			for(WebElement option:AllOptions) {
				System.out.println(option.getText());
			}			

		}else {
			capturescreenshot(driver,"ItemsInCategoryList");
			sAssert.assertTrue(condition);
			Reporter.log("Items are missing in the list");
		}	

		sAssert.assertAll();

	}

	@Test(priority=2, dependsOnMethods="ItemsInCategoryList")
	public void validateMultipleItems() {
		Select Category = AmazonOR.getCategory();
		boolean multiple = Category.isMultiple();
		if(multiple) {			
			sAssert.assertTrue(multiple);
			System.out.println("Supports multiple selection");
		}else {			
			sAssert.assertTrue(multiple);
			System.out.println("Doesn't support multiple selection");
		}
	}

}
