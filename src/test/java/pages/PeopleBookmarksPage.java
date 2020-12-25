package pages;

import com.codeborne.selenide.Condition;
import elements.Bookmark;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PeopleBookmarksPage implements BookmarksPage {
    private final By peopleLocator = By.className("cardsList_li");

    @Override
    public Collection<Bookmark> bookmarks() {
        return $$(peopleLocator).stream().map(Bookmark::new).collect(Collectors.toList());
    }
}
