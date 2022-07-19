package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewToursPages {
	WebDriver driver;
	
	public NewToursPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(name="userName")
	WebElement UnameTextField;
	
	public WebElement getUnameTextField() {
		return UnameTextField;
	}
	
	@FindBy(name="password")
	WebElement PwdTextField;
	
	public WebElement getPwdTextField() {
		return PwdTextField;
	}
	
	@FindBy(name="submit")
	WebElement SubmitBtn;
	
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

}
