package utils;

import org.openqa.selenium.By;
import pages.AllBookmarksPage;
import pages.GroupsBookmarksPage;
import pages.BookmarksPage;
import pages.PeopleBookmarksPage;
import pages.PhotosBookmarksPage;

import static com.codeborne.selenide.Selenide.$;

public class BookmarksPageFactory {
    private final By selected = By.className("__ac");

    public BookmarksPage bookmarksPage() {
        final var selectedElement = $(selected);

        final String notesPageName = selectedElement.getText();

        return switch (notesPageName) {
            case "��� ��������" -> new AllBookmarksPage();
            case "����" -> new PeopleBookmarksPage();
            case "������" -> new GroupsBookmarksPage();
            case "����������" -> new PhotosBookmarksPage();
            default -> throw new UnsupportedOperationException("");
        };
    }
}
