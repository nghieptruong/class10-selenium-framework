package pages.dialog;

import drivers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonDialog {

    private WebDriver driver;

    private By byLblMsgText = By.id("swal2-title");

    public CommonDialog(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lblMsgText = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblMsgText));
        return lblMsgText.getText();
    }

    public void waitDialogDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblMsgText));
    }
}
