package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
//import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class PomDentalPractice extends Constructor {

	private WebDriverWait wait;
	public PomDentalPractice(WebDriver driver) {
		super(driver);
		 this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	// Home page paths
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
	@FindBy(xpath = "//a[@id='toggle_icons_line_a']/span")
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
		Actions act = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOf(kebabIcon));
		act.moveToElement(kebabIcon).perform();
		ro.delay(2000);
	}

	public void kebabIconOptions(String option) {

		for (WebElement options : kebabIconOption) {
			if (options.getText().trim().equalsIgnoreCase(option)) {
				options.click();
			}
		}
	}

	// Add Practitioner first Page
	@FindBy(xpath = "//a[@class='add_button add_admin_practice']")
	WebElement addPractice;

	@FindBy(xpath = "//input[@id='practice_name']")
	WebElement practiceName;

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
		case "multibranch":bookingAdress.click();   break;
		case "pepotp"     :authentication.click();  break;
		default:bookingAdress.click();authentication.click();
			break;
		}
	}

	@FindBy(xpath = "(//div[@class='d-flex'])[1]/h4")
	WebElement companyinfoPageText;
	@FindBy(xpath = "(//div[@class='d-flex'])[1]/h4")
	WebElement contactinfoPageText;
	@FindBy(xpath = "(//div[@class='d-flex'])[1]/h4")
	WebElement settingPageText;
	
	public String FirstAndSecondpageName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Page name cannot be null");
		}
	String result;
		switch (name) {
		case "companyinfo":
			wait.until(ExpectedConditions.textToBePresentInElement(companyinfoPageText, "Company Info"));
            result=companyinfoPageText.getText().trim();
			break;
		case "contactinfo":
			wait.until(ExpectedConditions.textToBePresentInElement(contactinfoPageText, "Add Primary Contact"));
			result=contactinfoPageText.getText().trim(); 
			break;
			
		case "settings":
			wait.until(ExpectedConditions.textToBePresentInElement(settingPageText,"Settings"));
			result=settingPageText.getText().trim();	
			break;
			
		default:
			throw new IllegalArgumentException("invalid page name:" + name);
		}
		return result;
	}

	// Add Second page

	@FindBy(xpath = "//input[@id='primary_first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='primary_last_name']")
	WebElement lastName;
	@FindBy(xpath = "//div[@role='combobox']/..")
	WebElement countryCodeBtn;
	@FindBy(xpath = "//div[@role='combobox']/../ul/li/span")
	List<WebElement> countryOptions;

	public void firstName(String firstname, String lastname) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
	}

	public void countrycode(String code) {
		countryCodeBtn.click();
		for (WebElement Code : countryOptions) {
			if (Code.getText().equals(code)) {
				Code.click();
			}
		}
	}

	// Update Practitioner

	@FindBy(xpath = "//div[@class='vertical_sidebar']//li/a/span[1]")
	List<WebElement> settingPageOptions;
	@FindBy(xpath ="//input[@name='ohr_flow_type']")                        	List<WebElement> ohrFlow;
	
	public void settingPageTabs(String tab)   
	{
		for (WebElement Tab : settingPageOptions)    {
			wait.until(ExpectedConditions.visibilityOf(Tab));
			if (Tab.getText().equalsIgnoreCase(tab)) {
				Tab.click();}	}   }

	@FindBy(xpath = "//input[@class='widget_button_type']")	            List<WebElement> widgetButtons;
	@FindBy(xpath = "//input[@class='widget_button_type']/../label")	List<WebElement> widgetButtonsText;
	
	public void countSelectedButtons()
	{
		int count=0;
	 for(WebElement element:widgetButtons)
	 {
		 if(element.isSelected())
		 {
			 count++;
		 }
	 }
	 if(count<2)
	 {
		for(WebElement element:widgetButtons)
		{
			if(!element.isSelected())
			{
				element.click();
				count++;
			}
			if(count==2)
			{
			
				break;
			}
	    } 
	 }
	}
	public void uncheckTheButton(String button) {
		int index=-1;
		for (WebElement buttonText : widgetButtonsText) {
			if(buttonText.getText().trim().equalsIgnoreCase(button))
			{
				
				index++;
				break;
			}
			index++;
		}
		for(int i=0;i<widgetButtons.size();i++)
		{
			if(i==index)
			{
				if(widgetButtons.get(i).isSelected())
				{
					widgetButtons.get(i).click();
				}
				else
				{
					System.out.println("Given options are previously unselected");
				}
			}
			
		}}
		
		
		public void selectTheParticularWidgetButton(String button) {
			int index=-1;
			wait.until(ExpectedConditions.visibilityOfAllElements(widgetButtonsText));
			for (WebElement buttonText : widgetButtonsText) {
				if(buttonText.getText().trim().equalsIgnoreCase(button))
				{
			
					index++;
					break;
				}
				index++;
			}
			
			for(int i=0;i<widgetButtons.size();i++)
			{
				if(i==index)
				{
					if(!widgetButtons.get(i).isSelected())
					{
						widgetButtons.get(i).click();
					}
					else
					{
						System.out.println("Given options are previously selected");
					}	}	}	}
		public void widgetButtonsSelectedCount()
		{
			
	    	}
	   //result;
	   public Map<Integer,List<String> > countGetTextOfSelectedWidgetButtons(){
		   List<String> ButtonsName=new ArrayList<String>();
		   int countOfSelectedButtons=0;
		   wait.until(ExpectedConditions.visibilityOfAllElements(widgetButtonsText));
		for(int i=0;i<widgetButtons.size();i++)
		   {
			if(widgetButtons.get(i).isSelected())
			{
				ButtonsName.add(widgetButtonsText.get(i).getText().replace("( OHR )", "").trim());
				
				countOfSelectedButtons++;
			}
	       }
		Map<Integer,List<String>>result=new HashMap<Integer, List<String>>();
		    result.put(countOfSelectedButtons, ButtonsName);
		    return result;
		   
	    }
	   
	   public void ohrFlow(int index) {
		for (WebElement flows : ohrFlow) {
			wait.until(ExpectedConditions.visibilityOf(flows));
			int ind =ohrFlow.indexOf(flows);
			if (ind==index) {
				flows.click();
			}
		}
	}
	@FindBy(xpath ="//input[@name='cta_options[]']/following-sibling::label")	List<WebElement> CtaOptionstext;
    @FindBy(xpath="//input[@name='cta_options[]']")                             List<WebElement> CtaCheckbox;
	public void CTAToSelectAndUnselect(String option, String choice) 
	{			
		for (WebElement cta : CtaOptionstext) 
		{
			if (option.equalsIgnoreCase(cta.getText().trim())) 
			    {
				int index=CtaOptionstext.indexOf(cta);
				CtaSelectCheckBox(index,choice);			
				}
		}
	}
	public void CtaSelectCheckBox(int index, String choice)
	{
		WebElement Checkbox=CtaCheckbox.get(index);
				if(choice.equalsIgnoreCase("select") && !CtaCheckbox.get(index).isSelected())
				{
					Checkbox.click();
				}
				else if(choice.equalsIgnoreCase("unselect") && CtaCheckbox.get(index).isSelected())
				{
					Checkbox.click();
				}
			}
		

	public boolean PresenceOfCtaOptions(String option) 
	{
		for (WebElement cta : CtaOptionstext) 
		{
			if (option.equalsIgnoreCase(cta.getText().trim())) 
			{
			   return true;
			}
		}
		return false;
	}

	@FindBy(xpath = "(//input[@name='is_d4w'])[1]")
	WebElement d4wS;
	@FindBy(xpath = "//input[@name='d4w_practice_id']")
	WebElement d4wPracticeId;
	@FindBy(xpath = "(//input[@name='is_d4w'])[2]")
	WebElement d4wN;

	public boolean presenceOfD4w()
	{
		return d4wS.isDisplayed();
	
	}
	
	public void d4w(String order) {
		if (order.equalsIgnoreCase("Yes")) {
			d4wS.click();
			if (d4wS.isSelected()) {
				d4wPracticeId.sendKeys("1492");
			}
		} else if (order.equalsIgnoreCase("No")) {
			d4wN.click();
		}
	}

	@FindBy(xpath = "(//input[@name='is_dentally'])[1]")
	WebElement isDentallyYes;
	@FindBy(xpath = "(//input[@name='dentally_access_token']")
	WebElement isDentallyToken;
	@FindBy(xpath = "(//input[@name='is_dentally'])[2]")
	WebElement isDentallyNo;

	public void dentally(String order) {
		if (order.equalsIgnoreCase("Y")) {
			isDentallyYes.click();
			if (isDentallyYes.isSelected()) {
				isDentallyToken.sendKeys("");
			}
		} else if (order.equalsIgnoreCase("N")) {
			isDentallyNo.click();
		}
	}

	@FindBy(xpath = "(//input[@name='is_core_practice'])[1]")
	WebElement corePracticeYes;
	@FindBy(xpath = "(//input[@name='is_core_practice'])[2]")
	WebElement corePracticeNo;

	public void corePractice(String Order) {
		if (Order.equalsIgnoreCase("Y")) {
			corePracticeYes.click();
		} else if (Order.equalsIgnoreCase("N")) {
			corePracticeNo.click();
		}
	}

	@FindBy(xpath = "(//input[@name='is_dabur_flow'])[1]")
	WebElement isDabourYes;
	@FindBy(xpath = "(//input[@name='is_dabur_flow'])[2]")
	WebElement isDabourNo;

	public boolean presenceOfDabour()
	{
		return isDabourYes.isDisplayed();
	}
	public void dabour(String Order) {
		if (Order.equalsIgnoreCase("Y")) {
			isDabourYes.click();
		} else if (Order.equalsIgnoreCase("N")) {
			isDabourNo.click();
		}
	}

    @FindBy(xpath="//input[@name='required_img']") List<WebElement> requiredImageForOhr;
    public void SelectrequiredOhrImages(String num)
    {
    	for(WebElement element:requiredImageForOhr)
    	{
    		if(element.getAttribute("value").trim().equals(num))
    		{
    			if(!element.isSelected())
    			{
    				element.click();
    			}
    			break;
    		}
    	}
    }
    public String CountOfAdminConfigImagesForOhr()
    {
    	
    	for(WebElement element:requiredImageForOhr)
    	{
    		if(element.isSelected())
    		{
    			return element.getAttribute("value").trim();
    			
    		}
    	}
    	return "None";
    }
    
	

//Save and Cancel Buttons
	@FindBy(xpath = "//input[@id='save_practice_company_info']")
	WebElement firstpageContinueButton;
	@FindBy(xpath = "(//input[@type='submit'])[2]")
	WebElement saveButton;
	@FindBy(xpath = "(//input[@value='Cancel'])[1]")
	WebElement cancelButton;

	public void clickOnContinueOrSaveOrCancelButton(String page) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=null;
		switch (page) {
		case "continue":element=wait.until(ExpectedConditions.elementToBeClickable(firstpageContinueButton));break;
		case "save"    :element=wait.until(ExpectedConditions.elementToBeClickable(saveButton));             break;
		default        :element=wait.until(ExpectedConditions.elementToBeClickable(cancelButton));           break;
		}
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 js.executeScript("arguments[0].click();", element);
	}
	
	//Confirmation messages
	@FindBy(xpath="//div[text()='Practice contacts has been updated successfully']") WebElement updateSuccesfulmessage;
    
	public boolean successfulmessage(String method)
    {
    	boolean result = false;
    	switch(method)
    	{
    		//case "create": result=   ;break;
    	   case "modify":
    	   result = wait.until(ExpectedConditions.visibilityOf(updateSuccesfulmessage)).isDisplayed();break;
    	
    		              
    	}
    	return result;
    }
	
	    @FindBy(xpath="//input[@name='d4w_practice_id']")         WebElement d4wpracticefield;
	    public boolean presenceOfd4wfield()
	    {
	    	return d4wpracticefield.isDisplayed() && d4wpracticefield.isEnabled();
	    }
	    
	 //Validation Practice Home page
	    @FindBy(xpath="//h4[text()='Dental Practice']")           WebElement practiceHomePageText;
	    public String gettingSettingPageText()
	    {
	    	return practiceHomePageText.getText().trim();
	    }
	    
	    
	    
	//Validations
	    @FindBy(xpath="//h4[text()='Payment Details']")           WebElement paymentLabel;
		@FindBy(xpath="//label[text()='OHR Flow']")               WebElement OhrLabel;
		@FindBy(xpath="//label[text()='Configure CTA Options']")  WebElement CtaLabel;
		@FindBy(xpath="//label[text()='Is D4W?']")                WebElement isD4wLabel;
		@FindBy(xpath="//label[text()='Is Core Practice?']")      WebElement isCorePracticeLabel;
		@FindBy(xpath="//label[text()='Is Dabur?']")              WebElement isDabourLabel;
		@FindBy(xpath="//label[text()='Required Images for OHR']")WebElement requiredImagesForOhrLabel;
		@FindBy(xpath="//label[text()='Optional image for OHR']") WebElement optionalImagesForOhrLabel;
		public boolean presenceOfOhrFlow()
		{
			return isDabourLabel.isDisplayed();
		}
		public boolean presenceofd4wandCorePractice()
		{
		    return isD4wLabel.isDisplayed()&&
	           isCorePracticeLabel.isDisplayed();
		}
		public boolean presenceOfPaymentDetails()
		{
			return paymentLabel.isDisplayed();
		}
		public boolean allComponentPresence() {
        		   return OhrLabel.isDisplayed() &&
		           CtaLabel.isDisplayed() &&
		           isDabourLabel.isDisplayed() &&
		           requiredImagesForOhrLabel.isDisplayed() &&
		           optionalImagesForOhrLabel.isDisplayed();
		}
	
	  public void closetheDriver()
	  {
		  driver.quit();
	  }
	
}
