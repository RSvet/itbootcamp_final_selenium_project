package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getTelephoneInput(){
        return driver.findElement(By.id("phone"));
    }
    public WebElement getCityInput(){
        return driver.findElement(By.id("city"));
    }

    public WebElement getCountryInput(){
        return driver.findElement(By.id("country"));
    }

    public WebElement getTwitterInput(){
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement getGitHubInput(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getTypeFromEmailInput(){
        return getEmailInput().getAttribute("type");
    }

    public String getTypeFromNameInput(){
        return getNameInput().getAttribute("type");
    }

    public String getTypeFromCityInput(){
        return getCityInput().getAttribute("type");
    }

    public String getTypeFromCountryInput(){
        return getCountryInput().getAttribute("type");
    }

    public String getTypeFromTwitterInput(){
        return getTwitterInput().getAttribute("type");
    }

    public String getTypeFromGitHubInput(){
        return getGitHubInput().getAttribute("type");
    }

    public String getTypeFromTelephoneInput(){
        return getTelephoneInput().getAttribute("type");
    }
    public String getValueFromEmailInput(){
        return getEmailInput().getAttribute("value");
    }

    public boolean isDisabled(){
        return Boolean.parseBoolean(getEmailInput().getAttribute("disabled"));
    }
    public void waitUntilLoadDialogIsInvisible(){
        wait
                .withMessage("Please wait dialog is still on the page")

                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }
}
