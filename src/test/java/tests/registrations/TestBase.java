package tests.registrations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import utils.RandomData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TestBase {




    public RandomData fakerdata = new RandomData();

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }
}