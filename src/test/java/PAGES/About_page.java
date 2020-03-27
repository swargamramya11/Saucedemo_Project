package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BASE_CLASSES.DRIVERWAIT;
public class About_page {
	WebDriver dr;
	DRIVERWAIT d;
	Actions kb;
	By click1=By.xpath("//div[@class='bm-burger-button']");
	By click2=By.xpath("//nav[@class='bm-item-list']//child::a[2]");
	
	
//constructor for driver	
public About_page(WebDriver dr)
	{
		this.dr=dr;
		d=new DRIVERWAIT(dr);
		kb= new Actions(dr);
	}
//click on link
public void link_for_aboutpage() 
	{
		System.out.println("link is clicked");
		WebElement w1=d.clickable(click1,20);         
		w1.click();
	}
//click on about
public void About_Saucedemo() 
	{
		System.out.println("about is clicked");
		WebElement w2=d.clickable(click2,20);         
		w2.click();
	}

//calling all functions of about page
public void about_functions()
{
		this.link_for_aboutpage();
		this.About_Saucedemo();
		
}
}
