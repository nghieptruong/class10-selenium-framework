package base;

import drivers.DriverFactory;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setup() throws Exception {
        System.out.println("Setup executed...");
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driverManager.createDriver();
        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        System.out.println("Teardown executed...");
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null) {
            driver.quit();
        }
    }
}
