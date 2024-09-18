package pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class Orders extends Constructor
{
	public Orders(WebDriver driver) 
	{
		super(driver);
	}

//HomePage
@FindBy(xpath="//a[text()='Orders']")WebElement homePageText;
@FindBy(xpath="//td[@id='td-lead-id']/preceding-sibling::td")WebElement firstRecordMainOrderId;
@FindBy(xpath="//td[@id='td-lead-id']")WebElement firstRecordSubOrderId;
@FindBy(xpath="//td[@id='td-email']")  WebElement customerName;
@FindBy(xpath="//td[@id='td-mobile']") WebElement subTotal;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[1]")WebElement orderTotal;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[2]")WebElement orderStatus;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[3]")WebElement orderFrom;

//ViewPage
@FindBy(xpath="//a[text()='View Orders']")                WebElement txtViewPage;
@FindBy(xpath="//div[@class='card-details-edit']//a")List<WebElement> viewPagelinks;
@FindBy(xpath="//li[text()='General']")                   WebElement tabGeneral;
@FindBy(xpath="//button[text()='Update Status']") WebElement updateStatusButton;

public String getHomePageText() {
    return homePageText.getText();
}

public String getFirstRecordMainOrderId() {
    return firstRecordMainOrderId.getText();
}

public String getFirstRecordSubOrderId() {
    return firstRecordSubOrderId.getText();
}

public String getCustomerName() {
    return customerName.getText();
}

public String getSubTotal() {
    return subTotal.getText();
}

public String getOrderTotal() {
    return orderTotal.getText();
}

public String getOrderStatus() {
    return orderStatus.getText();
}

public String getOrderFrom() {
    return orderFrom.getText();
}

//View Page
public String getViewPageText() {
    return txtViewPage.getText();
}

public void clickOnViewPageLinks(String linkName) {
    for (WebElement link : viewPagelinks) {
    if(link.getText().equalsIgnoreCase(linkName)) {
    link.click(); } } }

public void clickOnGeneralTab() {
    tabGeneral.click();
}
public void clickUpdateStatusButton() {
    updateStatusButton.click();
}


}