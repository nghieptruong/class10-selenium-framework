package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends CommonPage {

    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtFullName = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterAccount(String account) {
        sendKeys(byTxtAccount, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPassword, password);
    }

    public void enterConfirmPassword(String password) {
        sendKeys(byTxtConfirmPassword, password);
    }

    public void enterFullName(String fullName) {
        sendKeys(byTxtFullName, fullName);
    }

    public void enterEmail(String email) {
        sendKeys(byTxtEmail, email);
    }

    public void clickRegister() {
        click(byBtnRegister);
    }
}
