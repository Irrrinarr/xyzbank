package xyzbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.CustomerPersonalPage;
import xyzbank.Pages.HomePage;

import java.util.concurrent.TimeUnit;

public class TransactionsTest extends BaseTest {
    @Test
    public void transactionsPageTest() {
        HomePage home = new HomePage(driver);
        CustomerPersonalPage customer = new CustomerPersonalPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();
        customer.addDeposit();
        customer.amount("250");
        customer.submitDeposit();
        customer.transactionsMenu();

        WebElement transactionAdded = driver.findElement(By.xpath(".//td[contains(text(),'Credit')]"));
        Assert.assertTrue(transactionAdded.isDisplayed());
    }
}