package xyzbank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import xyzbank.Helpers.ParentPage;

public class CustomerPersonalPage extends ParentPage {
    @FindBy(xpath = ".//button[contains(text(),'Transactions')]")
    private WebElement transactionsMenu;
    @FindBy(xpath = ".//button[contains(text(),'Deposit')]")
    private WebElement depositMenu;
    @FindBy(xpath = ".//button[contains(text(),'Withdrawl')]")
    private WebElement withdrawlMenu;
    @FindBy(xpath = ".//input[@placeholder='amount']")
    private WebElement transactionAmount;
    @FindBy(xpath = ".//form[@ng-submit='deposit()']//button[contains(text(),'Deposit')]")
    private WebElement depositBttn;
    @FindBy(xpath = ".//form[@ng-submit='withdrawl()']//button[contains(text(),'Withdraw')]")
    private WebElement withdrawBttn;

    public CustomerPersonalPage(WebDriver driver){
        super(driver);
    }
    public void amount(String value) {
        transactionAmount.click();
        transactionAmount.sendKeys(value);
    }
    public void addDeposit() {
        depositMenu.click();
    }
    public void submitDeposit() {
        depositBttn.click();
    }
    public void addWithdraw() {
        withdrawlMenu.click();
    }
    public void submitWithdraw() {
        withdrawBttn.click();
    }
    public void transactionsMenu() {
        transactionsMenu.click();
    }
}