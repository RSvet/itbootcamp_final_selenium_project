package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        loginPage.adminLogin(email, password);
        wait
                .withMessage("Url should be " + baseUrl + "/home!")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        driver.navigate().to(baseUrl + "/profile");

        wait
                .withMessage("Url should be " + baseUrl + "/profile!")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

        profilePage.waitUntilLoadDialogIsInvisible();

        Assert.assertEquals(profilePage.getValueFromEmailInput(), "admin@admin.com",
                "Email should have value of admin@admin.com");

        navPage.clickOnLogoutButton();
    }
}
