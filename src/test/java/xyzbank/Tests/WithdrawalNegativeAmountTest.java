package xyzbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.CustomerPersonalPage;
import xyzbank.Pages.HomePage;

import java.util.concurrent.TimeUnit;

public class WithdrawalNegativeAmountTest extends BaseTest {
    @Test
    public void negativeAmountWithdrawalNgtvTest() {
        HomePage home = new HomePage(driver);
        CustomerPersonalPage customer = new CustomerPersonalPage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();
        customer.addWithdraw();
        customer.amount("10");
        customer.submitWithdraw();

        WebElement failedTransaction = driver.findElement(By.xpath(".//span[contains(text(),'Transaction Failed.')]"));
        Assert.assertTrue(failedTransaction.isDisplayed());
    }
}