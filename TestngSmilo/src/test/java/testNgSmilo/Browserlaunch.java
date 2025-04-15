package testNgSmilo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserlaunch 
{
//Non static variable is not get direct access into the static method
//Either remove the modifier of the method
//Make the class variable as static
//create an object inside the method of the class and use the non static class variable
	
 protected static WebDriver driver; 
 public static WebDriver launchBrowser()
 {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 return driver;
 }
}
