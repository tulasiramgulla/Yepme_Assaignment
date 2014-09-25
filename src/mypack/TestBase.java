package mypack;
import testutils.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import testutils.Helper;

public class TestBase  {
	Helper h;
	public static WebDriver driver;
	public static Properties config=null;
	public static Properties OR=null;
	
	//the following statement is same for all when you want to use log4j
	public static Logger logger=Logger.getLogger("devpinoyLogger");
		
	@BeforeSuite
	public void initialize() throws IOException{
		
		
		logger.debug("Starting the test suit.........");
		logger.debug("loading the config file..........");
				
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		config= new Properties();
		config.load(fp);
		
		logger.debug("loading OR files");
		
		FileInputStream fp1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR=new Properties();
		OR.load(fp1);
		System.out.println("choosing the browser " + config.getProperty("browserType"));
			

		
	}
	
}
