package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
