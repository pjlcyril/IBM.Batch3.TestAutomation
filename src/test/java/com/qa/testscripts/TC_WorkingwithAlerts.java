package com.qa.testscripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TC_WorkingwithAlerts extends TestBase{
	
	@Test
	public void registration() throws InterruptedException {
				
		RediffOR.getFirstNameTxtField().sendKeys("345576");
		Thread.sleep(3000);
		RediffOR.getFirstNameTxtField().sendKeys(Keys.TAB); // Alert window will pop up
		Thread.sleep(3000);
		
		JsAlert = driver.switchTo().alert();
		System.out.println(JsAlert.getText());
		JsAlert.accept();
		Thread.sleep(3000);
		
		RediffOR.getFirstNameTxtField().clear();
		Thread.sleep(3000);
		RediffOR.getFirstNameTxtField().sendKeys("Kim Smith");
		Thread.sleep(3000);
		RediffOR.getEmailIDTxtField().sendKeys("test@test.com");
	}

}
