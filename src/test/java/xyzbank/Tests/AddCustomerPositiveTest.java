package xyzbank.Tests;

import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.AddCustomerPage;
import xyzbank.Pages.CustomersPage;
import xyzbank.Pages.HomePage;
import xyzbank.Pages.ManagerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddCustomerPositiveTest extends BaseTest{
    @Test
    public void addCustomerTest() {
        HomePage home = new HomePage(driver);
        ManagerPage manager = new ManagerPage(driver);
        AddCustomerPage add = new AddCustomerPage(driver);
        CustomersPage customer = new CustomersPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.managerLogin();
        manager.addCustomerButton();
        add.newCustomer("Anakin", "Skywalker", "01023");
        manager.customersButton();
        customer.customerSearch("Anakin");

        WebElement customerSearchResult = driver.findElement(By.xpath(".//td[contains(text(),'Anakin')]"));
        Assert.assertTrue(customerSearchResult.isDisplayed());
    }
}