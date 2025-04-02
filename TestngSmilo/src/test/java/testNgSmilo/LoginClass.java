package testNgSmilo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LoginClass 
{
	public static WebDriver driver;
    
    @BeforeTest()
    @Parameters("url")
    void launchTheBrowser(String url)
    {
         
          driver=Browserlaunch.launchBrowser(url);

    }
    

    @Test(priority = 0)
    void EntermailAndPassword()
    {
    	 
        driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("nagaraj@rokkun.io");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Ind@123");
        driver.findElement(By.xpath("//button[@id='login_submit']")).click();
        System.out.println("Logged in successfully.");
    }

    @Test(priority = 1)
    void ExtractTheMailOtpAndPassIntoTheOtpFields() throws InterruptedException
    {
    	ReadGmailOTP.fetchOTP(); 
        Thread.sleep(2000);
        String num = ReadGmailOTP.fetchOTP();  // Fetching OTP from Gmail

        List<WebElement> fields = driver.findElements(By.xpath("//input[@name='otp_number[]']"));

        for (int i = 0; i < fields.size() && i < num.length(); i++) 
        {
            fields.get(i).sendKeys(Character.toString(num.charAt(i)));
        }

        driver.findElement(By.xpath("//button[@id='otp_section_submit']")).click();
        System.out.println("OTP submitted successfully.");
    }

    @Test(priority = 2)
    void VerifyTheDashBoardPage()
    {
        System.out.println("Dashboard verification logic goes here...");
    }

    @AfterTest
    void closeTheBrowser()
    {
        driver.quit(); // Close browser after completing tests
        System.out.println("Browser closed.");
    }

//    //@DataProvider(name = "urls")
//    Object[][] domainData()
//    {
//        return new Object[][] 
//        {
//            {"//v2admin.tech-active.com"},
//            {"//practice-d1.smilo.health"},
//        };
//    }

}
