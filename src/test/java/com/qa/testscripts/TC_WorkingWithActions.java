package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class TC_WorkingWithActions extends TestBase{
	
	@Test
	public void DragAndDrop() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));		
		WebElement dest = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		
		act.dragAndDrop(src, dest).build().perform();
		Thread.sleep(3000);
		
		
	}

}
