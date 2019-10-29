package pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResultDisplayPage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//span[contains(@id,'-best-seller-label')])[1]")
	WebElement BestSeller;
	
	@FindBy(xpath="//h4[text()='Add to your order']")
	WebElement Addtoyourtorder;
	
	@FindBy(xpath="//button[@id='siNoCoverage-announce']")
	WebElement NothanksButton;
	
	@FindBy(xpath="//button[@id='attachSiNoCoverage-announce']")
	WebElement NothanksButton2;
	
	@FindBy(xpath="(//span/button[contains(text(),'No Thanks')])[3]")
	WebElement NothanksButtontext;

	@FindBy(xpath="//a[@id='attach-close_sideSheet-link']")
	WebElement closebutton;
	
	public ResultDisplayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean performExplictWait(WebElement locator, int wait_time, boolean found) throws Exception {
		boolean elementFound = false;
		WebDriverWait wait;
		try {
			wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.visibilityOf(locator));
			elementFound = true;
		} catch (Exception e) {
			if (found) {
				
			}
		}
		return elementFound;
	}
	
	public void bestselleraddtocart() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 25);
		//Thread.sleep(30000);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.MINUTES);
		performExplictWait(BestSeller,10,true);
		Actions action = new Actions(driver);
		
		//Getting the Best Seller Headphone elements
		List<WebElement> bestSellers = driver.findElements(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1]"));
		for(int i=1;i<=bestSellers.size();i++) {
				Thread.sleep(5000);
				//Navigating to  next page by clicking best seller to add it into cart
				action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]")))).build().perform();
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]"))).click();
		   
		        //Adding the Best seller to Cart
		        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click(); 
		        if(performExplictWait(Addtoyourtorder,10,false))
		        {
		        	performExplictWait(NothanksButton,5,false);
		        	NothanksButton.click();
		        }
		        
		        if(performExplictWait(NothanksButton2,10,false))
		        {
		        	NothanksButton2.click();
		        }
		        
		        if(performExplictWait(closebutton,10,false))
		        {
		        	closebutton.click();
		        }
		        
		        if(performExplictWait(NothanksButtontext,10,false))
		        {
		        	NothanksButtontext.click();
		        }
		        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='siAddCoverage-announce']"))).click();
		        System.out.println("Best Seller "+(i)+" is added to the Cart");
		        
		        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'uss-o-close-icon uss-o-close-icon-medium') or contains(@class,'a-link-normal close-button')]"))).click();
		        driver.navigate().back();
		        
		        //back to headphone best seller page
		        driver.navigate().back();
		      
		        driver.navigate().refresh();
		        
		        System.out.println("Locating the Best Seller "+(i+1)+"  ");
	    }
		int count = bestSellers.size();
		System.out.println("There are "+count+" Best seller item in the Headphone page and added to cart" );

	}
	

}
