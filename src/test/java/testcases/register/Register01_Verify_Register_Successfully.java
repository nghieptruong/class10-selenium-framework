package testcases.register;

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
import pages.RegisterPage;
import pages.dialog.CommonDialog;
import java.time.Duration;
import java.util.UUID;

public class Register01_Verify_Register_Successfully extends BaseTest {

    @Test(description = "Verify that user can register successfully with valid information")
    public void Register01_Register_Successfully() {
        UUID uuid = UUID.randomUUID();

        String account = uuid.toString(); // unique
        String email = account + "@example.com"; // unique
        System.out.println(account);
        System.out.println(email);

        WebDriver driver = DriverFactory.getDriver();

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        //Step 1: Go to https://demo1.cybersoft.edu.vn/
        System.out.println("Step 1: Go to https://demo1.cybersoft.edu.vn/");
        driver.get("https://demo1.cybersoft.edu.vn/");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NotFoundException.class);

        //Step 2: Click 'Đăng Ký' link on the top right
        System.out.println("Step 2: Click 'Đăng Ký' link on the top right");
        homePage.getTopBarNavigation().navigateRegisterPage();

        //Step 3: Enter account name
        System.out.println("Step 3: Enter account name");
        registerPage.enterAccount(account);

        //Step 4: Enter password
        System.out.println("Step 4: Enter password");
        registerPage.enterPassword("Test123456@");

        //Step 5: Enter confirm password
        System.out.println("Step 5: Enter confirm password");
        registerPage.enterConfirmPassword("Test123456@");

        //Step 6: Enter full name
        System.out.println("Step 6: Enter full name");
        String fullname = "John Johnson";
        registerPage.enterFullName(fullname);

        //Step 7: Enter email
        System.out.println("Step 7: Enter email");
        registerPage.enterEmail(email);

        //Step 8: Click 'Đăng Ky' button
        System.out.println("Step 8: Click 'Đăng Ky' button");
        registerPage.clickRegister();

        //Step 9: Verify user registers successfully
        System.out.println("Step 9: Verify user registers successfully");
        //VP1: Check 'Dang Ky Thanh Cong' message display
        System.out.println("VP1: Check 'Dang Ky Thanh Cong' message display");
        CommonDialog dialog = new CommonDialog(driver);
        String recordedMsg = dialog.getTextMessage();
        Assert.assertEquals(recordedMsg, "Đăng ký thành công", "Incorrect register message !");
        dialog.waitDialogDisappear();

        //VP2: Check login successfully with new created account
        System.out.println("VP2: Check login successfully with new created account");
        //9.1. Click 'Dang Nhap' link
        registerPage.getTopBarNavigation().navigateLoginPage();

        //9.2. Enter account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterAcount(account);

        //9.3. Enter password
        loginPage.enterPassword("Test123456@");

        //9.4. Click 'Dang Nhap' button
        loginPage.clickLogin();

        //VP3: Check 'Dang Nhap Thanh Cong' message display
        String recordedLoginMsg = dialog.getTextMessage();
        Assert.assertEquals(recordedLoginMsg, "Đăng nhập thành công", "Incorrect login message !");

        //VP4: Check 'Dang xuat' link display
        By byLnkLogout = By.xpath("//a[h3[text()='Đăng xuất']]");
        WebElement lnkLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogout));
        Assert.assertTrue(lnkLogout.isDisplayed(), "Logout out link not display !");

        //VP5: Check user profile display on the top right
        By byLblUserProfile = By.xpath("//a/h3[text()='" + fullname + "']");
        WebElement lblUserProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblUserProfile));
        Assert.assertTrue(lblUserProfile.isDisplayed(), "User profile not display !");
    }
}
