package com.qa.testngDemo;

import org.testng.annotations.Test;

public class TC_FundTransfer_001 extends TestBase{
	
	@Test(priority=1, invocationCount=3)
	public void FTNeft() {
		System.out.println("Steps to do fund transfer using NEFT");
	}
	
	@Test(priority=2)
	public void FTImps() {
		System.out.println("Steps to do fund transfer using IMPS");
	}

	@Test(priority=3)
	public void FTInternational() {
		System.out.println("Steps to do fund transfer using international");
	}
}
