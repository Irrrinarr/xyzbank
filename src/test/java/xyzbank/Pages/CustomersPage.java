package xyzbank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import xyzbank.Helpers.ParentPage;

public class CustomersPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Search Customer']")
    private WebElement customerSearch;
    @FindBy(xpath = ".//button[contains(text(),'Delete')]")
    private WebElement deleteCustomerBttn;

    public CustomersPage(WebDriver driver){
        super(driver);
    }
    public void deleteCustomer() {
        deleteCustomerBttn.click();
    }
    public void customerSearch(String value) {
        customerSearch.clear();
        customerSearch.sendKeys(value);
    }
}