package tests.registrations;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationsTest extends ActionsInTests {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .setUserEmailInput("Ivanov2904.I@list.ru")
                .setUserNumberInput("8937799914")
                .setCurrentAddress("Country, City, Street, House 1")
                .selectUserGender("Male")
                .selectUserHobbies("Sports")
                .selectUserHobbies("Music")
                .addUploadPictures("images/png.jpg")
                .setSubjectsInput("History")
                .setState("Haryana")
                .setCity("Karnal")
                .setBirthDate("22", "August", "1991")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivanov2904.I@list.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8937799914")
                .checkResult("Date of Birth", "22 August,1991")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "png.jpg")
                .checkResult("Address", "Country, City, Street, House 1")
                .checkResult("State and City", "Haryana Karnal")
                .submitClickExit();
    }

    @Test
    void successFormMinimumFieldTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .setUserNumberInput("8937799914")
                .selectUserGender("Male")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .setUserNumberInput("8937799914")
                .submitClickExit();
    }

    @Test
    void emptyFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .selectUserGender("Male");
        //ассерты
        registrationPage.submitClickButtonisDisplayed();
    }
}