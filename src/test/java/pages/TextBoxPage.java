package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage bannOff(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitClick = $("#submit");

    public TextBoxPage inputUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage inputUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage inputCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage inputPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage inputSubmitClick() {
        submitClick.click();

        return this;
    }
    public TextBoxPage checkResult(String key, String value) {
        $(".text-field-container").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}