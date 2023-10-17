package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForErrorPopupToBeVisible(){
        wait
                .withMessage("Error popup is not presented")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.error")));
    }

    public String getErrorMessage(){
        return driver.findElement(By.cssSelector("div.error li")).getText();
    }
}
