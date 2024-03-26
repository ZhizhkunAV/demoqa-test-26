package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public RegistrationPage openPage() {
    open("https://demoqa.com/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

    return this;
}

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddress = $("#currentAddress");



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

}