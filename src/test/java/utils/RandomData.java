package utils;

import com.github.javafaker.Faker;

public class RandomData {

    public String userGender = getGender();
    public String userHobbies = getHobbies();
    public String userSubjects = getSubjects();

    static Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmeil = faker.internet().emailAddress();
    public String userAdress = faker.address().fullAddress();


    public static String getGender(){
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public static String getHobbies(){
        String[] hobbies = {"Sports", "Reading", "Music"};

        return  faker.options().option(hobbies);

    }

    public static String getSubjects(){
        String[] subjects = {"History", "Computer Science", "Physics", "Economics"};

        return faker.options().option(subjects);
    }
}
