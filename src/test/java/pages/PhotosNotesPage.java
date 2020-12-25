package pages;

import elements.Note;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class PhotosNotesPage implements NotesPage {
    private final By photosLocator = By.className("photo-sc_grid_i");

    @Override
    public Collection<Note> notes() {
        final var photos= $$(photosLocator).stream();

        return photos.map(Note::new).collect(Collectors.toList());
    }
}
