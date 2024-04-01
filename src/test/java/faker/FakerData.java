package faker;

import com.github.javafaker.Faker;

public class FakerData {

    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmeil = faker.internet().emailAddress();



}
