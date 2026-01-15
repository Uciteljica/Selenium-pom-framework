package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        super(driver);
    }

    public void selectOption(String optionText) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }




}
