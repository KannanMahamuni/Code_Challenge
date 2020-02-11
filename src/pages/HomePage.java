package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WebdriverMethods;

public class HomePage {
	
	WebDriver driver;

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement SearchBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement Searchbuttton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void searchheadphone() throws Exception
	{
		//Searching the Headphone in Amazon Home page
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		SearchBox.click();
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		searchBox.sendKeys("Headphones");
		searchBox.sendKeys(Keys.ENTER);
	}

}
