package xyzbank.Pages;

import xyzbank.Helpers.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//button[@class='btn home']")
    private WebElement homeButton;
    @FindBy(xpath = ".//button[contains(text(),'Customer')]")
    private WebElement customerLoginBttn;
    @FindBy(css = "#userSelect")
    private WebElement selectCust;
    @FindBy(xpath = ".//option[contains(text(),'Harry')]")
    private WebElement customerName;
    @FindBy(xpath = ".//button[contains(text(),'Login')]")
    private WebElement custLoginBttn;
    @FindBy(xpath = ".//button[contains(text(),'Manager')]")
    private WebElement managerLoginBttn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void customerLogin() {
        customerLoginBttn.click();
    }

    public void selectCust() {
        selectCust.click();
    }

    public void selectCustNameToLogin() {
        customerName.click();
    }

    public void custLoginBttn() {
        custLoginBttn.click();
    }

    public void managerLogin() {
        managerLoginBttn.click();
    }
}