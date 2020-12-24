package serentity.ok.friendfind.steps;

import net.thucydides.core.annotations.Step;
import serentity.BaseSteps;
import serentity.pages.PeopleFindPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.assertTrue;


public class FriendFindSteps extends BaseSteps {

    @Step("#actor enter in search bar {0}")
    public void enterRequest(final String request) {
        feedPage().findPeople(request);
    }

    @Step("#actor find bigger than {0}")
    public void findPeople(final int min,
                           final String name) {
        assertTrue(peopleFindPage().found().stream().filter(a -> a.name().equals(name)).count() >= min);
    }

    private PeopleFindPage peopleFindPage() {
        return getPages().get(PeopleFindPage.class);
    }
}
