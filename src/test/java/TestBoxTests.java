import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        //Для читаемости разбил по типам элементов.
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov2904.I@list.ru");
        $("#userNumber").setValue("8937799914");
        $("#currentAddress").setValue("Country, City, Street, House 1");

        $("#uploadPicture").uploadFromClasspath("png.jpg");

        $("[for=gender-radio-1]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#subjectsInput").setValue("History").pressEnter();

        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='1990']").click();
        $("[aria-label='Choose Thursday, March 15th, 1990']").click();

        $("#submit").click();

        //ассерты
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Ivanov2904.I@list.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8937799914"));
        $(".table-responsive").shouldHave(text("15 March,1990"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("png.jpg"));
        $(".table-responsive").shouldHave(text("Country, City, Street, House 1"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

        $(byText("Close")).click(); //Закрыли заполненную форму после ее открытия.
    }

}