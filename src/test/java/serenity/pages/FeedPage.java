package serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FeedPage extends PageObject {
    @FindBy(name = "st.query")
    WebElementFacade searchToolBarElement;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public PeopleFindPage findPeople(final String request) {
        searchToolBarElement.typeAndEnter(request);

        return new PeopleFindPage(getDriver());
    }
}
