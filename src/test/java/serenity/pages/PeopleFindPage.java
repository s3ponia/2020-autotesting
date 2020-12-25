package serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import serenity.pageelements.FoundAccountElement;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleFindPage extends PageObject {

    public PeopleFindPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "row__px8cs")
    List<WebElementFacade> foundPeople;

    public List<FoundAccountElement> found() {
        return foundPeople.stream().map(FoundAccountElement::new).collect(Collectors.toList());
    }
}
