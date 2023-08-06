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

    public static String generateValidMonth() {
        return LocalDate.now()
                .plusMonths(1)
                .format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateInvalidMonth() {
        return String.valueOf(faker.number().numberBetween(13, 99));
    }

    public static String generateMonthLessThanCurrent() {
        return LocalDate.now()
                .minusMonths(1)
                .format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateValidYear() {
        return LocalDate.now()
                .plusYears(1)
                .format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateCurrentYear() {
        return LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateYearLessThanCurrent() {
        return LocalDate.now()
                .minusYears(1)
                .format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateValidCVV() {
        return faker.number().digits(3);
    }

    public static String generateInvalidCVV() {
        return faker.number().digits(1);
    }


}
