package engine.dataDriven;

import com.github.javafaker.Avatar;
import com.github.javafaker.Faker;

import java.util.Date;

public class FakerData {
    private static FakerData fakerInstance;
    private static final Faker faker = new Faker();

    private FakerData() {
        // Private constructor to prevent instantiation
    }

    public static FakerData getInstance() {
        if (fakerInstance == null) {
            fakerInstance = new FakerData();
        }
        return fakerInstance;
    }

    public static Faker getJavaFaker() {
        return faker;
    }

    public String getTextLimit(int numberOfChars) {
        return faker.lorem().fixedString(numberOfChars);
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        if (includeSpecial) {
            char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
            for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(password);
        } else {
            return faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit);
        }
    }

    public String getNumberLimit(int limit) {
        return faker.phoneNumber().subscriberNumber(limit);
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getCountry() {
        return faker.address().country();
    }

    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getBuildingNumber() {
        return faker.address().buildingNumber();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getJobTitle() {
        return faker.job().title();
    }

    public String getJobField() {
        return faker.job().field();
    }

    public String getJobSeniority() {
        return faker.job().seniority();
    }

    public String getJobPosition() {
        return faker.job().position();
    }

    public String getJobKeySkills() {
        return faker.job().keySkills();
    }

    public Avatar getJobEmployer() {
        return faker.avatar();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public Date get(int minAge, int maxAge) {
        return faker.date().birthday(minAge, maxAge);
    }

    public String getJobUniversity() {
        return faker.university().name();
    }

    public String getUniversityName() {
        return faker.university().name();
    }
}