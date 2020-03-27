package BASE_CLASSES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DRIVERWAIT {
	WebDriver dr;
	WebElement we;
//constructor for driver
public DRIVERWAIT(WebDriver dr)
	{
		this.dr=dr;
	}
//webdriverwait for element to be clickable
public WebElement clickable(By locator,int timeout)
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(dr,timeout);
		we=wt.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	catch(WebDriverException e)
	{
		
	}
	return we;
	}
//webdriverwait for text to be visible 
public WebElement visibility(By locator,int timeout)
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(dr,timeout);
		we=wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	catch(WebDriverException e)
	{
		
	}
	return we;
	}
}
