package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseclasses.DriverWait;

public class ClickedAboutLinkPage {
	WebDriver driver;
	DriverWait driverWait;
	By verify_Text=By.xpath("//a[@class='button is-rounded is-secondary']");
	
//constructor for driver
public ClickedAboutLinkPage(WebDriver driver)
		{
			this.driver=driver;
			driverWait=new DriverWait(driver);
		}
//To verify whether the page is navigated to About correctly
public String verify_AboutLinkPage()        
		{
			WebElement w1=driverWait.visibility(verify_Text,50);  
			String actual_Text=w1.getText();
			System.out.println(actual_Text);
			System.out.println("Navigated to clicked page");
			return actual_Text;
		}
}
