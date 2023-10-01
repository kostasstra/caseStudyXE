package testng.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperClass {

    private static HelperClass helperClass;

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    private HelperClass() {
        WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();

    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            //driver.close();
            driver.quit();
        }

        helperClass = null;

    }

}
