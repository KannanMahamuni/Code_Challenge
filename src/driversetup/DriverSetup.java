package driversetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {

	public WebDriver driver;
	//URL of the Website
	public static String url="https://www.amazon.com/";
	
	//Function for Driver Setup
	public WebDriver browserSetup() throws IOException
	{   
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Chrome\n2.Firefox \nEnter your choice:");
		String choice=br.readLine();
		
		switch(choice)
		{
		//To start Chrome Driver
		case "1":
		      System.setProperty("webdriver.chrome.driver", "C:\\Test Automation\\Software\\chrome\\New Version\\chromedriver.exe");
		      ChromeOptions options=new ChromeOptions();
		      options.addArguments("--disable-notifications");
		      driver=new ChromeDriver(options);
		      break;
		
		//To start Firefox Driver
		case "2":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\COGNIZ56\\Downloads\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		}   
		
		driver.get(url);
		
		//To maximize the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
		
		return driver;
	}
}
