package basePage;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
    protected WebDriver driver; // Use the global WebDriver instance.
    @Before
    public void setup(String url) {
        //WebDriverManager.chromedriver().setup(); // Set up the ChromeDriver binary automatically.
        driver = new ChromeDriver(); // Instantiate the WebDriver.
        driver.manage().window().maximize(); // Maximize the browser window.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add an implicit wait.
        driver.get("https://v2widget.tech-active.com/" + url); // Navigate to the target URL.
    }
}
