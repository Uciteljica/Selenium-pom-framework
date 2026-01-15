package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By button = By.cssSelector("button[type='submit']");

    public LogInPage (WebDriver driver) {
        super(driver);
    }

    public void LogInAction (String login, String sifra) {
        type(username, login);
        type(password, sifra);
        click(button);
    }




}
