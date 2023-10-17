package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickOnNewItemButton(){
        getNewItemButton().click();
    }
    public WebElement getCityNameInput(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getCreateEditDialogSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public void clickOnSaveButton(){
        getCreateEditDialogSaveButton().click();
    }

    public void fillCityNameInput(String city){
        getCityNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),city);
    }

    public String getTypeOfCityNameInput(){
        return  getCityNameInput().getAttribute("type");
    }

    public void waitForCreateEditDialog(){
        wait
                .withMessage("Create/edit dialog is not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
}
