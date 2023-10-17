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

    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputType(){
        return getPasswordInput().getAttribute("type");
    }

    public String getConfirmPasswordInputType(){
        return getConfirmPasswordInput().getAttribute("type");
    }

}
