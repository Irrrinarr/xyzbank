package xyzbank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import xyzbank.Helpers.ParentPage;

public class OpenAccountPage extends ParentPage {
    @FindBy(css = "#userSelect")
    private WebElement selectCustomer;
    @FindBy(xpath = ".//select[@name='currency']")
    private WebElement selectCurrency;
    @FindBy(xpath = ".//button[contains(text(),'Process')]")
    private WebElement processBttn;
    @FindBy(xpath = ".//option[contains(text(),'Harry Potter')]")
    private WebElement customerName;
    @FindBy(xpath = ".//option[@value='Dollar']")
    private WebElement currencyOption;

    public OpenAccountPage(WebDriver driver){
        super(driver);
    }
    public void selectCustomer() {
        selectCustomer.click();
    }
    public void customerName() {
        customerName.click();
    }
    public void currencyOption() {
        selectCurrency.click();
    }
    public void selectCurrency() {
        currencyOption.click();
    }
    public void processButton() {
        processBttn.click();
    }
}