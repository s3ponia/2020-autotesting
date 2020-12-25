package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import elements.Bookmark;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AllBookmarksPage implements BookmarksPage {
    private final By peopleGroupsLocator = By.className("cardsList_li");
    private final By photosLocator = By.className("photo-sc_grid_i");

    @Override
    public Collection<Bookmark> bookmarks() {
        final var peoplesGroups = $$(peopleGroupsLocator)
                .stream();
        final var photos = $$(photosLocator)
                .stream();

        return Stream.concat(peoplesGroups, photos).map(Bookmark::new).collect(Collectors.toList());
    }
}
