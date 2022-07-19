package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_WorkingWithWindows extends TestBase{

	@Test
	public void multipleWindows() {
		
		CitiBankOR.getCitiGroupLink().click(); // 2 Tab
		CitiBankOR.getTAndCLink().click(); // 3rd Tab
		CitiBankOR.getMCLRLink().click(); // 4th Tab
		
		
		Set<String> WindIDs = driver.getWindowHandles();
		Iterator<String> iterator = WindIDs.iterator();
		
		while(iterator.hasNext()) {
			String WindID = iterator.next();			
			WebDriver window = driver.switchTo().window(WindID);
			System.out.println(window.getTitle());
			System.out.println(window.getCurrentUrl());
		}
		
	}
}
