package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;

public class Lead extends Constructor {

    public Lead(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Add Leads']")     private WebElement leadAddPageText;
    @FindBy(xpath = "//button[text()='Import']")      private WebElement btnImport;
    @FindBy(xpath = "//a[text()='Add']")              private WebElement btnAdd;            
    @FindBy(xpath = "//button[@id='convert_button']") private WebElement btnConvert;
    @FindBy(xpath = "//button[text()='Delete']")      private WebElement btnDelete;    
    @FindBy(xpath = "//a[@id='export_btn']")          private WebElement linkExport;        
    @FindBy(xpath="(//span[text()='Lead'])[2]")       private WebElement HomePageText;
    public String getLeadHomePageText() {
        return HomePageText.getText();
    }
    public String getLeadAddPageText() {
        return leadAddPageText.getText();
    }

    public void clickImportButton() {
//        btnImport.click();
//        
//        String filePath = System.getProperty("Import Lead.xlsx") + "/home/active35/Music/BodyCoat Screen Shot";
//
//        // Create a File object
//        File file = new File(filePath);
//
//        try {
//            // Create a Scanner object to read the file
//            Scanner scanner = new Scanner(file);
//
//            // Read and print the file content line by line
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + file.getAbsolutePath());
//            e.printStackTrace();
//        }
    }

    public void clickAddButton() {
        btnAdd.click();
    }

    public void clickConvertButton() {
        btnConvert.click();
    }

    public void clickDeleteButton() {
        btnDelete.click();
    }

    public void clickExportLink() {
        linkExport.click();
    }

    @FindBy(xpath = "//Select[@id='status']") 
    private WebElement dropStatus;

    // Additional methods for interacting with the status dropdown, if needed
}
