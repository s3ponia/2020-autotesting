package pages;

import com.codeborne.selenide.Condition;
import elements.Bookmark;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhotosBookmarksPage implements BookmarksPage {
    private final By photosLocator = By.className("photo-sc_grid_i");

    @Override
    public Collection<Bookmark> bookmarks() {
        final var photos= $$(photosLocator).stream();

        return photos.map(Bookmark::new).collect(Collectors.toList());
    }
}
