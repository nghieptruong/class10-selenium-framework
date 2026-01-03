package testcases.login;

import base.BaseTest;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.dialog.CommonDialog;
import reports.ExtentReportManager;

import java.time.Duration;

public class Login01_Verify_Login_Successfully extends BaseTest {

    @Test(description = "Verify that user can login successfully with valid account")
    public void Login01_Login_Successfully() {

        String account = "85b91d34-29a4-4905-9e5b-9bed31372d6c";
        String password = "Test123456@";
        String fullname = "John Johnson";

        WebDriver driver = DriverFactory.getDriver();

        HomePage homePage = new HomePage(driver);

        //Step 1: Go to https://demo1.cybersoft.edu.vn/
        LOG.info("Step 1: Go to https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Step 1: Go to https://demo1.cybersoft.edu.vn/");
        driver.get("https://demo1.cybersoft.edu.vn/");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NotFoundException.class);

        //Step 2: Click 'Đăng Nhap' link on the top right
        LOG.info("Step 2: Click 'Đăng Nhap' link on the top right");
        ExtentReportManager.info("Step 2: Click 'Đăng Nhap' link on the top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        //Step 3: Enter account
        //Step 4: Enter password
        //Step 5: Click 'Dang Nhap' button
        LOG.info("Step 3: Enter account");
        LOG.info("Step 4: Enter password");
        LOG.info("Step 5: Click 'Dang Nhap' button");
        ExtentReportManager.info("Step 3: Enter account");
        ExtentReportManager.info("Step 4: Enter password");
        ExtentReportManager.info("Step 5: Click 'Dang Nhap' button");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(account, "Test123456@");

        //Step 6: Verify user login successfully
        //VP1: Check 'Dang Nhap Thanh Cong' message display
        LOG.info("Step 6: Verify user login successfully");
        LOG.info("VP1: Check 'Dang Nhap Thanh Cong' message display");
        ExtentReportManager.info("Step 6: Verify user login successfully");
        ExtentReportManager.info("VP1: Check 'Dang Nhap Thanh Cong' message display");
        CommonDialog dialog = new CommonDialog(driver);
        String recordedLoginMsg = dialog.getTextMessage();
        Assert.assertEquals(recordedLoginMsg, "Đăng nhập thành công123", "Incorrect login message !");

        //VP2: Check 'Dang xuat' link display
        LOG.info("VP2: Check 'Dang xuat' link display");
        ExtentReportManager.info("VP2: Check 'Dang xuat' link display");
        Assert.assertTrue(homePage.getTopBarNavigation().isLogoutLinkDisplayed(), "Logout out link not display !");

        //VP3: Check user profile display on the top right
        LOG.info("VP3: Check user profile display on the top right");
        ExtentReportManager.info("VP3: Check user profile display on the top right");
        By byLblUserProfile = By.xpath("//a/h3[text()='" + fullname + "']");
        WebElement lblUserProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblUserProfile));
        Assert.assertTrue(lblUserProfile.isDisplayed(), "User profile not display !");
    }
}
