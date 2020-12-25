package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final By loginLocator = By.xpath(".//*[@type='text']");
    private final By passwordLocator = By.xpath(".//*[@type='password']");
    private final By submitLocator = By.xpath(".//*[@type='submit']");

    public FeedPage login(final String login,
                      final String password) {
        $(loginLocator).append(login);
        $(passwordLocator).append(password);
        $(submitLocator).click();
        return new FeedPage();
    }
}
