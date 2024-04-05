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
                .setCurrentAddress(fakerdata.userAdress)
                .selectUserGender(fakerdata.userGender)
                .selectUserHobbies(fakerdata.userHobbies)
                .addUploadPictures("images/png.jpg")
                .setSubjectsInput(fakerdata.userSubjects)
                .setState("Haryana")
                .setCity("Karnal")
                .setBirthDate("22", "August", "1991")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Student Email", fakerdata.userEmeil)
                .checkResult("Gender", fakerdata.userGender)
                .checkResult("Mobile", "8937799914")
                .checkResult("Date of Birth", "22 August,1991")
                .checkResult("Subjects", fakerdata.userSubjects)
                .checkResult("Hobbies", fakerdata.userHobbies)
                .checkResult("Picture", "png.jpg")
                .checkResult("Address", fakerdata.userAdress)
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
                .selectUserGender(fakerdata.userGender)
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Gender", fakerdata.userGender)
                .setUserNumberInput("8937799914")
                .submitClickExit();
    }

    @Test
    void emptyFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .selectUserGender(fakerdata.userGender);
        //ассерты
        registrationPage.submitClickButtonisDisplayed();
    }
}
