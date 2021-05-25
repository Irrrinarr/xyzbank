package xyzbank.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.CustomerPersonalPage;
import xyzbank.Pages.HomePage;

import java.util.concurrent.TimeUnit;

public class DepositNgtvTest extends BaseTest{
    @Test
    public void addDepositNegative() {
        HomePage home = new HomePage(driver);
        CustomerPersonalPage customer = new CustomerPersonalPage(driver);
        String expectedMessage = "Please fill out this field.";
        String amountToDeposit = ".//input[@ng-model='amount']";

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();
        customer.addDeposit();
        customer.submitDeposit();

        String actualMessage = driver.findElement(By.xpath(amountToDeposit)).getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}