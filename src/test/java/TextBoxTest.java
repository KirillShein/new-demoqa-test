import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFromTest() {
        open("/text-box");
        $("#userName").setValue("Kirill");
        $("#userEmail").setValue("kir@mail.ru");
        $("#currentAddress").setValue("new street");
        $("#permanentAddress").setValue("old street");
        $("#submit").click();

        $("#output #name").shouldHave(text("Kirill"));
        $("#output #email").shouldHave(text("kir@mail.ru"));
        $("#output #currentAddress").shouldHave(text("new street"));
        $("#output #permanentAddress").shouldHave(text("old street"));


    }
}
