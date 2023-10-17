package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }


    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputType(){
        return getPasswordInput().getAttribute("type");
    }

    public String getConfirmPasswordInputType(){
        return getConfirmPasswordInput().getAttribute("type");
    }

    public WebElement getSignupButton(){return driver.findElement(By.cssSelector("button[type='submit']"));}

    public void clickOnSignupButton(){
        getSignupButton().click();
    }

    public void fillName(String name) {
        getNameInput().sendKeys(name);
    }
    public void fillEmail(String email){
        getEmailInput().sendKeys(email);
    }

    public void fillPassword(String password){
        getPasswordInput().sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword){
        getConfirmPasswordInput().sendKeys(confirmPassword);
    }

    public void signUp(String name, String email, String password, String confirmPassword){
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        clickOnSignupButton();
    }


}
