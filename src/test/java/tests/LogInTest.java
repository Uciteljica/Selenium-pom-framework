package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DropdownPage;
import pages.LogInPage;
import pages.SecureAreaPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogInTest extends BaseTest {

    @Test
    public void uspesanLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Klik na Form Authentication link sa homepage
        By formAuthLink = By.linkText("Form Authentication");
        WebElement formAuthElement = wait.until(ExpectedConditions.elementToBeClickable(formAuthLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formAuthElement);
        formAuthElement.click();

        // 2. Login
        LogInPage logInPage = new LogInPage(driver);
        logInPage.LogInAction("tomsmith", "SuperSecretPassword!");

        // 3. Provera da je logovanje uspelo
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        assertTrue(secureAreaPage.getFlashMessage().contains("You logged into a secure area!"));

        // 4. Odloguj se
        secureAreaPage.LogOutAction();
        assertTrue(secureAreaPage.getFlashMessage().contains("You logged out of the secure area!"));

        // 5. Vrati se na glavnu stranicu
        driver.get("https://the-internet.herokuapp.com/");

        // 6. Klik na Dropdown link
        By dropdownLink = By.linkText("Dropdown");
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(dropdownLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
        dropdownElement.click();

        // 7. Čekaj da dropdown element bude vidljiv
        By dropdownId = By.id("dropdown");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownId));

        // 8. Rad sa DropdownPage
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectOption("Option 1");

        // 9. Provera selektovane opcije
        assertEquals("Option 1", dropdownPage.getSelectedOption());
    }
}
















































































//package tests;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pages.DropdownPage;
//import pages.LogInPage;
//import pages.SecureAreaPage;
//
//import java.time.Duration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class LogInTest extends BaseTest{
//
//    @Test
//    public void uspesanLogIn () {
//        By formAuthLink = By.linkText("Form Authentication");
//        WebElement element = driver.findElement(formAuthLink);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        element.click();
//
//        LogInPage logInPage = new LogInPage(driver);
//        logInPage.LogInAction("tomsmith", "SuperSecretPassword!");
//
//        By successMessage = By.id("flash");
//        String message = driver.findElement(successMessage).getText();
//        assertTrue(message.contains("You logged into a secure area!"));
//
//        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
//        assertTrue(secureAreaPage.getFlashMessage().contains("You logged into a secure area!"));
//
//        By dropdownLink = By.linkText("Dropdown");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLink));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
//        dropdownElement.click();
//
//        DropdownPage dropdownPage = new DropdownPage(driver);
//
//        dropdownPage.selectOption("Option 1");
//        assertEquals("Option 1", dropdownPage.getSelectedOption());
//
//
//    }
//}
