package selenide;

import org.junit.jupiter.api.Test;
import utils.BookmarksPageFactory;

public class BookmarksTest extends BaseTest {

    private void clickBookmarksDeleteUnDelete() {
        final var BookmarksPageFactory = new BookmarksPageFactory();
        BookmarksPageFactory.bookmarksPage().bookmarks().forEach(
                n -> {
                    n.delete();
                    n.unDelete();
                }
        );
    }

    @Test
    public void addBookmarks() {

    }

    @Test
    public void checkBookmarksDeleteUnDelete() {
        final var bookmarkNavBar = feedPage.bookmarksNavigation();

        bookmarkNavBar.clickAllBookmarks();
        clickBookmarksDeleteUnDelete();

        bookmarkNavBar.clickGroupsBookmarks();
        clickBookmarksDeleteUnDelete();

        bookmarkNavBar.clickPeopleBookmarks();
        clickBookmarksDeleteUnDelete();

        bookmarkNavBar.clickPhotosBookmarks();
        clickBookmarksDeleteUnDelete();
    }
}
