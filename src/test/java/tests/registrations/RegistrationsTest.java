package tests.registrations;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomData;

@Tag("demoqa")
public class RegistrationsTest extends TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public RandomData fakerdata = new RandomData();


    @Test
    void successFormTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .setUserEmailInput(fakerdata.userEmeil)
                .setUserNumberInput(fakerdata.userPhone)
                .setCurrentAddress(fakerdata.userAdress)
                .selectUserGender(fakerdata.userGender)
                .selectUserHobbies(fakerdata.userHobbies)
                .addUploadPictures(fakerdata.userPicture)
                .setSubjectsInput(fakerdata.userSubjects)
                .setState(fakerdata.userState)
                .setCity(fakerdata.userCity)
                .setBirthDate(fakerdata.userDay, fakerdata.userMonth, fakerdata.userYear)
                .submitClickButton();

        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Student Email", fakerdata.userEmeil)
                .checkResult("Gender", fakerdata.userGender)
                .checkResult("Mobile", fakerdata.userPhone)
                .checkResult("Date of Birth", fakerdata.userDay + " " + fakerdata.userMonth + "," + fakerdata.userYear)
                .checkResult("Subjects", fakerdata.userSubjects)
                .checkResult("Hobbies", fakerdata.userHobbies)
                .checkResult("Picture", fakerdata.userPicture)
                .checkResult("Address", fakerdata.userAdress)
                .checkResult("State and City", fakerdata.userState + " " + fakerdata.userCity)
                .submitClickExit();
    }

    @Test
    void successFormMinimumFieldTest() {

        registrationPage.openPage()
                .bannerOff()
                .setFirstName(fakerdata.firstName)
                .setLastNameInput(fakerdata.lastName)
                .setUserNumberInput(fakerdata.userPhone)
                .selectUserGender(fakerdata.userGender)
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName)
                .checkResult("Gender", fakerdata.userGender)
                .checkResult("Mobile", fakerdata.userPhone)
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
