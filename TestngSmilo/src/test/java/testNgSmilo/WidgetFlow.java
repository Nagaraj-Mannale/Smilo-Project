package testNgSmilo;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		//get-started/Y14SKx4JtPwfs4J1VurWgMu3PXgVzWttUo1GTyKwPsNQCJE8j7:--Jyoti Ind
		//get-started/PUFvqWKKt4HI86UZx5wzD29aUWXgZwnUXrJlTj6oCDhlLUBhdN:--Jyoti Aus
		//get-started/E8ofS6LFsTYPMp0rlLOzFPySAj5of9K0jfXsQThyD4OsKaElvT:--Chethan Ind
		//get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI:--MangalPande Ind
		String browser="v2widget.tech-active.com/get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";
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
  		WebElement uploadSpace=driver.findElement(By.xpath("//input[@type='file']"));
  		js.executeScript("arguments[0].style.display='block';",uploadSpace);
		uploadSpace.sendKeys("/home/active35/Downloads/5Images/1st.jpeg");
	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
  		
//UploadImagePage 5 image
  	//	List<WebElement> uploadSpace=driver.findElements(By.xpath("//input[@type='file']"));
  		
//  		
//  		
//  		for(int i=0;i<uploadSpace.size();i++)
//  		{
//  
//  		
//  		//first iamge
//  		js.executeScript("arguments[0].style.display='block';",uploadSpace.get(i));
//  		uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/1st.jpeg");
//  	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//  	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//  	    ++i;
//  	    
//  	    //Second image
//    uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/2nd.jpeg");
//	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//	    ++i;
//	    
//	    //third image
//	    uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/3rd.jpeg");
//	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//	    ++i;
//	    
//	    //fourth image
//	    uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/4th.jpeg");
//	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//	    ++i;
//	    
//	    //fifth image
//	    uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/5th.jpeg");
//	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//	    ++i;
//	    
//	    //sixth image
//	    uploadSpace.get(i).sendKeys("/home/active35/Downloads/5Images/1st.jpeg");
//	    driver.findElement(By.xpath("//span[text()=' Done ']")).click();
//	    driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click();
//	    break;
//  		}
	    
  	    //ContactPage
  	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
  	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
        
        String mail="test"+RandomString.toLowerCase()+"@gmail.com";
  		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testoqt@gmail.com");
  	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
  	    driver.findElement(By.xpath("//button[@type='submit']")).click();
  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
  	    Assert.assertEquals(driver.getCurrentUrl(), "https://v2widget.tech-active.com/payment-access-report");
  	    System.out.println(driver.getCurrentUrl());
  	    
  	   
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
	
	
	
