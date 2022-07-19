package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {

	WebDriver driver;
	
	
	@FindBy(xpath="//tbody/tr[3]/td[3]/input[1]")
	WebElement FirstNameTxtField;
	
	public WebElement getFirstNameTxtField() {
		return FirstNameTxtField;
	}
	
	

	@FindBy(xpath="//tbody/tr[7]/td[3]/input[1]")
	WebElement EmailIDTxtField;
	
	public WebElement getEmailIDTxtField() {
		return EmailIDTxtField;
	}
	
	
	public RediffPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

}
