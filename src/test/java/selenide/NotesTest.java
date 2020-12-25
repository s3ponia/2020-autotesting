package selenide;

import org.junit.jupiter.api.Test;
import utils.NotesPageFactory;

public class NotesTest extends BaseTest {

    private void clickNotesDeleteUnDelete() {
        final var notesPageFactory = new NotesPageFactory();
        notesPageFactory.notesPage().notes().forEach(
                n -> {
                    n.delete();
                    n.unDelete();
                }
        );
    }

    @Test
    public void checkNotesDeleteUnDelete() {
        final var notesNavBar = feedPage.notesNavigation();

        notesNavBar.clickAllNotes();
        clickNotesDeleteUnDelete();

        notesNavBar.clickGroupsNotes();
        clickNotesDeleteUnDelete();

        notesNavBar.clickPeopleNotes();
        clickNotesDeleteUnDelete();

        notesNavBar.clickPhotosNotes();
        clickNotesDeleteUnDelete();
    }
}
