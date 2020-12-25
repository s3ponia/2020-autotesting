package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class Bookmark {
    private final SelenideElement note;
    private final By starLocator = By.className("bk_star");
    private final By stubLocator = By.className("bk_stub");

    public Bookmark(final SelenideElement note) {
        this.note = note;
    }

    public void delete() {
        note.$(stubLocator).shouldNot(visible);
        note.$(starLocator)
                .should(exist)
                .click();
    }

    public void unDelete() {
        note.$(stubLocator).should(visible);
        note.$(starLocator)
                .should(exist)
                .click();
    }
}
