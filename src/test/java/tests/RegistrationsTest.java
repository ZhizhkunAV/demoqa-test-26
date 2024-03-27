package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationsTest extends BeforeTests{


    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .setUserEmailInput("Ivanov2904.I@list.ru")
                .setUserNumberInput("8937799914")
                .setCurrentAddress("Country, City, Street, House 1")
                .checkUserGender("Male")
                .checkUserHobbiesOne("Sports")
                .checkUserHobbiesTwo("Music")
                .addUploadPictures("images/png.jpg")
                .setSubjectsInput("History")
                .setState("Haryana")
                .setCity("Karnal")
                .setBirthDate("21`", "August", "1995");




        $("#submit").click();

        //ассерты
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Ivanov2904.I@list.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8937799914"));
        $(".table-responsive").shouldHave(text("21 August,1995"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("png.jpg"));
        $(".table-responsive").shouldHave(text("Country, City, Street, House 1"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

        $(byText("Close")).click();
    }
}