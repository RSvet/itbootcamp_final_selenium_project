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
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);

        wait
                .withMessage("Url should be " + baseUrl + "/home!")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        navPage.clickOnProfileButton();

        Assert.assertEquals(profilePage.getTypeFromEmailInput(), "email",
                "Email should have type of email");

        Assert.assertTrue(profilePage.isDisabled(), "Email input should be disabled");
        System.out.println(profilePage.getEmailInput().getAttribute("disabled"));
        Assert.assertEquals(profilePage.getTypeFromNameInput(), "text",
                "Name input should have type text");
        Assert.assertEquals(profilePage.getTypeFromCityInput(), "text",
                "City input should have type text");
        Assert.assertEquals(profilePage.getTypeFromCountryInput(), "text",
                "Country input should have type text");
        Assert.assertEquals(profilePage.getTypeFromTwitterInput(), "url",
                "Twitter input should have type url");
        Assert.assertEquals(profilePage.getTypeFromGitHubInput(), "url",
                "GitHub input should have type url");
        Assert.assertEquals(profilePage.getTypeFromTelephoneInput(), "tel",
                "Telephone input should have type tel");

        navPage.clickOnLogoutButton();
    }
}
