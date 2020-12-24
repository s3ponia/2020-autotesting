package serentity.ok.friendfind;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import serentity.ok.friendfind.steps.FriendFindSteps;

@RunWith(SerenityRunner.class)
public class FriendFindTest {
    @Steps
    FriendFindSteps friendFindSteps;

    @Test
    public void testSearching() {
        friendFindSteps.login();
        friendFindSteps.enterRequest("Andrey");
        friendFindSteps.findPeople(1, "Andrey");
    }
}
