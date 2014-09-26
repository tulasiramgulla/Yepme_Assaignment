package mypack;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Helper;

public class DynamicImageForwarding extends Helper {
	Helper h = new Helper();
	@BeforeMethod
	  public void b(){
		  System.out.println(config.getProperty("browserType"));
		 browserType();
		  loadPage();
		  
		}
	@Test
	public void test() {
		sleep(5);
		List<WebElement> list1 = driver.findElement(By.cssSelector("ol.flex-control-nav.flex-control-paging")).findElements(By.tagName("a"));
		System.out.println("Elements in The Container"+list1.size());
		if(list1.size()==0){
			Assert.fail("Images are not stored properly into the list");
		}
		System.out.println("=================================================================================");
		/* Clicking on the images one by one, by taking them from the list*/ 
		for(int i=0;i<list1.size();i++){
			if(i==0){
				sleep(3);
				list1.get(i).click();
				
			}else{
				list1.get(i).click();	
			}
			/*checking the condition whether the required page loaded successfully or not*/
			sleep(3);
			System.out.println("The link clicked is:" +list1.get(i).getText());
			sleep(5);
			System.out.println(list1.get(i).getAttribute("class"));
			if(list1.get(i).getAttribute("class").equalsIgnoreCase("flex-active")){
				
				System.out.println("The corresponding image is loaded successfully");
			
			}
		}
	
}
	@AfterMethod
	public void af()
	{
		sleep(5);
		closingBrowser();
		
	}

}