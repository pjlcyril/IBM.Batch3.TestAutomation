package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_NewTours_001 extends TestBase{
	
	@Test
	public void Login() throws InterruptedException {
		
		
		String title = driver.getTitle();
		sAssert.assertEquals(title, "Welcome: Mercury Tours");
		
		NewToursOR.getUnameTextField().sendKeys(prop.getProperty("Uname"));
		Thread.sleep(2000);
		NewToursOR.getPwdTextField().sendKeys(prop.getProperty("Pwd"));
		Thread.sleep(2000);
		NewToursOR.getSubmitBtn().click();
		boolean contains = driver.getTitle().contains("Login");
		if(contains) {
			Reporter.log("The Login is sucessfull",true);
			sAssert.assertTrue(contains);
		}else {
			Reporter.log("The Login is not sucessfull",true);
			sAssert.assertTrue(contains);
		}
		
		sAssert.assertAll();
	}

}
