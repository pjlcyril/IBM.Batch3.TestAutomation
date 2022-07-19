package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitiBankPages {

	WebDriver driver;

	public CitiBankPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}


	@FindBy(linkText="CITIGROUP.COM")
	WebElement CitiGroupLink;

	public WebElement getCitiGroupLink() {		
		return CitiGroupLink;
	}

	@FindBy(linkText="TERMS AND CONDITIONS")
	WebElement TAndCLink;

	public WebElement getTAndCLink() {
		return TAndCLink;
	}

	@FindBy(linkText="MCLR")
	WebElement MCLRLink;

	public WebElement getMCLRLink() {
		return MCLRLink;
	}

}
