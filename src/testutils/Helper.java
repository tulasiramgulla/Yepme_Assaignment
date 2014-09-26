package testutils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import mypack.TestBase;

public class Helper extends TestBase {
	
	//Selecting Browser Type and Opening browser
	public void browserType() {
		  if(config.getProperty("browserType").equalsIgnoreCase("Firefox")) {
			  driver= new FirefoxDriver();
		  }
		  else if(config.getProperty("browserType").equalsIgnoreCase("Chrome")) {
			  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\driver\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }
		  else {
			  if(config.getProperty("browserType").equalsIgnoreCase("IE"))
			  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\driver\\IEDriverServer.exe");
			  driver=new InternetExplorerDriver();
		  }	  
	}
	
	public void chromebow(){
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\driver\\chromedriver.exe");
		  driver = new ChromeDriver();
		  System.out.println("choosing the browser : Chrome" );
	}
	
	
	//Opening the required URL
	public void loadPage() {
		driver.manage().window().maximize();
		//driver.get("http://www.yepme.com/");
		//System.out.println(config.getProperty("testUrl"));
		driver.get(config.getProperty("testUrl"));
	}
			
	
	//Quitting the browser
	public void closingBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	//Wait Method
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			
		}
	}
	
	
	
	
	
	
	
}
