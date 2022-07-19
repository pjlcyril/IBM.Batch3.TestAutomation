package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver rDriver;

	// AmazonPages is a page object model that holds the element description for all the elements present on the Amazon web page.	
	//Element description into a reference variable of type WebElement
	
	@FindBy(id="nav-logo-sprites")
	WebElement AmazonLogo;
	
	public WebElement getAmazonLogo() {
		return AmazonLogo;
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTextField;
	
	public WebElement getSearchTextField() {
		return SearchTextField;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	@FindBy(name="url")
	WebElement Category;
	
	public Select getCategory() {
		Select cat = new Select(Category);
		return cat;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> AllItems;
	
	public List<WebElement> getAllItems(){
		return AllItems;
	}

	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> AllFooterLinks;
	
	public List<WebElement> getAllFooterLinks(){
		return AllFooterLinks;
	}

	@FindBy(className="icp-color-base")
	WebElement LanguageSelector;
	
	public WebElement getLanguageSelector() {
		return LanguageSelector;
	}
	
	
	@FindAll(@FindBy(className="icp-radio"))
	List<WebElement> LanguageRadioBtns;
	
	public List<WebElement> getLanguageRadioBtns(){
		return LanguageRadioBtns;
	}
	
	public AmazonPages(WebDriver driver) {
		this.rDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
