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
}
