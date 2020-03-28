package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseclasses.DriverWait;

public class AboutPage {
	WebDriver driver;
	DriverWait driverWait;
	By click1=By.xpath("//div[@class='bm-burger-button']");
	By click2=By.xpath("//nav[@class='bm-item-list']//child::a[2]");
//constructor for driver	
public AboutPage(WebDriver driver)
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
	}
//click on link
public void link_For_About_Page() 
	{
		System.out.println("link is clicked");
		WebElement w1=driverWait.clickable(click1,20);         
		w1.click();
	}
//click on about
public void about() 
	{
		System.out.println("about is clicked");
		WebElement w2=driverWait.clickable(click2,20);         
		w2.click();
	}
//calling all functions of about page
public void about_Functions()
	{
		this.link_For_About_Page();
		this.about();
	}
}
