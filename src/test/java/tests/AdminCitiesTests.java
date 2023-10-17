package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListsCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);
        navPage.clickOnAdminButton();

        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateOrEditNewCity() {
        navPage.clickOnAdminButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
        citiesPage.clickOnNewItemButton();

        citiesPage.waitForCreateEditDialog();

        Assert.assertEquals(citiesPage.getTypeOfCityNameInput(), "text",
                "City name input should be of type text");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        String city = "Novi Sad";

        navPage.clickOnAdminButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
        citiesPage.clickOnNewItemButton();

        citiesPage.waitForCreateEditDialog();
        citiesPage.fillCityNameInput(city);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitForSuccessPopUp();

        Assert.assertTrue(messagePopUpPage.getSuccessMessageText().contains("Saved successfully"),
                "Success message should contain 'Saved successfully' text");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity() {
        String city = "Novi Sad";
        String newCity = "Barcelona";

        navPage.clickOnAdminButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
        citiesPage.fillSearchInput(city);
        citiesPage.waitForNumberOfTableRows(1);

        citiesPage.clickOnEditButtonFromTableRow(1);

        citiesPage.fillCityNameInput(newCity);

        citiesPage.clickOnSaveButton();

        messagePopUpPage.waitForSuccessPopUp();

        Assert.assertTrue(messagePopUpPage.getSuccessMessageText().contains("Saved successfully"),
                "Success message should contain 'Saved successfully' text");
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity(){
        String newCity = "Barcelona";

        navPage.clickOnAdminButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));

        citiesPage.fillSearchInput(newCity);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), newCity,
                "City in the name field should be "+newCity);
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity(){
        String newCity = "Barcelona";

        navPage.clickOnAdminButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCitiesButton();
        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));

        citiesPage.fillSearchInput(newCity);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), newCity,
                "City in the name field should be "+newCity);

        citiesPage.clickOnDeleteButtonFromTableRow(1);

        citiesPage.waitForDeleteDialog();
        citiesPage.clickOnDeleteButtonInDeleteDialog();

        messagePopUpPage.waitForSuccessPopUp();

        Assert.assertTrue(messagePopUpPage.getSuccessMessageText().contains("Deleted successfully"),
                "Success message should contain 'Deleted successfully' text");
    }
}
