package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private static final Faker FAKER = new Faker();

    public static String generateRandomEmail() {
        return FAKER.internet().emailAddress();
    }
}