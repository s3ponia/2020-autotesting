package selenide;

import org.junit.jupiter.api.BeforeAll;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String login = "TechoBot7";
    private static final String password = "TechnoPolis19";
    protected static FeedPage feedPage = new FeedPage();

    @BeforeAll
    public static void setup() {
        open("https://ok.ru");
        feedPage = new LoginPage().login(login, password);
    }
}
