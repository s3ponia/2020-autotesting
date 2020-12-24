package serenity;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import serenity.pages.FeedPage;
import serenity.pages.LoginPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class BaseSteps {
    protected static final String login = "TechoBot7";
    protected static final String password = "TechnoPolis19";
    @Managed(uniqueSession = true)
    WebDriver driver;
    String actor;

    @Step("#actor open login page")
    public void open() {
        loginPage().open();
    }

    @Step("#actor logins")
    public void login() {
        loginPage().open();
        loginPage().login(login, password);
    }

    protected LoginPage loginPage() {
        return getPages().get(LoginPage.class);
    }

    protected FeedPage feedPage() {
        return getPages().get(FeedPage.class);
    }
}
