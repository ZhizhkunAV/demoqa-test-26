package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {


    public String userGender = getGender();
    public String userHobbies = getHobbies();
    public String userSubjects = getSubjects();
    public String userPhone = getRandomMobile();
    public String userPicture = getPicture();
    public String userState = getState();
    public String userCity = getCity();
    public String userYear = getYear();
    public String userDay = getDay();
    public String userMonth = getMonth();


    static Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmeil = faker.internet().emailAddress();
    public String userAdress = faker.address().fullAddress();


    public String getGender() {

        return faker.options().option("Male", "Female", "Other"); //ниже 2 вариатива к этому варианту.

    }

    public static String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbies);

    }

    public static String getSubjects() {
        String[] subjects = {"History", "Computer Science", "Physics", "Economics"};

        return faker.options().option(subjects);
    }

    public String getRandomMobile() {

        return faker.phoneNumber().subscriberNumber(10);

    }

    public String getPicture() {

        return faker.options().option("book.png", "hed.png", "png.jpg"); //ниже 2 вариатива к этому варианту.

    }

    public String getState() {

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public String getCity() {
        String userCity;
        switch (userState) {
            case "NCR":
                userCity = new Faker().options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                userCity = new Faker().options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                userCity = new Faker().options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                userCity = new Faker().options().option("Jaipur", "Jaiselmer");
                break;
            default:
                return null;
        }

        return userCity;
    }


    public static String getDay() {

        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public static String getMonth() {

        return faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
    }

    public static String getYear() {

        return String.valueOf(faker.number().numberBetween(1950, 2023));
    }
}
