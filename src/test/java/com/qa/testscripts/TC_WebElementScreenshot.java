package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

public class TC_WebElementScreenshot extends TestBase{

	@Test
	public void ElementScreenshot() throws IOException {
		
		File Source = AmazonOR.getAmazonLogo().getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+ "/Screenshots/" + "AmazonLogo.png");
		FileUtils.copyFile(Source, Target);
		
	}
	
}
