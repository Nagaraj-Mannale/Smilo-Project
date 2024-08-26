package stepDefinations;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    public WebDriver driver;

    @Before
    public void setup() {
        // Set the path to the ChromeDriver executable if needed
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Configure ChromeOptions if necessary
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-notifications");
        // options.addArguments("--headless"); // Uncomment to run in headless mode

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://bc-admin-v2.tech-active.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
