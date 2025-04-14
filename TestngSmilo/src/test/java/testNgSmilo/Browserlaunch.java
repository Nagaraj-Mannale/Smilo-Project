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
	
 static WebDriver driver; 
 public static WebDriver launchBrowser(String url)
 {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://"+url);
     new BookAnAppointmentPage(driver); 
	 return driver;
 }
}
