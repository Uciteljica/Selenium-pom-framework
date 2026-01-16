package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.DropdownPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DropdownTest extends BaseTest{

        @Test
        public void izaberiOption1() {

            driver.get("https://the-internet.herokuapp.com/");

            By dropdownLink = By.linkText("Dropdown");
            WebElement link = driver.findElement(dropdownLink);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
            link.click();

            DropdownPage dropdownPage = new DropdownPage(driver);

            dropdownPage.selectOption("Option 1");
            assertEquals("Option 1", dropdownPage.getSelectedOption());

            // vezba za git commit

//            System.out.println("Git vezba");

        }
    }

