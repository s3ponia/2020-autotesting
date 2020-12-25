package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class BookmarksNavBar {
    private final By navBarElementsLocator = By.className("nav-side_tx");

    private void clickBookmarks(final String name) {
        final var elements = $$(navBarElementsLocator)
                .shouldHave(CollectionCondition.sizeGreaterThan(0));

        String BookmarksPageName = null;

        for (final var element :
                elements) {
            element.waitUntil(Condition.visible, 2000);
            if (name.equals(element.getText())) {
                element.click();
                return;
            }
        }

        throw new IllegalStateException("Can't find " + name);
    }

    public void clickAllBookmarks() {
        clickBookmarks("Все закладки");
    }

    public void clickPeopleBookmarks() {
        clickBookmarks("Фотографии");
    }

    public void clickGroupsBookmarks() {
        clickBookmarks("Группы");
    }

    public void clickPhotosBookmarks() {
        clickBookmarks("Фотографии");
    }
}
