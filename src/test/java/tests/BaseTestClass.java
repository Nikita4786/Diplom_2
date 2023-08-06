package tests;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import diploma.pages.MainPage;
import diploma.utils.ConfProperties;
import diploma.utils.GenerateData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTestClass {

    SelenideDriver driver;
    MainPage mainPage;

    final String BASE_URL = ConfProperties.getPortalUrl();
    final String VALID_CARD_NUMBER = ConfProperties.getValidCardNumber();
    final String INVALID_CARD_NUMBER = ConfProperties.getInvalidCardNumber();
    final String VALID_HOLDER = GenerateData.generateValidHolderName();
    final String INVALID_HOLDER = GenerateData.generateInvalidHolderName();
    final String VALID_YEAR = GenerateData.generateValidYear();
    final String CURRENT_YEAR = GenerateData.generateCurrentYear();
    final String LESS_THAN_CURRENT_YEAR = GenerateData.generateYearLessThanCurrent();
    final String VALID_MONTH = GenerateData.generateValidMonth();
    final String INVALID_MONTH = GenerateData.generateInvalidMonth();
    final String LESS_THAN_CURRENT_MONTH = GenerateData.generateMonthLessThanCurrent();
    final String VALID_CVV = GenerateData.generateValidCVV();
    final String INVALID_CVV = GenerateData.generateInvalidCVV();
    final String APPROVED_STATUS = ConfProperties.getValidCardStatus();
    final String DECLINED_STATUS = ConfProperties.getInValidCardStatus();

    @BeforeEach
    public void setUp() {
        final SelenideConfig config = new SelenideConfig();
        driver = new SelenideDriver(config);
        driver.open(BASE_URL);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true));
    }

    @AfterAll
    static void teardownAll() {
        SelenideLogger.removeListener("allure");
    }


}
