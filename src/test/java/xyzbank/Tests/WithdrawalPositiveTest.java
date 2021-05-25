package xyzbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.CustomerPersonalPage;
import xyzbank.Pages.HomePage;
import java.util.concurrent.TimeUnit;

public class WithdrawalPositiveTest extends BaseTest{
    @Test
    public void addWithdrawalPositive() {
        HomePage home = new HomePage(driver);
        CustomerPersonalPage customer = new CustomerPersonalPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();
        customer.addDeposit();
        customer.amount("100");
        customer.submitDeposit();
        customer.addWithdraw();
        customer.submitWithdraw();
        customer.amount("1");
        customer.submitWithdraw();

        WebElement successfulTransaction = driver.findElement(By.xpath(".//span[contains(text(),'Transaction successful')]"));
        Assert.assertTrue(successfulTransaction.isDisplayed());
    }
}