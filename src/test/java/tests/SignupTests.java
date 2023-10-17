package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
