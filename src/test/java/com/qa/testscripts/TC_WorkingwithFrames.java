package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_WorkingwithFrames extends TestBase{

	@Test(priority=1)
	public void FrameByIndex() {
		// how many frames are present on the driver
		// switchTo each frame by its index position
		// get the title of the frame
		// the no. of hyperlinks present on each frame

		List<WebElement> AllFrames = driver.findElements(By.tagName("frame"));
		int count = AllFrames.size();
		System.out.println("Total no. of frames present on the page are : " + count );

		for(int i=0; i<count; i++) {
			WebDriver frame = driver.switchTo().frame(i);
			System.out.println(frame.getTitle());

			List<WebElement> AllLinks = frame.findElements(By.tagName("a"));
			System.out.println("Total no. of links present on the frame " + i + " are : " + AllLinks.size());
			driver.switchTo().defaultContent();	
		}


	}

	@Test(priority=2)
	public void FrameByName() {
		WebDriver frame = driver.switchTo().frame("packageFrame");

		System.out.println(frame.getTitle());

		List<WebElement> AllLinks = frame.findElements(By.tagName("a"));
		System.out.println("Total no. of links present on the frame are : " + AllLinks.size());
		driver.switchTo().defaultContent();	
	}

	@Test(priority=3)
	public void FrameByElement() {
		WebElement ele = driver.findElement(By.xpath("//frame[@title='All Packages']"));

		WebDriver frame = driver.switchTo().frame(ele);
		System.out.println(frame.getTitle());

		List<WebElement> AllLinks = frame.findElements(By.tagName("a"));
		System.out.println("Total no. of links present on the frame are : " + AllLinks.size());
		driver.switchTo().defaultContent();	

	}
}
