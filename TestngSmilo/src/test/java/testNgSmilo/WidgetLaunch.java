package testNgSmilo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WidgetLaunch 
{
 WebDriver driver;
	@BeforeClass
	  void launchTheBrowser()
	  {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://v2widget.tech-active.com/get-started/E8ofS6LFsTYPMp0rlLOzFPySAj5of9K0jfXsQThyD4OsKaElvT");
	  }
	@Test
	void verify()
	{
		
	}
	@AfterClass
	void close()
	{
		driver.close();
	}
}
