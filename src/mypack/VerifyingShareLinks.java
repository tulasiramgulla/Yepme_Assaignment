package mypack;
import testutils.Helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VerifyingShareLinks  extends Helper{
	//WebDriver driver;
	Helper h = new Helper();

	@BeforeMethod
	  public void b(){
		 chromebow();
		//browserType();
		  loadPage();
		 
		}
	@Test
	public void test() throws InterruptedException {
		
		
		
	System.out.println(driver.getTitle());
		System.out.println(config.getProperty("testUrl"));
		/*storing all the social sites into one container*/
		List<WebElement> li = driver.findElement(By.className("social")).findElements(By.tagName("a"));
		if(li.size()==0){
			Assert.fail("Social links are not loaded into the list");
		}
		/*loading the hrefs into one more list*/
		List<String> ls = new ArrayList<String>();
		for(int i=0;i<li.size();i++){
			
		ls.add(li.get(i).getAttribute("href"));
		
		}
	
		System.out.println("Number of element in the shaded link container : "+ls.size());
		System.out.println("Opening the Shaded Links: ");
		System.out.println("============================================================");
		/*clicking on the each link one bye one and verifying whether page is loaded successfully or not*/
		for(int j=0;j<ls.size();j++){
			driver.get(ls.get(j));
			sleep(5);
			System.out.println("the page supposed to be loaded is :"+ ls.get(j));
			System.out.println("The page loaded is:"+ driver.getCurrentUrl());
			 if((driver.getCurrentUrl().contains("facebook"))){
				 System.out.println(" facebook is Opened successfully \n");
			 }	else if((driver.getCurrentUrl().contains("plus.google"))){
				 System.out.println(" google plus is opened successfully\n"); 
			 } else{
				 System.out.println(" youtube is opened successfully");
			 }
			 sleep(5);
			 
		}
	}
		
	@AfterMethod
	public void a(){
	
		sleep(5);
		closingBrowser();
		
	}
	 
}
	

	    
	





