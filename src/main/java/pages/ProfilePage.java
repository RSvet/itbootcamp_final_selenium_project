package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public boolean isEmailDisabled(){
        return Boolean.parseBoolean(getEmailInput().getAttribute("disabled"));
    }
    public String getValueFromNameInput(){
        return getNameInput().getAttribute("value");
    }

    public String getValueFromPhoneInput(){
        return getTelephoneInput().getAttribute("value");
    }

    public String getValueFromCityInput(){
        return getCityInput().getAttribute("value");
    }

    public String getValueFromCountryInput(){
        return getCountryInput().getAttribute("value");
    }
    public String getValueFromTwitterInput(){
        return getTwitterInput().getAttribute("value");
    }
    public String getValueFromGitHubInput(){
        return getGitHubInput().getAttribute("value");
    }
    public void waitUntilLoadDialogIsInvisible(){
        wait
                .withMessage("Please wait dialog is still on the page")

                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }
    public void fillName(String name){
        getNameInput().click();
        getNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
    }
    public void fillPhone(String phone){
        getTelephoneInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),phone);
    }
    public void fillCity(String city){
        getCityInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),city);
        getCityInput().sendKeys(Keys.ENTER);
    }
    public void fillCountry(String country){
        getNameInput().click();
        getCountryInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),country);
    }
    public void fillTwitter(String twitter){
        getTwitterInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),twitter);
    }

    public void fillGitHub(String gitHub){
        getGitHubInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),gitHub);
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton(){
        getSaveButton().click();
    }
}
