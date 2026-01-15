package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage extends BasePage{
    private By flashMessage = By.id("flash");
    private By logOutButton = By.cssSelector("a.button");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public void LogOutAction() {
        WebElement logoutBtn = driver.findElement(logOutButton);
        logoutBtn.click();
    }

    public void acceptLogoutAlert() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}
