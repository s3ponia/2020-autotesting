package pages;

import elements.Bookmark;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class GroupsBookmarksPage implements BookmarksPage {
    private final By groupsLocator = By.className("cardsList_li");

    @Override
    public Collection<Bookmark> bookmarks() {
        return $$(groupsLocator).stream().map(Bookmark::new).collect(Collectors.toList());
    }
}
