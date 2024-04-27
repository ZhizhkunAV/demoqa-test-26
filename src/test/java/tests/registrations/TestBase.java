package tests.registrations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class TestBase {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@" + System.getProperty("wdHost", "selenoid.autotests.cloud") + "/wd/hub";
        Configuration.remote = System.getProperty("wdHost");
        Configuration.browser = System.getProperty("browser");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "120.0");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachment() {
        Attach.pageSource();
        Attach.screenshotAs("Last screenshot");
        Attach.addVideo();
        if (!WebDriverRunner.isFirefox()) {
            Attach.browserConsoleLogs();
        }
    }

}