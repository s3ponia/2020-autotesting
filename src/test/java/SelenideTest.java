import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    private static final String login = "TechoBot7";
    private static final String password = "TechnoPolis19";
    private static final OkPage okPage = new OkPage(
            login, password);

    @BeforeAll
    static void init() throws InterruptedException {
        okPage.login();
    }

    @RepeatedTest(20)
    void testFeedExistance() {
        open("https://ok.ru/feed");
        okPage.getFeed().shouldBe(sizeGreaterThan(0));
    }

    @Test
    void testFeedWriteNotes() throws InterruptedException {
        open("https://ok.ru/feed");
        final var noteBlock = okPage.getNoteBlockOnFeed().shouldBe(visible);
        noteBlock.click();
        final var input = okPage.getNoteInput().waitUntil(visible, 1000);
        input.click();
        input.append("Hi");
        final var button = okPage.getPostingButton().shouldBe(visible);
        button.click();
        open("https://ok.ru/feed");
        okPage.reload();
        final var feed = okPage.getFeed();
        feed.shouldBe(allMatch("All should be visible",
                a -> $(a).is(visible))).shouldBe(sizeGreaterThan(0));
        feed.shouldBe(anyMatch("Find inserted note",
                a -> $(a).$(By.xpath(".//*[@class='media-text_a']/..")).is(text("Hi"))));
    }

    @RepeatedTest(20)
    void testNavigationBarExistance() {
        open("https://ok.ru/feed");
        okPage.getNavigationalBar().shouldBe(visible);
        okPage.getNavigationalBar().$(By.className("nav-side")).shouldBe(visible);
        okPage.getNavigationalBar().$(By.className("nav-side"))
                .$$(By.className("nav-side_i")).shouldBe(sizeGreaterThan(0));
    }
}
