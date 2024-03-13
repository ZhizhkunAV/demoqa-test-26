import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

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


        //firstName, lastName, Email, Mobile, Current Address, Subjects - однотипные элменты с заполненем поля текстом.
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov2904.I@list.ru");
        $("#userNumber").setValue("89377999147");
        $("#currentAddress").setValue("Country, City, Street, House №1");

        $("#uploadPicture").uploadFile(new File("src/png.jpg")); //Picture

        //Выбор пола.
        $("[for=\"gender-radio-1\"]").click();


        //Выбор года.
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("1990")).click();


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("September")).click();
        //Выбор месяца.







        $("#submit").click(); //submit


        $("#subjectsInput").shouldHave(text("Ivan"));
    }

}