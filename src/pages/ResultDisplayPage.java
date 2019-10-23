package pages;


import java.util.List;
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
	
	public ResultDisplayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
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
		Thread.sleep(30000);
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.MINUTES);
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
		        System.out.println("Best Seller "+(i+1)+" is added to the Cart");
		        
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'uss-o-close-icon uss-o-close-icon-medium') or contains(@class,'a-link-normal close-button')]"))).click();
		        //back to headphone best seller page
		        driver.navigate().back();
		        driver.navigate().refresh();
		        
		        System.out.println("Locating the Best Seller "+(i+1)+"  ");
	    }
		int count = bestSellers.size();
		System.out.println("There are "+count+" Best seller item in the Headphone page and added to cart" );

	}
	

}
