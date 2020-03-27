package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BASE_CLASSES.DRIVERWAIT;

public class clicked_link_page {
	WebDriver dr;
	DRIVERWAIT d;
	By verify_link=By.xpath("//a[@class='button is-rounded is-secondary']");
//constructor for driver
public clicked_link_page(WebDriver dr)
		{
			this.dr=dr;
			d=new DRIVERWAIT(dr);
		}
//To verify whether the page is navigated correctly
public void verify_page()        
		{
			System.out.println("page navigated to corresponding clicked link");
			String expected_link="Try it free";
			WebElement w1=d.visibility(verify_link,20);         
			String actual_link=w1.getText();
			System.out.println(actual_link);
			Assert.assertTrue(expected_link.equals(actual_link));
			System.out.println("page navigated correctly");
		}
}
