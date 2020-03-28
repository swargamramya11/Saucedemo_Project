package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclasses.LaunchBrowser;
import excelutilities.ExcelRead;
import pages.AboutPage;
import pages.AddToCartPage;
import pages.ClickedAboutLinkPage;
import pages.LoginPage;

public class TestChrome {
	WebDriver driver;
	ExcelRead e=new ExcelRead();
	LoginPage loginPage;
	AddToCartPage addToCartPage;
	AboutPage aboutPage;
	ClickedAboutLinkPage link;
//Method to launch browser
@BeforeMethod
public void launchBrowser()
 {
	 driver=LaunchBrowser.Launch_Browser("chrome","https://www.saucedemo.com/");
	 driver.manage().window().maximize();
	 loginPage=new LoginPage(driver);
	 addToCartPage=new AddToCartPage(driver);
	 aboutPage=new AboutPage(driver);
	 link=new ClickedAboutLinkPage(driver);
 }
//To check valid login
@Test(dataProvider="login1")
public void testCase1(String userName,String password) 
	{
	String message1=loginPage.login_Functions(userName,password);
	Assert.assertTrue(message1.equals("Products"));
	}
//To check add to cart operation is performed or not
@Test(dataProvider="login2")
public void testCase2(String userName,String password) 
	{
	loginPage.login_Functions(userName,password);
	
	addToCartPage.select_A2Z();
	addToCartPage.click_Addtocart_btn() ;
	
	int no_Of_Items_Added=addToCartPage.verify_AddtoCart() ;
	Assert.assertTrue(no_Of_Items_Added==6);
	}
//To check page is navigated to about page or not
@Test(dataProvider="login3")
public void testCase3(String userName,String password) 
	{
	loginPage.login_Functions(userName,password);
	
	addToCartPage.select_A2Z();
	addToCartPage.click_Addtocart_btn() ;
	addToCartPage.verify_AddtoCart() ;
	
	aboutPage.about_Functions();
	
	String actual_link1=link.verify_AboutLinkPage();
	Assert.assertTrue(actual_link1.equals("Try it free"));
	}
//To check invalid login due to wrong username
@Test(dataProvider="login4")
public void testCase4(String userName,String password) 
	{
	String message=loginPage.login_Functions(userName,password);
	
	Assert.assertTrue(message.contains("Epic sadface"));
	}
//To check invalid login due to wrong password
@Test(dataProvider="login5")
public void testCase5(String userName,String password) 
	{
	String message=loginPage.login_Functions(userName,password);
	Assert.assertTrue(message.contains("Epic sadface"));
	}
//provides data for valid login
@DataProvider(name="login1")
public String[][] provide_data1()
	{
		 String[][] td=new String[1][2];
		 td=e.read(1,2);
		 return td;
	}
//provides data for add to cart operations
@DataProvider(name="login2")
public String[][] provide_data2()
	{
		 String[][] td=new String[1][2];
		 td=e.read(2,3);
		 return td;
	}
//provides data for click on about link operations
@DataProvider(name="login3")
public String[][] provide_data3()
	{
		 String[][] td=new String[1][2];
		 td=e.read(3,4);
		 return td;
	}
//provides data for invalid login by giving wrong username
@DataProvider(name="login4")
public String[][] provide_data4()
	{
		 String[][] td=new String[1][2];
		 td=e.read(4,5);
		 return td;
	}
//provides data for invalid login by giving wrong password
@DataProvider(name="login5")
public String[][] provide_data5()
	{
		 String[][] td=new String[1][2];
		 td=e.read(5,6);
		 return td;
	}
//close the browser
@AfterMethod
public void close()
{
	driver.quit();
}
}
