package s_BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import s_POM.Widget;

public class Constructor {
    public Widget wt;
    protected WebDriver driver;

    public Constructor(WebDriver driver) 
    {
        this.driver = driver;
        if (this.driver != null) {
            PageFactory.initElements(driver, this);
            wt = new Widget(driver);
        } else {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
    }
}
