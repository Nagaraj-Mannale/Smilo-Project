package basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Constructor {
protected WebDriver driver;
public Constructor(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
