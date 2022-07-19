package com.qa.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	// method below this annotation will run before <suite>
	@BeforeSuite
	public void setUp() {
		System.out.println("Test suite starting..");
	}
	// method below this annotation will run after <suite>
	@AfterSuite
	public void tearDown() {
		System.out.println("Test suite stopping...");
	}
	
	// method below this annotation will run before every <test> in a suite
	@BeforeTest
	public void InvokeBrowser() {
		System.out.println("Steps to invoke browser");
	}
	
	// method below this annotation will run after every <test> in a suite
	@AfterTest
	public void CloseBrowser() {
		System.out.println("Steps to close the browser");
	}
	
	
	// method below this annotation will run before every class in a suite
	@BeforeClass
	public void Login() {
	System.out.println("Steps to Login");	
	}
	
	// method below this annotation will run after every class in a suite
	@AfterClass
	public void Logout() {
		System.out.println("Steps to Logout");
	}
	
	// method below this annotation will run before every @Test method in each class
	@BeforeMethod
	public void CheckBalance() {
		System.out.println("Check the balance in the account");
	}

	// method below this annotation will run after every @Test method in a class
	@AfterMethod
	public void Acknowledgement() {
		System.out.println("Print acknowledgement");
	}
}
