package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseclasses.DriverWait;

public class AddToCartPage {
	WebDriver driver;
	DriverWait driverWait;
	int count=0;
	int items_should_be_added=6;
	By number=By.xpath("//a[@href='./cart.html']//span");
//constructor for driver
public AddToCartPage(WebDriver driver)
	{
	this.driver=driver;
	driverWait=new DriverWait(driver);
	}
// selecting the Name (A to Z)
public void select_A2Z() 
	{              
		System.out.println("A to Z is selected");
		WebElement w1=driver.findElement(By.xpath("//*[@class='product_sort_container']"));   
		Select sel=new Select(w1);
		sel.selectByVisibleText("Name (A to Z)");
	}
//Clicking the Add to Cart Buttons  	
public void click_Addtocart_btn() 
	{        
	for(int i=1;i<=items_should_be_added;i++)
	{
		count++;
		driver.findElement(By.xpath("//div[@class='inventory_item']["+i+"]//following::button")).click();
	}
	}
//verifing about items Added to cart
public int verify_AddtoCart() 
	{
	WebElement w3=driverWait.clickable(number,20);         
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
			return Total_items_added;
	}
}
