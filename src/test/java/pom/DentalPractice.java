package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class DentalPractice extends Constructor {
	
//	private WebDriverWait wait;
	public DentalPractice(WebDriver driver) {
		super(driver);
		//this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	
	//Home page paths
	@FindBy(xpath = "//div[@class='navbar_sidebar']/ul/li/a/span[2]")
	List<WebElement> sideBarText;
	@FindBy(xpath = "(//a[@href='https://v2admin.tech-active.com/admin_practice'])[1]")
	WebElement sideBarIcon;
	@FindBy(xpath = "//h4[text()='Dental Practice']")
	WebElement pageName;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	@FindBy(xpath = "//div[@class='three-dots-div dropbtn']")
	WebElement kebabIcon;
	@FindBy(xpath = "//a[@title='Edit']/../a")
	List<WebElement> kebabIconOption;
	@FindBy(xpath="//a[@id='toggle_icons_line_a']/span")
	WebElement menuIcon;
	public void titleNames(String title) {
		sideBarIcon.click();

}

	public String PractitionerHomepageName() {
		return pageName.getText();
	}
	private static Robot ro;
	public void searchfield(String name) throws AWTException {
		searchField.sendKeys(name);
		ro = new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}

	public void kebabIcon() {
		Actions act=new Actions(driver);
		act.moveToElement(kebabIcon).perform();
		ro.delay(2000);
		//kebabIcon.click();
	}

	public void kebabIconOptions(String option) {
		
		for (WebElement options : kebabIconOption) {
			if (options.getText().trim().equalsIgnoreCase(option)) {
				options.click();
			}
		}
	}

	
	//Add Practitioner first Page	
	@FindBy(xpath = "//a[@class='add_button add_admin_practice']")
	WebElement addPractice;
	
	@FindBy(xpath = "//input[@id='practice_name']")
	WebElement practiceName;
	
	@FindBy(xpath="//h4[text()='Company Info']")
	WebElement firstPageName;
	
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
    public String FirstAndSecondpageName(String name)
    {
    	if(name==null)
    	{
    		throw new IllegalArgumentException("Page name cannot be null");
    	}
      String result="";
	  switch(name)
	  {
	   case "first":result=firstPageName.getText();break;
	   case "second":result=secondPageName.getText();break;
	   default: throw new IllegalArgumentException("invalid page name:"+name);
	  }
	   return result;
    }
	
    //Add Second page
	@FindBy(xpath="//h4[text()='Add Primary Contact']")
	WebElement secondPageName;
	@FindBy(xpath="//input[@id='primary_first_name']")    
	WebElement firstName;
	@FindBy(xpath="//input[@id='primary_last_name']")      
	WebElement lastName;
	@FindBy(xpath="//div[@role='combobox']/..")            
	WebElement countryCodeBtn;
	@FindBy(xpath="//div[@role='combobox']/../ul/li/span") 
	List<WebElement> countryOptions;
	
	
	
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
	
	//Update Practitioner
	
	@FindBy(xpath = "//div[@class='vertical_sidebar']//li/a")
	List<WebElement> settingPageOption;
	@FindBy(xpath = "//input[@class='widget_button_type']/following-sibling::label")
	List<WebElement> widgetButtons;
    @FindBy(xpath="//input[@name='ohr_flow_type']")
    List<WebElement> ohrFlow;
    @FindBy(xpath="//input[@name='cta_options[]']/following-sibling::label")
    List<WebElement> CTAOptions;
    
	public void settingPageTabs(String tab) {
		for (WebElement Tab : settingPageOption) {
			if (Tab.getText().equalsIgnoreCase(tab)) {
				Tab.click();
			}
		}
	}
    public void widgetButtons(String button)
    {  	for(WebElement btns:settingPageOption)
    	{	String buttonText=btns.getText().trim();
     		if(button.contains(buttonText))
    		{
    			if(!btns.isSelected())
    			{
    			btns.click();
    		    }
    	    }
    	}
    }
    public void ohrFlow(String flow)
    {
    	for(WebElement flows:ohrFlow)
    	{
    		if(flows.getText().equalsIgnoreCase(flow))
    		{
    			flows.click();
    		}
    	}
    }
    public void CTA(String option)
    {  	for(WebElement cta:CTAOptions)
       	{
    	if(option.contains(cta.getText().trim()))
          {if(!cta.isSelected())
    	    {cta.click();}
    	  }
    	}
    }

    @FindBy(xpath="(//input[@name='is_d4w'])[1]")
    WebElement d4wS;
    @FindBy(xpath="//input[@name='d4w_practice_id']")
    WebElement d4wPracticeId;
    @FindBy(xpath="(//input[@name='is_d4w'])[2]")
    WebElement d4wN;
    
    public void d4w(String order)
     {
	   if(order.equalsIgnoreCase("Y"))
	   {
		   d4wS.click();
		   if(d4wS.isSelected())
		   {
			   d4wPracticeId.sendKeys("1492");
		   }
	   }
	   else if(order.equalsIgnoreCase("N"))
	   {
		   d4wN.click();
	   }
     }
    
    @FindBy(xpath="(//input[@name='is_dentally'])[1]")
    WebElement isDentallyYes;
    @FindBy(xpath="(//input[@name='dentally_access_token']")
    WebElement isDentallyToken;
    @FindBy(xpath="(//input[@name='is_dentally'])[2]")
    WebElement isDentallyNo;
    
    public void dentally(String order)
    {
    	if(order.equalsIgnoreCase("Y"))
    	{
    		isDentallyYes.click();
    		if(isDentallyYes.isSelected())
    		{
    			isDentallyToken.sendKeys("");
    		}
    	}
    	else if(order.equalsIgnoreCase("N"))
    	{
    		isDentallyNo.click();
    	}
    }
 
    @FindBy(xpath="(//input[@name='is_core_practice'])[1]")
    WebElement corePracticeYes;
    @FindBy(xpath="(//input[@name='is_core_practice'])[2]")
    WebElement corePracticeNo;
    
    public void corePractice(String Order)
    {
    	if(Order.equalsIgnoreCase("Y"))
    	{
    		corePracticeYes.click();
    	}
    	else if(Order.equalsIgnoreCase("N"))
    	{
    		corePracticeNo.click();
    	}
    }
    
    @FindBy(xpath="(//input[@name='is_dabur_flow'])[1]")
    WebElement isDabourYes;
    @FindBy(xpath="(//input[@name='is_dabur_flow'])[2]")
    WebElement isDabourNo;
    
    public void dabour(String Order)
    {
    	if(Order.equalsIgnoreCase("Y"))
    	{
    		isDabourYes.click();
    	}
    	else if(Order.equalsIgnoreCase("N"))
    	{
    		isDabourNo.click();
    	}
    }
    
    @FindBy(xpath="(//input[@name='required_img'])[1]")
    WebElement OneImage;
    @FindBy(xpath="(//input[@name='required_img'])[2]")
    WebElement ThreeImage;
    @FindBy(xpath="(//input[@name='required_img'])[3]")
    WebElement FiveImage;
    
    public void requiredOhrimages(String order)
    {
    	if(order.equals("1"))
    	{
    		OneImage.click();
    	}
    	else if(order.equals("3"))
    	{
    		ThreeImage.click();
    	}
    	else if(order.equals("5"))
    	{
    		FiveImage.click();
    	}
    }
    
//Save and Cancel Buttons
	@FindBy(xpath="//input[@id='save_practice_company_info']")
	WebElement firstpageContinueButton;
	@FindBy(xpath="//input[@value='Save']")                
	WebElement saveButton;
	@FindBy(xpath="(//input[@value='Cancel'])[1]")              
	WebElement cancelButton;
    public void clickOnContinueOrSaveOrCancelButton(String page)
    {
    	switch(page)
    	{
    	case "first": firstpageContinueButton.click();
    	case "second":saveButton.click();
    	case "third":saveButton.click();
    	default:cancelButton.click();
    	}
    }

}
