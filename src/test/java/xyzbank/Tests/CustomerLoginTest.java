package xyzbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyzbank.Helpers.BaseTest;
import xyzbank.Pages.HomePage;
import java.util.concurrent.TimeUnit;

public class CustomerLoginTest extends BaseTest {
    @Test
    public void loginAsCustomer() {
        HomePage home = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        home.customerLogin();
        home.selectCust();
        home.selectCustNameToLogin();
        home.custLoginBttn();

        WebElement welcomeCustomer = driver.findElement(By.xpath(".//strong[contains(text(),' Welcome')]"));
        Assert.assertTrue(welcomeCustomer.isDisplayed());
    }
}