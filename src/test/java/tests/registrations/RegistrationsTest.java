package tests.registrations;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationsTest extends ActionsInTests {


    @Test
    void successFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .setUserEmailInput(fakerdata.userEmeil)
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
        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Student Email", fakerdata.userEmeil)
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
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .setUserNumberInput("8937799914")
                .selectUserGender("Male")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Gender", "Male")
                .setUserNumberInput("8937799914")
                .submitClickExit();
    }

    @Test
    void emptyFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .selectUserGender("Male");
        //ассерты
        registrationPage.submitClickButtonisDisplayed();
    }
}
