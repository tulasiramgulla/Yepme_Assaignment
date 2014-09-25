package mypack;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Helper;

public class PurchaseButoon extends Helper{
	Helper h = new Helper();
	@BeforeMethod
	  public void b(){
		  System.out.println(config.getProperty("browserType"));
		  browserType();
		  loadPage();
	}
	@Test
	public void test() throws InterruptedException {
	
		/*======='Purchase Now' button verification================*/
		sleep(5);
		/*Mouse overing the element to be clicked*/
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.className("hoverli_men"))).build().perform();
		/*clicking on an element*/
		a.click(driver.findElement(By.className("hoverli_men")));
		sleep(5);
		driver.findElement(By.id("atagMen1")).click();
		sleep(5);
		/*choosing an item to be buy randomly*/
		List<WebElement> li=driver.findElement(By.className("ib-container")).findElements(By.cssSelector("ul.quickpage1"));
		System.out.println(li.size());	
		Random r = new Random();
		int i = r.nextInt(li.size());
		li.get(i).click();
		sleep(5);
		driver.findElement(By.id("rpsize_ddlSize_0")).click();
		List<WebElement> sl=driver.findElement(By.id("rpsize_ddlSize_0")).findElements(By.tagName("option"));
		System.out.println(sl.size());
		Random r1 = new Random();
		int j = r1.nextInt(sl.size());
		if(j==0){
			
			sl.get(++j).click();
			Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();
		    kb.pressKey(Keys.RETURN);
		}else
		{
		
			sl.get(j).click();
			Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();
		    kb.pressKey(Keys.RETURN);
		}  
		/*========"pincode validation test case started here"===========*/
		
		System.out.println("===========================================================");
		String s = "12346";
		int x = s.length();
		
			Integer y = Integer.parseInt(s);
			System.out.println(s);
		driver.findElement(By.id("txtPostCode")).sendKeys(s);
		driver.findElement(By.id("btnCheck")).click();
		//System.out.println(driver.findElement(By.id("lblCheckDeliveryTime")).getText());
	    if(driver.findElement(By.id("lblCheckDeliveryTime")).getText().equals("Please enter valid Pincode"))
	    {
	    	System.out.println("Entered pincode is wrong");
	    }
	    System.out.println("============================================================");
	    /*==========pincode validation test case ended here============*/
	    sleep(3);
	    driver.findElement(By.id("imgbtnaddtocart")).click();
	   sleep(3);
	
		 WebElement w = driver.findElement(By.className("purchasenow"));
		 String s1 = w.getAttribute("src");
				 System.out.println(s1);
		
		/* verifying the search button's presence*/
	   if(s1.contains("Purchase-Now")){
	    	System.out.println("'Purchase Now' button is present");
	    }else{
	    	Assert.fail("'Purchase Now' button not present");
	    }
	  
		}
	
	@AfterMethod
	public void af()
	{
		sleep(5);
		closingBrowser();
		
	}
	}



