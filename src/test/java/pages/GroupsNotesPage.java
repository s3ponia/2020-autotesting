package pages;

import elements.Note;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class GroupsNotesPage implements NotesPage {
    private final By groupsLocator = By.className("cardsList_li");

    @Override
    public Collection<Note> notes() {
        return $$(groupsLocator).stream().map(Note::new).collect(Collectors.toList());
    }
}
