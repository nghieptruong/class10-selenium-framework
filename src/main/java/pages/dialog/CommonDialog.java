package pages.dialog;

import base.BasePage;
import constants.WaitTimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonDialog extends BasePage {

    private By byLblMsgText = By.id("swal2-title");

    public CommonDialog(WebDriver driver) {
        super(driver);
    }

    public String getTextMessage() {
        return getText(byLblMsgText, WaitTimeOut.MEDIUM_TIMEOUT);
    }

    public void waitDialogDisappear() {
        waitForInvisibilityOfElementLocated(byLblMsgText, WaitTimeOut.DEFAULT_TIMEOUT);
    }
}
