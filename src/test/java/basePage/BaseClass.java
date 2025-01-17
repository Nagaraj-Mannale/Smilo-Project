package basePage;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
@Before
public void setup(String url)
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
}
}
