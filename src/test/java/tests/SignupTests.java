package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest{
    @Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage(){
        navPage.clickOnSignupButton();
        wait
                .withMessage("Url should be "+baseUrl+"/signup!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/signup"));
    }
    @Test(priority=2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnSignupButton();

        Assert.assertEquals(signupPage.getEmailInputType(), "email",
                "Email input type should be 'email'");
        Assert.assertEquals(signupPage.getPasswordInputType(), "password",
                "Password input type should be 'password'");
        Assert.assertEquals(signupPage.getConfirmPasswordInputType(), "password",
                "Confirm password input type should be 'password'");
    }
    @Test(priority=3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be "+baseUrl+"/signup")
                .until(ExpectedConditions.urlToBe(baseUrl+"/signup"));

        signupPage.signUp(name, email, password, confirmPassword);
        messagePopUpPage.waitForErrorPopupToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "E-mail already exists",
                "Error message should appear with text 'E-mail already exists'");

        wait
                .withMessage("Url should be "+baseUrl+"/signup")
                .until(ExpectedConditions.urlToBe(baseUrl+"/signup"));

    }
    @Test(priority=4, retryAnalyzer = RetryAnalyzer.class)
    public void signup(){
        String name = "Svetlana Radisic";
        String email = "svetlana.radisic@bootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupButton();
        wait
                .withMessage("Url should be "+baseUrl+"/signup")
                .until(ExpectedConditions.urlToBe(baseUrl+"/signup"));

        signupPage.signUp(name, email, password, confirmPassword);

        wait
                .withMessage("Url should be "+baseUrl+"/home!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/home"));

        messagePopUpPage.waitForVerifyMessageToBeVisible();

        Assert.assertTrue(messagePopUpPage.getVerifyAccountMessage().contains("IMPORTANT: Verify your account"),
                "Verify account message should contain 'IMPORTANT: Verify your account'");

        messagePopUpPage.clickOnVerifyDialogCloseButton();

        navPage.clickOnLogoutButton();

    }
}
