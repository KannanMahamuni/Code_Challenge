package Utilities;


import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebdriverMethods {
	public static WebDriver driver;
	public WebdriverMethods(WebDriver driver) {
		
		this.driver = driver;
		//PageFactory.initElements(driver, this);
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
	public boolean performExplictWaitByLocator(String locator, int wait_time,	boolean found) throws Exception {
		boolean elementFound = false;
		WebDriverWait wait;
		try 
		{
			wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			elementFound = true;
		} 
		catch (Exception e) 
		{
			if (found)
			{
				System.out.println(e);
				throw e;
			}
		}
		return elementFound;
	}

	public void performType(WebElement element, String value) throws Exception {
		performExplictWait(element, 20, true);
		element.clear();
		element.sendKeys(value);
	}

	
	   public void performJETypeByLocator(String locator, String value) throws Exception
	    {
	           performExplictWaitByLocator(locator, 20, true);
	           WebElement element = driver.findElement(By.xpath(locator));
	           element.clear();
	           JavascriptExecutor executor = (JavascriptExecutor)driver;
	           executor.executeScript("arguments[0].value=value='"+value+"';", element);

	    } 
	   
		public void performHandleNewWindowWithScreen(String title, String Page) {
			boolean found = false;
			WebDriver popup = null;

			Set<String> windowIterator = driver.getWindowHandles();
			for (String s : windowIterator) {
				String windowHandle = s;
				popup = driver.switchTo().window(windowHandle);
				if (popup.getTitle().equals(title)
						|| popup.getCurrentUrl().contains(title)) {
					
					found = true;
					break;
				}

			}
			if (!found) {
				
			}

		}
		
	
		



}
