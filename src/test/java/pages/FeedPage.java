package pages;

import elements.BookmarksNavBar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {
    private final By navBarLocator = By.className("nav-side");
    private final By moreLocator = By.className("js-nav-side-toggle");
    private final By notesLocator = By.xpath(".//*[text()='Закладки']");

    public BookmarksNavBar bookmarksNavigation() {
        if ($(navBarLocator).$(moreLocator).isEnabled()) {
            $(navBarLocator).$(moreLocator).click();
        }
        $(navBarLocator).$(notesLocator).click();
        return new BookmarksNavBar();
    }
}
