package xyzbank.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.CustomerPersonalPage;
import xyzbank.Pages.HomePage;

import java.util.concurrent.TimeUnit;

public class WithdrawalNoAmountTest extends BaseTest {
    @Test
    public void emptyAmountWithdrawalNgtvTest() {
        HomePage home = new HomePage(driver);
        CustomerPersonalPage customer = new CustomerPersonalPage(driver);
        String expectedMessage = "Please fill out this field.";
        String amountToWithdraw = ".//input[@ng-model='amount']";

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();
        customer.addWithdraw();
        customer.submitWithdraw();

        String actualMessage = driver.findElement(By.xpath(amountToWithdraw)).getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}