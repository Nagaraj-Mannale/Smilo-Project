package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.Constructor;

public class DentalPractice extends Constructor {
	WebElement driver;

	public DentalPractice(WebDriver driver) {
		super(driver);
	}

	
	//Home page paths
	@FindBy(xpath = "//div[@class='navbar_sidebar']/ul/li/a/span[2]")
	List<WebElement> sideBar;
	@FindBy(xpath = "//h4[text()='Dental Practice']")
	WebElement pageName;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	@FindBy(xpath = "//div[@class='three-dots-div dropbtn']")
	WebElement kebabIcon;
	@FindBy(xpath = "//div[@class='dropdown-content']/a/span")
	List<WebElement> kebabIconOption;
	
	public void titleNames(String title) {
		for (WebElement page : sideBar) {
			if (page.getText().equals(title)) {
				page.click();
			}
		}
	}

	public String pageName() {
		return pageName.getText();
	}

	public void seachfield(String name) throws AWTException {
		searchField.sendKeys(name);
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}

	public void kebabIcon() {
		kebabIcon.click();
	}

	public void kebabIconOptions(String option) {
		for (WebElement options : kebabIconOption) {
			if (options.getText().equals(option)) {
				options.click();
			}
		}
	}

	
	//Add Practitioner first Page
	
	@FindBy(xpath = "//a[@class='add_button add_admin_practice']")
	WebElement addPractice;
	@FindBy(xpath = "//input[@id='practice_name']")
	WebElement practiceName;
	@FindBy(xpath="//a[@id='company_info-tab']/span[1]")
	WebElement firstPageName;
	@FindBy(xpath="//h4[text()='Add Primary Contact']")
	WebElement secondPageName;
	@FindBy(xpath = "//input[@id='license_number']")
	WebElement licenceNumber;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='website_url']")
	WebElement webSiteUrl;
	@FindBy(xpath = "//input[@id='description']")
	WebElement description;
	@FindBy(xpath = "//input[@id='address']")
	WebElement adress;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement country;
	@FindBy(xpath = "//select[@id='state_id']")
	WebElement state;
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	@FindBy(xpath = "//input[@id='bookingURL']")
	WebElement bookingAdress;
	@FindBy(xpath = "(//input[@type='checkbox']/../label)[1]")
	WebElement multipleBranch;
	@FindBy(xpath = "(//input[@type='checkbox']/../label)[2]")
	WebElement authentication;
	
    public void addPracticeBtn() {
		addPractice.click();
	}

	public void practiceName(String name) {
		practiceName.sendKeys(name);
	}

	public void licenceNumber(String number) {
		licenceNumber.sendKeys(number);
	}

	public void emailField(String Email) {
		email.sendKeys(Email);
	}

	public void websiteUrl(String weburl) {
		webSiteUrl.sendKeys(weburl);
	}

	public void description(String Description) {
		description.sendKeys(Description);
	}

	public void adress(String Adress) {
		adress.sendKeys(Adress);
	}

	public void countryAndState(String Country, String State) {
		Select sel = new Select(country);
		Select sels = new Select(state);
		sel.selectByVisibleText(Country);
		sels.selectByVisibleText(State);
	}

	public void city(String City) {
		city.sendKeys(City);
	}

	public void BookingAdress(String urladress) {
		bookingAdress.sendKeys(urladress);
	}

	public void multibranchesOrAuthentication(String name) {
		switch (name) {
		case "multibranch":
			bookingAdress.click();
			break;
		case "pepotp":
			authentication.click();
			break;
		default:
			bookingAdress.click();
			authentication.click();
			break;
		}
	}

	//Add Second page
	
	@FindBy(xpath="//input[@id='primary_first_name']")    
	WebElement firstName;
	@FindBy(xpath="//input[@id='primary_last_name']")      
	WebElement lastName;
	@FindBy(xpath="//div[@role='combobox']/..")            
	WebElement countryCodeBtn;
	@FindBy(xpath="//div[@role='combobox']/../ul/li/span") 
	List<WebElement> countryOptions;
	@FindBy(xpath="//input[@value='Save']")                
	WebElement saveButton;
	@FindBy(xpath="//input[@value='Cancel']")              
	WebElement cancelButton;
	
	public void firstName(String firstname, String lastname)
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
	}
	public void countrycode(String code)
	{
		countryCodeBtn.click();
		for(WebElement Code:countryOptions)
		{
			if(Code.getText().equals(code))
			{
				Code.click();
			}
		}
	}
	public void savebtn()
	{
		saveButton.click();
	}
	public void cancelbutton()
	{
		cancelButton.click();
	}
	
	
	//Update Practitioner
	
	@FindBy(xpath = "//div[@class='vertical_sidebar']//li/a")
	List<WebElement> settingPageOption;
	@FindBy(xpath = "//input[@class='widget_button_type']/following-sibling::label")
	List<WebElement> widgetButtons;
    @FindBy(xpath="//input[@name='ohr_flow_type']")
    List<WebElement> ohrFlow;
    @FindBy(xpath="//input[@name='cta_options[]']/following-sibling::label")
    List<WebElement> CTAOptions;
    @FindBy(xpath="(//input[@name='is_d4w'])[1]")
    WebElement d4wS;
    @FindBy(xpath="//input[@name='d4w_practice_id']")
    WebElement d4wPracticeId;
    @FindBy(xpath="(//input[@name='is_d4w'])[2]")
    WebElement d4wN;
    @FindBy(xpath="(//input[@name='is_dentally'])[1]")
    WebElement isDentallyYes;
    @FindBy(xpath="(//input[@name='dentally_access_token']")
    WebElement isDentallyToken;
    @FindBy(xpath="(//input[@name='is_dentally'])[2]")
    WebElement isDentallyNo;
    @FindBy(xpath="(//input[@name='is_core_practice'])[1]")
    WebElement corePracticeYes;
    @FindBy(xpath="(//input[@name='is_core_practice'])[2]")
    WebElement corePracticeNo;
    @FindBy(xpath="(//input[@name='is_dabur_flow'])[1]")
    WebElement isDabourYes;
    @FindBy(xpath="(//input[@name='is_dabur_flow'])[2]")
    WebElement isDabourNo;
    
    @FindBy(xpath="(//input[@name='required_img'])[1]")
    WebElement OneImage;
    @FindBy(xpath="(//input[@name='required_img'])[2]")
    WebElement ThreeImage;
    @FindBy(xpath="(//input[@name='required_img'])[3]")
    WebElement FiveImage;
    
    

	public void settingPageTabs(String tab) {
		for (WebElement Tab : settingPageOption) {
			if (Tab.getText().equalsIgnoreCase(tab)) {
				Tab.click();
			}
		}
	}

}
