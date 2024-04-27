package tests.registrations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomData;
import java.util.Objects;
import static io.qameta.allure.Allure.step;

@Owner("ZhizhkunAV")
@DisplayName("Тест набор с тестами на форму ввода данных")
public class RegistrationsTest extends TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public RandomData fakerdata = new RandomData();

    @Severity(SeverityLevel.BLOCKER)
    @Owner("ZhizhkunAV")
    @Story("Пользователь успешно заполняет все поля формы")
    @DisplayName("Позитивный тест - успешное заполнение всех полей")
    @Tag("smoke")
    @Test
    void successFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу формы", () -> {
            registrationPage.openPage()
            .bannerOff();
        });
        step("Ввод имени - " + fakerdata.firstName, () -> {
            registrationPage.setFirstName(fakerdata.firstName);
        });
        step("Ввод фамилии - " + fakerdata.lastName, () -> {
            registrationPage.setLastNameInput(fakerdata.lastName);
        });
        step("Ввод адреса почтового ящика - " + fakerdata.userEmeil, () -> {
            registrationPage.setUserEmailInput(fakerdata.userEmeil);
        });
        step("Ввод номера телефона - " + fakerdata.userPhone, () -> {
            registrationPage.setUserNumberInput(fakerdata.userPhone);
        });
        step("Ввод действующего адреса - " + fakerdata.userAdress, () -> {
            registrationPage.setCurrentAddress(fakerdata.userAdress);
        });
        step("Выбор пола - " + fakerdata.userGender, () -> {
            registrationPage.selectUserGender(fakerdata.userGender);
        });
        step("Выбор хобби - " + fakerdata.userHobbies, () -> {
            registrationPage.selectUserHobbies(fakerdata.userHobbies);
        });

        if (Objects.equals(Configuration.browser, "chrome")) {
            step("Загрузка изображения: " + fakerdata.userPicture, () -> {
                registrationPage.addUploadPictures(fakerdata.userPicture);
            });
        }
        step("Выбор предмета(-ов) - " + fakerdata.userSubjects, () -> {
            registrationPage.setSubjectsInput(fakerdata.userSubjects);
        });
        step("Выбор региона - " + fakerdata.userState, () -> {
            registrationPage.setState(fakerdata.userState);
        });
        step("Выбор города - " + fakerdata.userCity, () -> {
            registrationPage.setCity(fakerdata.userCity);
        });

        step("Select birthday: " + fakerdata.userDay + "," + fakerdata.userMonth + " " + fakerdata.userYear, () -> {
            registrationPage.setBirthDate(fakerdata.userDay, fakerdata.userMonth, fakerdata.userYear);
        });
        step("Нажатие на кнопку завершения работы с формой", () -> {
            registrationPage.submitClickButton();
        });


        step("Проверка результата заполнения фамилии и имени", () -> {
            registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName);
        });
        step("Проверка результата заполнения электронного почтового ящика", () -> {
            registrationPage.checkResult("Student Email", fakerdata.userEmeil);
        });
        step("Проверка результата заполнения пола", () -> {
            registrationPage.checkResult("Gender", fakerdata.userGender);
        });
        step("Проверка результата заполнения телефона", () -> {
            registrationPage.checkResult("Mobile", fakerdata.userPhone);
        });
        step("Проверка результата заполнения даты дня рождения", () -> {
            registrationPage.checkResult("Date of Birth", fakerdata.userDay + " " + fakerdata.userMonth + "," + fakerdata.userYear);
        });
        step("Проверка результата заполнения предметов", () -> {
            registrationPage.checkResult("Subjects", fakerdata.userSubjects);
        });
        step("Проверка результата заполнения хобби", () -> {
            registrationPage.checkResult("Hobbies", fakerdata.userHobbies);
        });
        step("Проверка результата загрузки img", () -> {
            registrationPage.checkResult("Picture", fakerdata.userPicture);
        });
        step("Проверка результата заполнения адреса", () -> {
            registrationPage.checkResult("Address", fakerdata.userAdress);
        });
        step("Проверка результата заполнения региона и города", () -> {
            registrationPage.checkResult("State and City", fakerdata.userState + " " + fakerdata.userCity);
        });
        step("Нажать кнопку Exit", () -> {
            registrationPage.submitClickExit();;
        });
    }

    @DisplayName("Проверка формы на минимальное количество заполняемых полей")
    @Severity(SeverityLevel.NORMAL)
    @Story("Пользователь заполняет минимальное количество полей")
    @Tag("smoke")
    @Test
    void successFormMinimumFieldTest() {

        step("Открыть стартовую страницу формы", () -> {
            registrationPage.openPage()
                    .bannerOff();
        });
        step("Ввод имени - " + fakerdata.firstName, () -> {
            registrationPage.setFirstName(fakerdata.firstName);
        });
        step("Ввод фамилии - " + fakerdata.lastName, () -> {
            registrationPage.setLastNameInput(fakerdata.lastName);
        });
        step("Ввод номера телефона - " + fakerdata.userPhone, () -> {
            registrationPage.setUserNumberInput(fakerdata.userPhone);
        });
        step("Выбор пола - " + fakerdata.userGender, () -> {
            registrationPage.selectUserGender(fakerdata.userGender);
        });
        step("Нажатие на кнопку завершения работы с формой", () -> {
            registrationPage.submitClickButton();
        });

        //ассерты
        step("Проверка результата заполнения фамилии и имени", () -> {
            registrationPage.checkResult("Student Name", fakerdata.firstName + " " + fakerdata.lastName);
        });
        step("Проверка результата заполнения пола", () -> {
            registrationPage.checkResult("Gender", fakerdata.userGender);
        });
        step("Проверка результата заполнения телефона", () -> {
            registrationPage.checkResult("Mobile", fakerdata.userPhone);
        });
        step("Нажать кнопку Exit", () -> {
            registrationPage.submitClickExit();;
        });
    }

    @DisplayName("Негативный тест - не все поля заполнены: кнопка submit не доступна к нажатию")
    @Severity(SeverityLevel.MINOR)
    @Story("Пользователь не заполнил все обязательные поля")
    @Tag("negative")
    @Test
    void emptyFormTest() {

        step("Открыть стартовую страницу формы", () -> {
            registrationPage.openPage()
                    .bannerOff();
        });
        step("Ввод имени - " + fakerdata.firstName, () -> {
            registrationPage.setFirstName(fakerdata.firstName);
        });
        step("Ввод фамилии - " + fakerdata.lastName, () -> {
            registrationPage.setLastNameInput(fakerdata.lastName);
        });
        step("Выбор пола - " + fakerdata.userGender, () -> {
            registrationPage.selectUserGender(fakerdata.userGender);
        });
        step("Проверка недоступности к нажатию кнопки", () -> {
            registrationPage.submitClickButtonisDisplayed();
        });

    }
}
