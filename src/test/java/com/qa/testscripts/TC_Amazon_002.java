package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Amazon_002 extends TestBase{
	
	// Fetch all the hyperlinks present in the footer section of amazon home page.

	@Test
	public void footerLinks() throws IOException{				
		
				List<WebElement> AllLinks = AmazonOR.getAllFooterLinks();				
				int size= AllLinks.size();
				
				boolean condition = size<=100;
				
				if(condition) {
					
					Assert.assertTrue(condition);
					System.out.println("Total no. of hyperlinks present in the footer section of the page are : " +  size);
					
					for(WebElement link:AllLinks) {
						boolean tagName = link.getTagName().contains("a");
					//	System.out.println(tagName);
						if(tagName) {
							String text = link.getText();
							String href = link.getAttribute("href");
							System.out.println("The element " + text +" is a hyperlink " + " - href value is : " + href);
						}else {
							System.out.println("The element is not a hyperlink");
						}
					}
				}else {
					capturescreenshot(driver,"footerLinks");
					Assert.assertTrue(condition);
					System.out.println("The required no. of links are not present");
				}
				
				
				
			
		
	}

}
