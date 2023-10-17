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
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCn() {
        navPage.clickOnTopLocaleButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnCnButton();
        Assert.assertEquals(landingPage.getTextFromTitle(), "首页");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFr() {
        navPage.clickOnTopLocaleButton();
        navPage.waitForDropdownMenuVisibility();
        navPage.clickOnFrButton();
        Assert.assertEquals(landingPage.getTextFromTitle(), "Page d'atterrissage");
    }
}
