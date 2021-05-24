package xyzbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.*;

import java.util.concurrent.TimeUnit;

public class AddBankAccountTest extends BaseTest {
    @Test
    public void addBankAccountForCustomer() {
        HomePage home = new HomePage(driver);
        ManagerPage manager = new ManagerPage(driver);
        OpenAccountPage bank = new OpenAccountPage(driver);
        AddCustomerPage add = new AddCustomerPage(driver);
        CustomersPage customers = new CustomersPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.managerLogin();
        manager.openAccountButton();
        bank.selectCustomer();
        bank.customerName();
        bank.currencyOption();
        bank.selectCurrency();
        bank.processButton();
        add.popUpsHandler();
        manager.customersButton();
        customers.customerSearch("Harry");

        WebElement searchResult = driver.findElement(By.xpath(".//span[contains(@ng-repeat,'accountNo')]"));
        Assert.assertTrue(searchResult.isDisplayed());
    }
}