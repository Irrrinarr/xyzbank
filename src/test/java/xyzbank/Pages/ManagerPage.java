package xyzbank.Pages;

import xyzbank.Helpers.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentPage {
    @FindBy(xpath = ".//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerBttn;
    @FindBy(xpath = ".//button[contains(text(),'Open Account')]")
    private WebElement openAccountBttn;
    @FindBy(xpath = ".//button[contains(text(),'Customers')]")
    private WebElement customersBttn;

    public ManagerPage(WebDriver driver){
        super(driver);
    }
    public void addCustomerButton() {
        addCustomerBttn.click();
    }
    public void openAccountButton() {
        openAccountBttn.click();
    }
    public void customersButton() {
        customersBttn.click();
    }
}