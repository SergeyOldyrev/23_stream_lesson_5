import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = " https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulDragAndDrop() {

        open("/drag_and_drop");
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldBe(visible);
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform"));
    }
}
