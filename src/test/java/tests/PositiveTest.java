package tests;

import diploma.utils.JdbcConnector;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveTest extends BaseTestClass {

    @Test
    @Description("Положительный сценарий заказа через дебетовую карту с проверкой статуса в БД")
    void testCanBuyWithValidDataDebitCardCheckStatusInDB() {
        mainPage
                .clickBuyButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .submitButtonLoaderIsVisible()
                .notificationOkIsVisible();
        String status = JdbcConnector.getLastDebitStatusFromDB();
        Assertions.assertEquals(status, APPROVED_STATUS);
    }

    @Test
    @Description("Положительный сценарий заказа через кредитную карту с проверкой статуса в БД")
    void testCanBuyWithValidDataCreditCardCheckStatusInDB() {
        mainPage
                .clickCreditBuyButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .submitButtonLoaderIsVisible()
                .notificationOkIsVisible();
        String status = JdbcConnector.getLastCreditStatusFromDB();
        Assertions.assertEquals(status, APPROVED_STATUS);
    }

    @Test
    @Description("Положительный сценарий заказа через дебетовую карту с проверкой суммы в БД")
    void testCanBuyWithValidDataDebitCardCheckAmountInDB() {
        mainPage
                .clickBuyButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .submitButtonLoaderIsVisible()
                .notificationOkIsVisible();
        String status = JdbcConnector.getLastAmountFromDB();
        Assertions.assertEquals(status, "45000");
    }

}