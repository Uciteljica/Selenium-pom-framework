package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

protected static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }
}
