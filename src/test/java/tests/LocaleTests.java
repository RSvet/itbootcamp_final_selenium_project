package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEs() {
        navPage.clickOnTopLocaleButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnEsButton();
        Assert.assertEquals(landingPage.getTextFromTitle(), "Página de aterrizaje");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEn() {
        navPage.clickOnTopLocaleButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnEnButton();
        Assert.assertEquals(landingPage.getTextFromTitle(), "Landing");
    }
}
