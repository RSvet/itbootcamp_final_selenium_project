package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl+"/home");
        wait
                .withMessage("Url should be "+baseUrl+"/login!")
                .until(ExpectedConditions.urlToBe(baseUrl+"/login"));
    }
}
