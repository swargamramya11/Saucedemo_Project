package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseclasses.DriverWait;

public class LoginPage {
	WebDriver driver;
	DriverWait driverWait;
	public String label1;
	public String error;
	By user=By.xpath("//input[@id='user-name']");
	By pwd=By.xpath("//input[@id='password']");
	By click=By.xpath("//input[@class='btn_action']");
	By Txtver=By.xpath("//h3[@data-test='error']");
	By label=By.xpath("//div[@class='product_label']");
//constructor for driver
public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			driverWait=new DriverWait(driver);
		}
//Entering Username
public void userName(String userName)        
	{
		System.out.println(userName);
		WebElement w1=driverWait.visibility(user,20);         
		w1.sendKeys(userName);
	}
//Entering Password
public void password(String passwd)   
	{
		System.out.println(passwd);
		WebElement w2=driverWait.visibility(pwd,20);
		w2.sendKeys(passwd);
	}
//Clicking Login Button
public void login_Button()                   
	{
		WebElement w3=driverWait.clickable(click,20);
		w3.click();
	}
//verifing login
public String verify_Login()   
	{
		try 
		{
		WebElement w4=driver.findElement(Txtver);
		error =w4.getText();
		System.out.println("login is unsuccessfull");
		System.out.println(error);
		return error;
		}
		catch(Exception e)
		{
		WebElement w5=driver.findElement(label);
		label1=w5.getText();
		System.out.println(label1);
		System.out.println("login is successfull");
		return label1;
		}
	}
public String login_Functions(String userName,String password)
{
	this.userName(userName);
	this.password(password);
	this.login_Button();
	return this.verify_Login();
}
}
