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
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement getEditButtonFromTableRow(int row){
        return driver.findElements(By.id("edit")).get(row-1);
    }

    public WebElement getDeleteButtonFromTableRow(int row){
        return driver.findElements(By.id("delete")).get(row-1);
    }

    public void fillSearchInput(String city){
        getSearchInput().sendKeys(city);
    }

    public void clickOnSaveButton(){
        getCreateEditDialogSaveButton().click();
    }
    public void clickOnEditButtonFromTableRow(int row){
        getEditButtonFromTableRow(row).click();
    }
    public void clickOnDeleteButtonFromTableRow(int row){
        getDeleteButtonFromTableRow(row).click();
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
    public void waitForDeleteDialog(){
        wait
                .withMessage("Delete dialog is not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-dialog .warning")));
    }
    public WebElement getDeleteButtonFromDeleteDialog(){
        return driver.findElement(By.cssSelector(".v-card__actions button.red--text:last-child"));
    }
    public void clickOnDeleteButtonInDeleteDialog(){
        getDeleteButtonFromDeleteDialog().click();
    }
    public void waitForNumberOfTableRows(int numberOfRows){
        wait
                .withMessage("Number of rows should be "+numberOfRows)
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody>tr"), numberOfRows));
    }

    public WebElement getFieldFromTableRow(int row, int column){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }

    public String getTextFromField(int row, int column){
        return getFieldFromTableRow(row,column).getText();
    }
}
