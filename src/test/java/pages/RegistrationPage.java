package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalFormComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage bannerOff(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ModalFormComponent modalformcomponent = new ModalFormComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddress = $("#currentAddress"),
            userGender = $("#genterWrapper"),
            userHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            subjectsInput = $("#subjectsInput"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput =  $("#city"),
            calendarInput = $("#dateOfBirthInput"),
            submitClick = $("#submit"),
            submitClickE = $("#closeLargeModal");


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage selectUserGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectUserHobbies(String value) {
        userHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage addUploadPictures(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage submitClickButton () {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        modalformcomponent.checkResultComponents(key,value);

        return this;
    }

    public RegistrationPage submitClickExit () {
        submitClickE.click();

        return this;
    }

    public RegistrationPage submitClickButtonisDisplayed () {
        submitClick.isDisplayed();

        return this;
    }
}
