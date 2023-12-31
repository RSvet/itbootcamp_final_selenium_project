package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getTopLocaleButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnButton() {
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("header a[href='/login']"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("header a[href='/signup']"));
    }
    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton() {
        return driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getEsButton() {
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getCnButton() {
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getFrButton() {
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getUaButton() {
        return driver.findElement(By.className("btnUA"));
    }
    public WebElement getProfileButton() {
        return driver.findElement(By.cssSelector("header a[href='/profile']"));
    }

    public WebElement getHomeButton() {
        return driver.findElement(By.cssSelector("header a[href='/home']"));
    }

    public WebElement getAboutButton() {
        return driver.findElement(By.cssSelector("header a[href='/about']"));
    }
    public void clickOnTopLocaleButton() {
        getTopLocaleButton().click();
    }
    public void clickOnEnButton() {
        getEnButton().click();
    }
    public void clickOnEsButton() {
        getEsButton().click();
    }
    public void clickOnCnButton() {
        getCnButton().click();
    }
    public void clickOnFrButton() {
        getFrButton().click();
    }
    public void clickOnUaButton() {
        getUaButton().click();
    }
    public void clickOnProfileButton() {
        getProfileButton().click();
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public void clickOnSignupButton() {
        getSignupButton().click();
    }

    public void clickOnAdminButton() {
        getAdminButton().click();
    }
    public void clickOnCitiesButton() {
        getCitiesButton().click();
    }
    public void waitForDropdownMenuVisibility() {
        wait
                .withMessage("Dropdown menu is not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-menu__content")));
    }

    public void waitForLogoutButton() {
        wait
                .withMessage("Logout button is not visible")
                .until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }

}
