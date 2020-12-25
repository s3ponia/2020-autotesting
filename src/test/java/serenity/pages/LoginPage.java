package serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.ok.ru")
@At(".*ok.ru")
public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@type='text']")
    WebElementFacade loginElement;

    @FindBy(xpath = ".//*[@type='password']")
    WebElementFacade passwordElement;

    @FindBy(xpath = ".//*[@type='submit']")
    WebElementFacade enterElement;

    public FeedPage login(final String login,
                          final String password) {
        if (!loginElement.isCurrentlyEnabled() || !passwordElement.isCurrentlyEnabled()) {
            return new FeedPage(getDriver());
        }
        loginElement.type(login);
        passwordElement.type(password);
        enterElement.click();

        return new FeedPage(getDriver());
    }
}
