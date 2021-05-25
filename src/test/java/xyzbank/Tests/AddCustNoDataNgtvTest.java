package xyzbank.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.AddCustomerPage;
import xyzbank.Pages.HomePage;
import xyzbank.Pages.ManagerPage;
import java.util.concurrent.TimeUnit;

public class AddCustNoDataNgtvTest extends BaseTest{
    @Test
    public void newCustEmptyFieldsValidation() {
        HomePage home = new HomePage(driver);
        ManagerPage manager = new ManagerPage(driver);
        AddCustomerPage add = new AddCustomerPage(driver);
        String expectedMessage = "Please fill out this field.";
        String firstName = ".//input[@placeholder='First Name']";

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.managerLogin();
        manager.addCustomerButton();
        add.submitNewCustomer();

        String actualMessage = driver.findElement(By.xpath(firstName)).getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}