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

    public void clickOnTopLocaleButton() {
        getTopLocaleButton().click();
    }
    public void clickOnEnButton() {
        getEnButton().click();
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }
    public void clickOnLogoutButton() {
        getLogoutButton().click();
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
