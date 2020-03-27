package PAGES;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BASE_CLASSES.DRIVERWAIT;

public class Add_to_cart_page {
	WebDriver dr;
	DRIVERWAIT d;
	int count=0;
	int items_should_be_added=6;
	By number=By.xpath("//a[@href='./cart.html']//span");
//constructor for driver
public Add_to_cart_page(WebDriver dr)
	{
		this.dr=dr;
		d=new DRIVERWAIT(dr);
	}
// selecting the Name (A to Z)
public void select_A2Z() 
	{              
		System.out.println("A to Z is selected");
		WebElement w1=dr.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select"));         
		Select sel=new Select(w1);
		sel.selectByVisibleText("Name (A to Z)");
	}
//Clicking the Add to Cart Buttons  	
public void click_Addtocart_btn() 
	{        
	for(int i=1;i<=items_should_be_added;i++)
	{
		count++;
		dr.findElement(By.xpath("//div[@class='inventory_item']["+i+"]//following::button")).click();
	}
	}
//verifing about items Added to cart
public void verify_AddtoCart() 
	{
	WebElement w3=d.clickable(number,20);         
	String num=w3.getText();
	int Total_items_added=Integer.parseInt(num);
		if(count==Total_items_added)
		{
			System.out.println("All items are added to cart ");
		}
		else 
		{
			System.out.println("All items are not added to the cart");
		}
	}
//calling all functions in add to cart page
public void functions() 
	{
			this.select_A2Z(); 
			this.click_Addtocart_btn();
			this.verify_AddtoCart();
	}
}
