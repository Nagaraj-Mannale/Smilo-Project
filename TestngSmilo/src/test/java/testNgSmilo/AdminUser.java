package testNgSmilo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminUser extends Browserlaunch {

    private final String expectedMail = "testuser5@gmail.com";

    @FindBy(xpath = "//a[@id='toggle_icons_line_a']") WebElement featureDisplayIcon;
    @FindBy(xpath = "//span[@class='sub_txt white']") List<WebElement> featureLinks;
    @FindBy(xpath = "//a[@class='add_button add_admin_user']") WebElement addButton;
    @FindBy(xpath = "//div[@class='iti__flag-container']/ul/li/span[2]") List<WebElement> countryCodes;
    @FindBy(xpath = "//input[@id='first_name']") WebElement firstName;
    @FindBy(xpath = "//input[@id='last_name']") WebElement lastName;
    @FindBy(xpath = "//input[@id='email']") WebElement userEmail;
    @FindBy(xpath = "//div[@class='iti__flag-container']/div") WebElement countryField;
    @FindBy(xpath = "//input[@id='phone']") WebElement userPhone;
    @FindBy(xpath = "//select[@id='admin_role']") WebElement userRole;
    @FindBy(xpath = "//input[@type='submit']") WebElement submit;
    @FindBy(xpath = "//table[@id='admin_user_table']/tbody/tr[1]/td[4]") WebElement firstRecordMail;

    @BeforeClass
    public void setup() throws InterruptedException {
        AdminLogin login = new AdminLogin();
        login.launchTheAdminBrowser("v2admin.tech-active.com");
        login.EntermailAndPassword();
        login.ExtractTheMailOtpAndPassIntoTheOtpFields();
        PageFactory.initElements(driver, this);
    }

    @Test(priority = 0)
    public void navigateToAdminUserPage() {
        CommonData.clickOnButton(featureDisplayIcon);
        CommonData.multipleLinks(featureLinks, "Admin Users");
    }

    @Test(priority = 1)
    public void createAdminUser() {
        CommonData.clickOnButton(addButton);
        CommonData.fillTheTextFieldData(firstName, "UserAdmin");
        CommonData.fillTheTextFieldData(lastName, "User");
        CommonData.fillTheTextFieldData(userEmail, expectedMail);
        CommonData.clickOnButton(countryField);
        CommonData.multipleLinks(countryCodes, "+91");
        CommonData.fillTheTextFieldData(userPhone, "1234567890");
        CommonData.select(userRole, "Super Admin");
        CommonData.clickOnButton(submit);

        String actualMail = CommonData.getTextMethod(firstRecordMail);
        CommonData.assertionMethod(actualMail, expectedMail);
    }
    
}



//@Test()
//	public void modifiedAdminUser() {
//		WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
//		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
//
//		fillTheTextFieldData(firstName, "UserAdmin");
//		fillTheTextFieldData(lastName, "UserAdmin");
//		multipleLinks(countryCode, "+61");
	



//driver.findElement(By.xpath("//a[@class='add_button add_admin_user']")).click();
//
//Filling the required data to create the Admin-user
//driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("AdminUser");
//driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("User");
//
//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Usermail);
//driver.findElement(By.xpath("//div[@class='iti__flag-container']")).click();
//multipleLinks(countryCode,"+91");
//driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
//Select sel=new Select(driver.findElement(By.xpath("//select[@id='admin_role']")));
//sel.selectByVisibleText("Super Admin");
//driver.findElement(By.xpath("//input[@type='submit']")).click();
