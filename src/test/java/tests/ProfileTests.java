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

        Assert.assertTrue(profilePage.isEmailDisabled(), "Email input should be disabled");
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
    @Test(priority = 3)
    public void editsProfile() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Pera Admin";
        String phone = "+38161283223";
        String city= "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String gitHub = "https://github.com/rsvet";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);

        wait
                .withMessage("Url should be " + baseUrl + "/home!")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        navPage.clickOnProfileButton();

        wait
                .withMessage("Url should be " + baseUrl + "/profile!")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

        profilePage.fillName(name);
        profilePage.fillPhone(phone);
        profilePage.fillCity(city);
        profilePage.fillCountry(country);
        profilePage.fillTwitter(twitter);
        profilePage.fillGitHub(gitHub);
        profilePage.clickOnSaveButton();
        messagePopUpPage.waitForSuccessPopUp();

        Assert.assertTrue(messagePopUpPage.getSuccessMessageText().contains("Profile saved successfuly"),
                "Message for saving a user should be 'Profile saved successfuly'");
        Assert.assertEquals(profilePage.getValueFromEmailInput(), email,
                "Email input should have value "+email);
        Assert.assertEquals(profilePage.getValueFromNameInput(), name,
                "Name input should have value "+name);
        Assert.assertEquals(profilePage.getValueFromPhoneInput(), phone,
                "Telephone input should have value "+phone);
        Assert.assertEquals(profilePage.getValueFromCityInput(), city,
                "City input should have value "+city);
        Assert.assertEquals(profilePage.getValueFromCountryInput(), country,
                "Country input should have value "+country);
        Assert.assertEquals(profilePage.getValueFromTwitterInput(), twitter,
                "Twitter input should have value "+twitter);
        Assert.assertEquals(profilePage.getValueFromGitHubInput(), gitHub,
                "GitHub input should have value "+gitHub);

        navPage.clickOnLogoutButton();


    }
}
