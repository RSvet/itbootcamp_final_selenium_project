package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputType(){
        return getPasswordInput().getAttribute("type");
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }
    public void fillEmail(String email){
        getEmailInput().sendKeys(email);
    }

    public void fillPassword(String password){
        getPasswordInput().sendKeys(password);
    }

    public void adminLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
        clickOnLoginButton();
    }


}
