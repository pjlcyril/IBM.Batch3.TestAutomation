package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_JavaScriptExecutor extends TestBase{
	
	@Test(priority=1)
	public void ScrollBars() throws InterruptedException {
		
		// Vertical scroll By
		for(int i=0;i<5;i++) {
			Js.executeScript("window.scrollBy(0,500)"); // Top to Bottom
			Thread.sleep(3000);
		}
		
		
		for(int i=5;i>=1;i--) {
			Js.executeScript("window.scrollBy(0,-500)"); //Bottom to Top
			Thread.sleep(3000);
		}
		/*
		
		// Horizontal scroll By
				for(int i=0;i<5;i++) {
					Js.executeScript("window.scrollBy(500,0)"); // Left to Right LHS to RHS
					Thread.sleep(3000);
				}
				
				
				for(int i=5;i>=1;i--) {
					Js.executeScript("window.scrollBy(-500,0)"); //Right to Left (RHS to LHS)
					Thread.sleep(3000);
				}
				
		*/
	}

	@Test(priority=2)
	public void ScrollByElement() throws InterruptedException {
		// Scroll to the bottom of the page till the English language selector
		// Mouseover action and check the no. of options to select the local languges.
		
		WebElement ele = AmazonOR.getLanguageSelector();
		
		Js.executeScript("arguments[0].scrollIntoView",ele);
		Thread.sleep(3000);
		
		act.moveToElement(ele).build().perform();
		
		Thread.sleep(3000);
		List<WebElement> AllRadioBtns = AmazonOR.getLanguageRadioBtns();
		System.out.println("Total no. of radio buttons for language selection are : " + AllRadioBtns.size());
		Thread.sleep(3000);
		
	}
}
