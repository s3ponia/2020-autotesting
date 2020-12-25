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
            case "��� ��������" -> new AllNotesPage();
            case "����" -> new PeopleNotesPage();
            case "������" -> new GroupsNotesPage();
            case "����������" -> new PhotosNotesPage();
            default -> throw new UnsupportedOperationException("");
        };
    }
}
