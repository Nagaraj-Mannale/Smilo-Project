package pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orders 
{
	
@FindBy(xpath="(//button[@type='button'])")List<WebElement> iconAllKebab;
@FindBy(xpath="(//button[@type='button'])[1]/..//a") WebElement iconView;
@FindBy(xpath="//li[text()='General']/../../../../div[1]")WebElement txtViewPage;

public void viewicon(){
	iconView.click(); }

public String getext()        {
return txtViewPage.getText(); }

}
