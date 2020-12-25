package pages;

import elements.Note;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;

public class AllNotesPage implements NotesPage {
    private final By peopleGroupsLocator = By.className("cardsList_li");
    private final By photosLocator = By.className("photo-sc_grid_i");

    @Override
    public Collection<Note> notes() {
        final var peoplesGroups = $$(peopleGroupsLocator).stream();
        final var photos= $$(photosLocator).stream();

        return Stream.concat(peoplesGroups, photos).map(Note::new).collect(Collectors.toList());
    }
}
