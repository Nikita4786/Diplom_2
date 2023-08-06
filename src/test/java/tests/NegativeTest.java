package tests;

import diploma.utils.JdbcConnector;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NegativeTest extends BaseTestClass {

    @Test
    @Description("Негативный сценарий заказа через дебетовую карту")
    void testCanNotBuyWithInvalidDataDebitCard() {
        mainPage
                .clickBuyButton()
                .fillCardNumber(INVALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .submitButtonLoaderIsVisible()
                .notificationErrorIsVisible()
                .notificationOkTextContains("Ошибка");
        String status = JdbcConnector.getLastStatusFromDB();
        Assertions.assertEquals(status, DECLINED_STATUS);
    }

    @Test
    @Description("Негативный сценарий заказа через кредитную карту")
    void testCanNotBuyWithInvalidDataCreditCard() {
        mainPage
                .clickCreditBuyButton()
                .fillCardNumber(INVALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .submitButtonLoaderIsVisible()
                .notificationErrorIsVisible()
                .notificationOkTextContains("Ошибка");
        String status = JdbcConnector.getLastStatusFromDB();
        Assertions.assertEquals(status, DECLINED_STATUS);
    }

    @Test
    @Description("Негативный сценарий заказа при пустых полях")
    void testWhileSendEmptyData() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .cardNumberErrorIsVisible()
                .cardCVVErrorIsVisible()
                .cardHolderErrorIsVisible()
                .cardMonthErrorIsVisible()
                .cardYearErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при пустом годе")
    void testWithYearEmptyData() {
        mainPage
                .clickBuyButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .cardYearErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при пустом месяце")
    void testWithInvalidMonth() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(INVALID_MONTH)
                .fillCardYear(VALID_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .cardMonthErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при неверном месяце и верном годе")
    void testWithCurrentYearAndInvalidMonth() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(LESS_THAN_CURRENT_MONTH)
                .fillCardYear(CURRENT_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .cardMonthErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при некорректном годе")
    void testWithInvalidYear() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(VALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(LESS_THAN_CURRENT_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .cardYearErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при некорректном имени")
    void testWithInvalidHolder() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(INVALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(LESS_THAN_CURRENT_YEAR)
                .fillCardCVV(VALID_CVV)
                .clickSubmitButton()
                .cardHolderErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }

    @Test
    @Description("Негативный сценарий заказа при некорректном CVV")
    void testWithInvalidCVV() {
        mainPage
                .clickBuyButton()
                .clickSubmitButton()
                .fillCardNumber(VALID_CARD_NUMBER)
                .fillCardHolder(INVALID_HOLDER)
                .fillCardMonth(VALID_MONTH)
                .fillCardYear(LESS_THAN_CURRENT_YEAR)
                .fillCardCVV(INVALID_CVV)
                .clickSubmitButton()
                .cardCVVErrorIsVisible()
                .submitButtonLoaderIsInvisible();
    }


}
