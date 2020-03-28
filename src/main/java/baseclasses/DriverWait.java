package baseclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
	WebDriver driver;
	WebElement web_Element;
//constructor for driver
public DriverWait(WebDriver driver)
	{
		this.driver=driver;
	}
//webdriverwait for element to be clickable
public WebElement clickable(By locator,int timeout)
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(driver,timeout);
		web_Element=wt.until(ExpectedConditions.elementToBeClickable(locator));
	}
	catch(WebDriverException e)
	{
		e.printStackTrace();
	}
		return web_Element;
	}
//webdriverwait for text to be visible 
public WebElement visibility(By locator,int timeout)
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(driver,timeout);
		web_Element=wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	catch(WebDriverException e)
	{
		e.printStackTrace();
	}
		return web_Element;
	}
}
