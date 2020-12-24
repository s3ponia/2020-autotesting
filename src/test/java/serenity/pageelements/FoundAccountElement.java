package serenity.pageelements;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class FoundAccountElement {
    private final WebElementFacade webElementFacade;

    public FoundAccountElement(WebElementFacade webElementFacade) {
        this.webElementFacade = webElementFacade;
    }

    public String name() {
        return this.webElementFacade.find(By.className("title-link__79ad9")).getText().split(" ")[0];
    }

    public String surname() {
        return this.webElementFacade.find(By.className("title-link__79ad9")).getText().split(" ")[1];
    }
}
