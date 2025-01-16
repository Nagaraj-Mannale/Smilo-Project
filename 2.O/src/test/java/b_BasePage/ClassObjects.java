package b_BasePage;

import b_pom.Analytics;
import b_pom.CommonComponents;
import b_pom.Customer;
import b_pom.Dashboard;
import b_pom.Lead;
import b_pom.LoginPage;
import b_pom.MallSetting;
import b_pom.Orders;
import b_pom.Serviceman;
import b_pom.Setting;

public class ClassObjects extends StepBaseClass 
{
    public static CommonComponents CC;
    public static LoginPage LP;
    public static Lead LD;
    public static Analytics AL;
    public static Customer CR;
    public static MallSetting MS;
    public static Orders OR;
    public static Serviceman SM;
    public static Setting SG;
    public static Dashboard DB;

    public ClassObjects() {
        // Constructor to initialize all page objects
        DB = new Dashboard(driver); 
    	CC = new CommonComponents(driver);
        LP = new LoginPage(driver);
        LD = new Lead(driver);
        AL = new Analytics(driver);
        CR = new Customer(driver);
        MS = new MallSetting(driver);
        OR = new Orders(driver);
        SM = new Serviceman(driver);
        SG=new Setting(driver);
    } 
}
