package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends CommonPage {

    private By byTxtAccountLogin = By.id("taiKhoan");
    private By byTxtPasswordLogin = By.id("matKhau");
    private By byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
    private By byChkRemember = By.name("remember");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter value on account textbox
     * @param account
     */
    public void enterAcount(String account) {
        sendKeys(byTxtAccountLogin, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPasswordLogin, password);
    }

    public void clickLogin() {
        click(byBtnLogin);
    }

    public void login(String username, String password) {
        enterAcount(username);
        enterPassword(password);
        clickLogin();
    }

    public void clickRemember() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chkRemember = wait.until(ExpectedConditions.presenceOfElementLocated(byChkRemember));
//        WebElement chkRemember = wait.until(ExpectedConditions.visibilityOfElementLocated(byChkRemember));
        System.out.println("display = " + chkRemember.getCssValue("display"));
        System.out.println("visibility = " + chkRemember.getCssValue("visibility"));
        System.out.println("opacity = " + chkRemember.getCssValue("opacity"));
        System.out.println("width = " + chkRemember.getRect().getWidth());
        System.out.println("height = " + chkRemember.getRect().getHeight());
        System.out.println("location = " + chkRemember.getRect().getX() + "," + chkRemember.getRect().getY());
        chkRemember.click();
    }
}
