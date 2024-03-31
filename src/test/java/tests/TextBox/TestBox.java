package tests.TextBox;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.Registration.ActionsInTests;


public class TestBox extends ActionsInTests {
    TextBoxPage textboxpage = new TextBoxPage();

    @Test
    void testBox(){
        textboxpage.openPage()
                .bannOff()
                .inputUserName("Ivanov Ivan Ivanovich")
                .inputUserEmail("sdf@list.ru")
                .inputCurrentAddress("Current Best Address")
                .inputPermanentAddress("Permanent Address")
                .inputSubmitClick();

        textboxpage.checkResult("Name:", "Ivanov Ivan Ivanovich")
                .checkResult("Email:", "sdf@list.ru")
                .checkResult("Current Address :", "Current Best Address")
                .checkResult("Permananet Address :", "Permanent Address");
    }
}