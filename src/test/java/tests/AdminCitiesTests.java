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
}
