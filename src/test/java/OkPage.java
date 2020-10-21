import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class OkPage {
    private final String login;
    private final String password;

    public OkPage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void login() throws InterruptedException {
        open("https://ok.ru/");

        final var loginLine =
                $(By.xpath(".//*[@type='text']")).append(login);
        final var passwordLine =
                $(By.xpath(".//*[@type='password']")).append(password);
        $(By.xpath(".//*[@type='submit']")).pressEnter();
    }

    public void reload() {
        refresh();
    }

    public ElementsCollection getFeed() {
        return $$(By.xpath(".//*[@class='feed-w']"));
    }

    public SelenideElement getNoteBlockOnFeed() {
        return $(By.xpath(".//*[@id='hook_Block_PostingForm']//*[@class='pf-head_itx']"));
    }

    public SelenideElement getNoteInput() {
        return $(By.xpath(".//*[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']"));
    }

    public SelenideElement getPostingButton() {
        return $(By.className("posting_submit"));
    }

    public SelenideElement getNavigationalBar() {
        return $(By.className("navigation"));
    }
}
