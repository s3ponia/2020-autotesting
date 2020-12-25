package utils;

import org.openqa.selenium.By;
import pages.AllNotesPage;
import pages.GroupsNotesPage;
import pages.NotesPage;
import pages.PeopleNotesPage;
import pages.PhotosNotesPage;

import static com.codeborne.selenide.Selenide.$;

public class NotesPageFactory {
    private final By selected = By.className("__ac");

    public NotesPage notesPage() {
        final var selectedElement = $(selected);

        final String notesPageName = selectedElement.getText();

        return switch (notesPageName) {
            case "Все закладки" -> new AllNotesPage();
            case "Люди" -> new PeopleNotesPage();
            case "Группы" -> new GroupsNotesPage();
            case "Фотографии" -> new PhotosNotesPage();
            default -> throw new UnsupportedOperationException("");
        };
    }
}
