package testNgSmilo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginClass
{
	public static WebDriver driver;
    
    @BeforeClass()
    @DataProvider(name="url")
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
    	AssertJUnit.assertEquals("https://v2admin.tech-active.com/dashboard",driver.getCurrentUrl());
    	driver.findElement(By.xpath("//span[text()='Patients']/../span[1]")).click();
        System.out.println("Dashboard verification logic goes here...");
    }
    @Test(priority=3)
    void navigateToThePatientPageAndVerifyTheRecentAddedPatient()
    {
    	driver.findElement(By.xpath("//span[text()='Patients']/../span[1]")).click();
    	String firstRecordMail=driver.findElement(By.xpath("(//ul[@class='actions_list']/../..)[1]/td[3]")).getText();
    	AssertJUnit.assertEquals(firstRecordMail, WidgetFlow.RandomString);
    }
    
    
    
    
    
    

//    @AfterTest
//    void closeTheBrowser()
//    {
//        driver.quit(); // Close browser after completing tests
//        System.out.println("Browser closed.");
//    }

    @DataProvider(name = "urls")
    Object[][] domainData()
    {
        return new Object[][] 
        {
            {"v2admin.tech-active.com"},
          
        };
    }

}
