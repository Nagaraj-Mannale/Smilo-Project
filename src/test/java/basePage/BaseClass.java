package basePage;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.Widget;

public class BaseClass extends Widget
{
public BaseClass(WebDriver driver) {
		super(driver);
		
	}

@Before
public void setup(String url)
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("v2widget.tech-active.com/"+url);
}
}
