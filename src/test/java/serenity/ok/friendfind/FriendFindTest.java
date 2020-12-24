package serenity.ok.friendfind;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenity.ok.friendfind.steps.FriendFindSteps;

@RunWith(SerenityRunner.class)
public class FriendFindTest {
    @Steps
    FriendFindSteps friendFindSteps;

    @Test
    public void testSearching() {
        friendFindSteps.open();
        friendFindSteps.login();
        friendFindSteps.enterRequest("Андрей");
        friendFindSteps.findPeople(1, "Андрей");
    }
}
