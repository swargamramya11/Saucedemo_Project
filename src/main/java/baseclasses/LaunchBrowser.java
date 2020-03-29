package baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
	protected static WebDriver driver;
	static String path1="src/test/resources/Drivers/chromedriver.exe";
	static String path2="src/test/resources/Drivers/geckodriver.exe";
//method to launch selected browser
public static WebDriver Launch_Browser(String browser,String url)
	{
	if(browser.contains("chrome"))     //to launch chrome browser
	{
			System.setProperty("webdriver.chrome.driver",path1);
			driver=new ChromeDriver();
	}
	if(browser.contains("firefox"))    //to launch firefox browser
	{
			System.setProperty("webdriver.gecko.driver",path2);
			driver=new FirefoxDriver();
	}
			driver.get(url);
			driver.manage().window().maximize();
			return driver;
	}
}
