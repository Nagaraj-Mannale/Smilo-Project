package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;
import io.cucumber.java.en.*;

public class StepCategory {

    private String categoryName = "Auto Category";
    private String modifyCategoryName = "Category";

    @When("the Settings link is clicked, followed by the Serv&Cat tab, then Category")
    public void theLinkIsClickedFollowedByTheTabThen() {
        ClassObjects.CC.selectPageLink("Settings");
        ClassObjects.SG.clickOnSettingLink("Product & Services");
        ClassObjects.SG.selectProductAndServiceOption("Catagories");
    }

    @Then("the Category page text is validated")
    public void theCategoryPageTextIsValidated() {
        String text = ClassObjects.SG.getCatHomePageHeading();
        Assert.assertTrue(text.trim().equalsIgnoreCase("Category"), "The Category page text is not valid.");
    }

    @When("the Add Category button is clicked")
    public void theButtonIsClicked() {
        ClassObjects.SG.clickAddButton();
    }

    @Then("the user should be redirected to the Category add page")
    public void theUserShouldBeRedirectedToTheCategoryMallPage() {
        String text = ClassObjects.SG.getCatAddPageHeading();
        Assert.assertTrue(text.trim().equalsIgnoreCase("Add Category"), "The add category page text is not valid.");
    }

    @When("all the necessary data is entered for the new Category")
    public void allTheNecessaryDataIsEnteredForTheNewCategory() {
        ClassObjects.SG.enterCatOrProduOrServiceName(categoryName);
        ClassObjects.SG.selectCategoryTypeEitherProductOrService("Service");
        ClassObjects.SG.toggleSliderForStatus();
        }

    @Then("the newly added Category is verified")
    public void theNewlyAddedCategoryIsVerified() throws AWTException {
        ClassObjects.CC.searchField(categoryName);
        String text = ClassObjects.SG.getCategoryFirstRecordName();
        Assert.assertTrue(text.trim().equalsIgnoreCase(categoryName), "The category name is not valid.");
    }

    @When("a Category is selected and the Edit button is clicked")
    public void aCategoryIsSelectedAndTheEditButtonIsClicked() throws AWTException {
        ClassObjects.CC.searchField(categoryName);
        ClassObjects.CC.selectKebabOption("edit");
    }

    @When("the Category name is modified")
    public void theCategoryNameIsModifiedAndTheButtonIsClicked() {
        ClassObjects.SG.enterCatOrProduOrServiceName(modifyCategoryName);
        ClassObjects.SG.toggleSliderForStatus();
         }
    @When("clicks the Save Changes button")
    public void ClicksTheSaveChangesButton(){
        ClassObjects.SG.clickSaveChangesButton();
           }

    @Then("the modified Category name is verified")
    public void theModifiedCategoryNameIsVerified() throws AWTException {
        ClassObjects.CC.searchField(modifyCategoryName);
        String text = ClassObjects.SG.getCategoryFirstRecordName();
        String statusText = ClassObjects.SG.getCategoryFirstRecordStatus();
        Assert.assertTrue(statusText.trim().equalsIgnoreCase("Disabled"), "The status did not change.");
        Assert.assertTrue(text.trim().equalsIgnoreCase(modifyCategoryName), "The modified category name is not valid.");
    }

    @When("a Category is selected and the Delete button is clicked")
    public void aCategoryIsSelectedAndTheDeleteButtonIsClicked() throws AWTException {
        ClassObjects.CC.searchField(modifyCategoryName);
        ClassObjects.CC.selectKebabOption("delete");
        ClassObjects.CC.deletePopupHandle("yes");
    }

    @Then("the Category should no longer appear in the list")
    public void theCategoryShouldNoLongerAppearInTheList() throws AWTException {
        ClassObjects.CC.searchField(modifyCategoryName);
        Assert.assertEquals(ClassObjects.SG.getCatProdAndServicePageEmptyText().trim(),"No Records Found!");
        
    }
}
