package testNgSmilo;

import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class PepLogin 
{
	WebDriver driver;
	@BeforeTest
	@Parameters("url")
	  void launchTheBrowser(String url)
	  {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://"+url);
	  }
	  @Test(priority=0)
	  void EntermailAndPassword()
	  {
		  driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("smilotester@gmail.com");
		  driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Ind@123");
		  driver.findElement(By.xpath("//button[@id='login_submit']")).click();
      }
	  @Test(priority=1)
	  void userOnThePEPDashboardPage()
	  {
		  
	  }

	  @AfterTest
	  void CloseThebrowser()
	  {
		  driver.quit();
	  }
	  
	  
	  
	  }
