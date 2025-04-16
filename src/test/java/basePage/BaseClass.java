package basePage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;

    // Singleton WebDriver Initialization
    public static void setup(String url) {
        if (driver == null) { 
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.get("https:"+url);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensures driver is reset after execution.
        }
    }
}
