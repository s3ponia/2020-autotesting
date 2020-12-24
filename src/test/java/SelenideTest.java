import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SelenideTest {
    private static final String login = "TechoBot7";
    private static final String password = "TechnoPolis19";
    private static final OkPage okPage = new OkPage(
            login, password);

    @BeforeAll
    static void init() throws InterruptedException {
        okPage.login();
    }

    @BeforeEach
    void openFeed() {
        open("https://ok.ru/feed");
    }

    @DisplayName("Feed's existance test")
    @Test
    void testFeedExistance() {
        okPage.getFeed().shouldBe(sizeGreaterThan(0));
    }

    @DisplayName("Navigational bar's existance")
    @Test
    void testNavigationBarExistance() {
        okPage.getNavigationalBar().shouldBe(visible);
        okPage.getNavigationalBar().$(By.className("nav-side")).shouldBe(visible);
        okPage.getNavigationalBar().$(By.className("nav-side"))
                .$$(By.className("nav-side_i")).shouldBe(sizeGreaterThan(0));
    }

    @DisplayName("Nav bar click")
    @Test
    void testNavBar() {
        for (int i = 0; i < 16; i++) {
            final ElementsCollection navBar = okPage.getNavigationalBar().
                    $(By.xpath(".//div[@class='nav-side __navigation __user-main']"))
                    .$$(By.xpath("./*")).shouldBe(sizeGreaterThan(0));
            final SelenideElement section = navBar.get(i);
            section.shouldBe(visible);
            final String prevUrl = WebDriverRunner.url();
            section.click();
            final String currUrl = WebDriverRunner.url();
            if (prevUrl.equals("https://ok.ru/feed")) {
                assertEquals(currUrl, "https://ok.ru/feed");
            } else {
                assertNotEquals(currUrl, "https://ok.ru/feed");
            }
            openFeed();
        }
    }

    @AfterAll
    static void clear() {
        closeWebDriver();
    }
}
