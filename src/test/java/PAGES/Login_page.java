package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BASE_CLASSES.DRIVERWAIT;

public class Login_page {
	WebDriver dr;
	DRIVERWAIT d;
	public String Label;
	public String Error;
	public String encrypted_pwd;
	By user=By.xpath("//input[@id='user-name']");
	By pwd=By.xpath("//input[@id='password']");
	By click=By.xpath("//input[@class='btn_action']");
	By Txt_ver=By.xpath("//h3[@data-test='error']");
	By label=By.xpath("//div[@class='product_label']");
//constructor for driver
public Login_page(WebDriver dr)
		{
			this.dr=dr;
			d=new DRIVERWAIT(dr);
		}
//Entering Username
public void Username(String name)        
	{
		System.out.println(name);
		WebElement w1=d.visibility(user,20);         
		w1.sendKeys(name);
	}
//Entering Password
public void Password(String passwd)   
	{
		System.out.println(passwd);
		WebElement w2=d.visibility(pwd,20);
		w2.sendKeys(passwd);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//Clicking Login Button
public void Login_button()                   
	{
		WebElement w3=d.clickable(click,20);
		w3.click();
	}

//verifing login
public void verify_login()   
	{
		try 
		{
		WebElement w4=d.visibility(Txt_ver,20);
		Error =w4.getText();
		System.out.println(Error);
		}
		catch(Exception e)
		{
		WebElement w5=d.visibility(label,20);
		Label=w5.getText();
		}
	}
//Calling all Login Functions
public  void login_functions(String Username,String Password)      
	{
		this.Username(Username);
		this.Password(Password);
		this.Login_button();
		this.verify_login();
	}
}
