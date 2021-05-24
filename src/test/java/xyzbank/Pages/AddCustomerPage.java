package xyzbank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xyzbank.Helpers.ParentPage;
import java.util.Iterator;
import java.util.Set;

public class AddCustomerPage extends ParentPage {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@ng-model='fName']")
    private WebElement firstName;
    @FindBy(xpath = ".//input[@ng-model='lName']")
    private WebElement lastName;
    @FindBy(xpath = ".//input[@ng-model='postCd']")
    private WebElement zipCode;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitBttn;

    public void newCustomer(String first, String last, String code) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        zipCode.sendKeys(code);
        submitBttn.click();
        popUpsHandler();
    }

    public void popUpsHandler() {
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            driver.switchTo().window(ChildWindow);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }
        driver.switchTo().window(MainWindow);
    }

    public void customerFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void customerLastName(String value) {
        lastName.sendKeys(value);
    }

    public void submitNewCustomer() {
        submitBttn.click();
    }
}