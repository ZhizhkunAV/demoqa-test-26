package pages.components;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    //$("#dateOfBirthInput").click(); Прошлый вариант. Оставил для своего удобства. 1 вариант.
    //$(".react-datepicker__month-select").selectOption(month);
    // $(".react-datepicker__year-select").selectOption(year);
    //$(".react-datepicker__month").$(byText(day)).click();

    public void setDate(String day, String month, String year) {
        //       $(".react-datepicker__year-select").selectOption(year); 2 вариант.
        //       $(".react-datepicker__month-select").selectOption(month);
        //       $(".react-datepicker__month")
        //               .$$(byText(day))
        //               .find(not(cssClass("react-datepicker__day--outside-month")))
        //               .click();

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}
