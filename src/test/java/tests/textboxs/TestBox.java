package tests.textboxs;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.registrations.TestBase;


public class TestBox extends TestBase {

    public TextBoxPage textboxpage = new TextBoxPage();

    @Test
    void testBoxTest(){
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