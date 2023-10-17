package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheLoginPage(){
        navPage.clickOnTopLocaleButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnEnButton();
        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be "+baseUrl+"/login!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/login"));
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes() {
        navPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getEmailInputType(), "email",
                "Email input type should be 'email'");
        Assert.assertEquals(loginPage.getPasswordInputType(), "password",
                "Password input type should be 'password'");
    }
    @Test (priority=3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);

        messagePopUpPage.waitForErrorPopupToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "User does not exists",
                "Error message should appear with text 'User does not exists");

        wait
                .withMessage("Url should be "+baseUrl+"/login!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/login"));
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);

        messagePopUpPage.waitForErrorPopupToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "Wrong password",
                "Error message should appear with text 'Wrong password");

        wait
                .withMessage("Url should be "+baseUrl+"/login!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/login"));
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.adminLogin(email, password);
        wait
                .withMessage("Url should be "+baseUrl+"/home!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/home"));
    }

}
