package diploma.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateData {

    public static final Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateValidHolderName() {
        return generateFirstName() + " " + generateLastName();
    }

    public static String generateInvalidHolderName() {
        return generateFirstName() + "+-(";
    }

    public static String generateValidMonth(int delta) {
        return LocalDate.now()
                .plusMonths(delta)
                .format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateInvalidMonth() {
        return String.valueOf(faker.number().numberBetween(13, 99));
    }

    public static String generateValidYear(int delta) {
        return LocalDate.now()
                .plusYears(delta)
                .format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateValidCVV() {
        return faker.number().digits(3);
    }

    public static String generateInvalidCVV() {
        return faker.number().digits(1);
    }


}