package serenity.ok.friendfind.steps.bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import serenity.BaseSteps;
import serenity.pages.PeopleFindPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FriendFindStepsCucumber extends BaseSteps {
    String user;
    String friendName;

    @Given("{word} opens login page")
    public void open(final String userName) {
        user = userName;
        super.open();
    }

    @And("{word} logins")
    public void login(final String userName) {
        assertEquals(user, userName);
        super.login();
    }

    @When("{word} enters in search bar {word}")
    public void find(final String userName, final String findFriendName) {
        assertEquals(user, userName);
        friendName = findFriendName;
        feedPage().findPeople(findFriendName);
    }

    @Then("{word} should find at least {int} {word}")
    public void shouldHaveAtLeast(final String userName,
                                  final int min,
                                  final String findFriendName) {
        assertEquals(user, userName);
        assertEquals(friendName, findFriendName);
        assertTrue(peopleFindPage()
                .found()
                .stream()
                .filter(a -> a.name().trim().equals(findFriendName))
                .count() >= min);
    }

    private PeopleFindPage peopleFindPage() {
        return getPages().get(PeopleFindPage.class);
    }
}
