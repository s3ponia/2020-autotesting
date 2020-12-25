package pages;

import elements.Note;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class PeopleNotesPage implements NotesPage {
    private final By peopleLocator = By.className("cardsList_li");

    @Override
    public Collection<Note> notes() {
        return $$(peopleLocator).stream().map(Note::new).collect(Collectors.toList());
    }
}
