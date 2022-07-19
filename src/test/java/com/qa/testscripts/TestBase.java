package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;
import com.qa.pages.CitiBankPages;
import com.qa.pages.NewToursPages;
import com.qa.pages.RediffPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver = null;
	AmazonPages AmazonOR;
	NewToursPages NewToursOR;
	CitiBankPages CitiBankOR;
	RediffPages RediffOR;
	FileInputStream fileLoc;
	Properties prop;
	SoftAssert sAssert;
	Alert JsAlert;
	Actions act;
	JavascriptExecutor Js;
	WebDriverWait expWait;
	
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) throws IOException {	
		
		fileLoc = new FileInputStream("D:\\Selenium Training\\HyDigit - Batch 3 - FY'23\\IBM.Batch3.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\Credentials.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
			
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		AmazonOR = new AmazonPages(driver);
		NewToursOR = new NewToursPages(driver);
		CitiBankOR = new CitiBankPages(driver);
		RediffOR = new RediffPages(driver);
		
		expWait = new WebDriverWait(driver,40);
		
		sAssert =new SoftAssert();
		Js = (JavascriptExecutor)driver;
		act = new Actions(driver);
		
		driver.get(Url); // Launch the WebApplication through an URL and get method will wait till the page is loaded
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	// tName : name of the method / test annotated as @Test
	
	public void capturescreenshot(WebDriver driver, String tName) throws IOException {		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(Source, Target);
	}

}
