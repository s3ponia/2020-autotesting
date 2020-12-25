package serenity.ok.friendfind.steps;

import net.thucydides.core.annotations.Step;
import serenity.BaseSteps;
import serenity.pages.PeopleFindPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.assertTrue;


public class FriendFindSteps extends BaseSteps {

    @Step("#actor open login page")
    public void open() {
        loginPage().open();
    }

    @Step("#actor logins")
    public void login() {
        loginPage().open();
        loginPage().login(login, password);
    }

    @Step("#actor enter in search bar {0}")
    public void enterRequest(final String request) {
        feedPage().findPeople(request);
    }

    @Step("#actor's list should be bigger than {0}")
    public void findPeople(final int min,
                           final String name) {
        assertTrue(peopleFindPage().found().stream().filter(a -> a.name().trim().equals(name)).count() >= min);
    }

    private PeopleFindPage peopleFindPage() {
        return getPages().get(PeopleFindPage.class);
    }
}
