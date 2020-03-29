package baseclasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	WebDriver driver;
//constructor for driver
public ScreenShots(WebDriver driver)
		{
			this.driver=driver;
		}
//Takes the sreenshot  name
public void screenShot(String name)
		{
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File f2=new File("src/test/resources/ScreenShots/"+name+".png");
			try 
			{
				FileUtils.copyFile(f1,f2);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
}
