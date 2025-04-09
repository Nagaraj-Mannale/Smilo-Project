package testNgSmilo;


import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WidgetFlow {
    public static WebDriver driver;
    public WebDriverWait wait;		
    public JavascriptExecutor js;
    public static String RandomString;
	@BeforeTest
	void launchTheBrowser()
	{
		
		String browser="v2widget.tech-active.com/get-started/n9UyYRbhUU3yBR17pXjoMKwBPirr5NPS5V4J0AFTe8r60SyXAB";
		driver=Browserlaunch.launchBrowser(browser);
		wait= new WebDriverWait(driver, Duration.ofSeconds(120));
          js=(JavascriptExecutor) driver;
        RandomString=RandomStringUtils.randomAlphanumeric(3);
		
	}
  	@Test
  	void navigateToUploadpage()
  	{
  		
		
		//GetStartPage
  		driver.findElement(By.xpath("//button[text()=' Start Now ']")).click();
  		
  		//PurposeOfVisitPage
  		driver.findElement(By.xpath("//h3[text()='General Checkup']")).click();
  		driver.findElement(By.xpath("//button[text()=' Continue ']")).click();
  		
  		//ConsentAgreementpage
  		
  		WebElement ele1=driver.findElement(By.xpath("//span[text()='Continue']"));
  		js.executeScript("arguments[0].click();",ele1);
  		
  		//Select-PreferencePage
  		driver.findElement(By.xpath("//h3[text()='Oral Health Rating']")).click();
  		driver.findElement(By.xpath("//button[text()=' Continue ']")).click();
  		
        //UploadImagePage single image
  		List<WebElement> uploadSpace=driver.findElements(By.xpath("//input[@type='file']"));
  		js.executeScript("arguments[0].style.display='block';",uploadSpace.get(0));
		uploadSpace.get(0).sendKeys("/home/active35/Downloads/5Images/1st.jpeg");
	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();

  		

//	    
//  	    //ContactPage
//  	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
//  	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
//        
//        String mail="test"+RandomString.toLowerCase()+"@gmail.com";
//  		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testoqt@gmail.com");
//  	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
//  	    driver.findElement(By.xpath("//button[@type='submit']")).click();
//  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
//  	    Assert.assertEquals(driver.getCurrentUrl(), "https://v2widget.tech-active.com/payment-access-report");
//  	    System.out.println(driver.getCurrentUrl());
  	    
  	   
//  	    driver.quit();
//  		String browser="v2pep.tech-active.com";
//  		driver=Browserlaunch.launchBrowser(browser);
//  		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("chethan@rokkun.io");
//  		WebElement element=driver.findElement(By.xpath("//input[@id='login_password']"));
//  		wait.until(ExpectedConditions.visibilityOf(element));
//  		element.sendKeys("Ind@123");
//  		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
//  		driver.findElement(By.xpath("//span[@class='sub_icon white icon-users']")).click();
//  		driver.findElement(By.xpath("//span[text()='Reports']")).click();
//  		String currentMail = driver.findElement(By.xpath("(//td[text()='Widget'])[1]/../td[3]")).getText();	
//  	    Assert.assertEquals(mail, currentMail);
  	    
  	    
  	    
  	    
//  	    //PaymentAccesReportPage Download Report via email
//  	    
//  	    WebElement element=driver.findElement(By.xpath("//button[text()=' Download Report ']"));
//  	    wait.until(ExpectedConditions.visibilityOf(element));
//  	    js.executeScript("arguments[0].scrollIntoView(true);", element);
//  	    element.click();
//  	    driver.findElement(By.xpath("//button[@type='submit']")).click();
  	}

}
	
	
	
