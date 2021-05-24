package xyzbank.Tests;

import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.AddCustomerPage;
import xyzbank.Pages.CustomersPage;
import xyzbank.Pages.HomePage;
import xyzbank.Pages.ManagerPage;

import java.util.concurrent.TimeUnit;

public class DeleteCustomerTest extends BaseTest {
    @Test
    public void addDeleteCustomer() {
        HomePage home = new HomePage(driver);
        ManagerPage manager = new ManagerPage(driver);
        AddCustomerPage add = new AddCustomerPage(driver);
        CustomersPage customer = new CustomersPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.managerLogin();
        manager.addCustomerButton();
        add.newCustomer("Darth", "Vader", "Delta-7");
        manager.customersButton();
        customer.customerSearch("Darth");
        customer.deleteCustomer();
    }
}