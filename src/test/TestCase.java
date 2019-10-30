package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driversetup.DriverSetup;
import pages.HomePage;
import pages.ResultDisplayPage;

public class TestCase extends DriverSetup {

	
	  WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() 
	  {
		try
		{
			driver=browserSetup();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	  }

	@Test
	public void addtocart() throws Exception
	{
		try
		{
		HomePage hm = new HomePage(driver);
		hm.searchheadphone();
		ResultDisplayPage rdp = new ResultDisplayPage(driver);
		rdp.bestselleraddtocart();	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	
	@AfterMethod
	  public void tearDown() 
	  {
		  driver.quit();
	  }

	

}
