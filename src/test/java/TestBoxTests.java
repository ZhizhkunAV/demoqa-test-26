import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest(){

            open("https://demoqa.com/automation-practice-form");



        //Name1, Name2, Email, Mobile, Current Address, Subjects
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov2904.I@list.ru");
        $("#userNumber").setValue("89000000001");
        $("#currentAddress").setValue("Country, City, Street, House №1");
        $("#dateOfBirthInput").setValue("MoreSubjects");


        //Gender
        $(byText("Male")).click();


        //$("#hobbies-checkbox-2").click(""); //Hobbies


        $("#uploadPicture").uploadFromClasspath("test.jpg"); //Picture

        //$("#").click(); //State and City1
        //$("#").click(); //State and Cit2

        $("#submit").click(); //submit


        $("#subjectsInput").shouldHave(Condition.text(""));
    }

}