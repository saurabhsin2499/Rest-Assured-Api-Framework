package utils;

import net.datafaker.Faker;

import java.util.List;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomMobileNumber(int size) {

        return faker.number().digits(size);
    }

    public static String getRandomFirstName() {

        return faker.name().firstName();
    }

    public static String getRandomLastName() {

        return faker.name().lastName();
    }

    public static String getRandomFullName() {

        return faker.name().fullName();
    }

    public static String getRandomCountry() {

        return faker.country().name();
    }

    public static String getRandomCity() {

        return faker.address().city();
    }

    public static String getRandomJobRole() {
        return faker.job().position();
    }

    public static String getRandomValueFromThisArray(List<String> arr) {

        return arr.stream().findAny().get();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumberNational();
    }

    public static String getRandomTestingPhoneNumber() {
        return "2020" + faker.number().randomNumber(6,true);
    }

    public static String getRandomCountryCode() {
        return "+91";
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }




}
