package tests;

import diploma.api.pojo.request.PayRequestPojo;
import diploma.api.pojo.response.PayResponsePojo;
import diploma.api.steps.PayStep;
import diploma.utils.ConfProperties;
import diploma.utils.GenerateData;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiTest {

    final String VALID_CARD_NUMBER = ConfProperties.getValidCardNumber();
    final String INVALID_CARD_NUMBER = ConfProperties.getInvalidCardNumber();
    final String VALID_HOLDER = GenerateData.generateValidHolderName();
    final String VALID_YEAR = GenerateData.generateValidYear();
    final String VALID_MONTH = GenerateData.generateValidMonth();
    final String VALID_CVV = GenerateData.generateValidCVV();
    final String INVALID_CVV = GenerateData.generateInvalidCVV();
    final String APPROVED_STATUS = ConfProperties.getValidCardStatus();
    final String DECLINED_STATUS = ConfProperties.getInValidCardStatus();

    @Test
    @Description("Позитивный сценарий заказа через дебетовую карту с проверкой тела")
    void testSendValidRequestPayReturnStatusApproved() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendPayRequest(payRequestPojo);
        Assertions.assertEquals(APPROVED_STATUS, payResponsePojo.getStatus());
    }

    @Test
    @Description("Позитивный сценарий заказа через дебетовую карту с проверкой статус-кода")
    void testSendValidRequestPayReturnStatus200() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        int statusCode = payStep.sendPayRequestReturnStatusCode(payRequestPojo);
        Assertions.assertEquals(200, statusCode);
    }

    @Test
    @Description("Негативный сценарий заказа через дебетовую карту с проверкой статус-кода")
    void testSendInvalidRequestPayReturnStatus500() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo.setMonth(VALID_MONTH);

        int statusCode = payStep.sendPayRequestReturnStatusCode(payRequestPojo);
        Assertions.assertEquals(500, statusCode);
    }

    @Test
    @Description("Негативный сценарий заказа через дебетовую карту с проверкой тела")
    void testSendInvalidCardNumberPayReturnStatusDeclined() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(INVALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendPayRequest(payRequestPojo);
        Assertions.assertEquals(DECLINED_STATUS, payResponsePojo.getStatus());
    }

    @Test
    @Description("Негативный сценарий заказа через дебетовую карту с проверкой тела")
    void testSendInvalidCVVPayReturnStatusDeclined() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(INVALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendPayRequest(payRequestPojo);
        Assertions.assertEquals(DECLINED_STATUS, payResponsePojo.getStatus());
    }

    @Test
    @Description("Позитивный сценарий заказа через кредитную карту с проверкой тела")
    void testSendValidRequestCreditReturnStatusApproved() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendCreditRequest(payRequestPojo);
        Assertions.assertEquals(APPROVED_STATUS, payResponsePojo.getStatus());
    }

    @Test
    @Description("Позитивный сценарий заказа через кредитную карту с проверкой статус-кода")
    void testSendValidRequestCreditReturnStatus200() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        int statusCode = payStep.sendCreditRequestReturnStatusCode(payRequestPojo);
        Assertions.assertEquals(200, statusCode);
    }

    @Test
    @Description("Негативный сценарий заказа через кредитную карту с проверкой статус-кода")
    void testSendInvalidRequestCreditReturnStatus500() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setMonth(VALID_MONTH);

        int statusCode = payStep.sendCreditRequestReturnStatusCode(payRequestPojo);
        Assertions.assertEquals(500, statusCode);
    }

    @Test
    @Description("Негативный сценарий заказа через кредитную карту с проверкой тела")
    void testSendInvalidCardNumberCreditReturnStatusDeclined() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(VALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(INVALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendCreditRequest(payRequestPojo);
        Assertions.assertEquals(DECLINED_STATUS, payResponsePojo.getStatus());
    }

    @Test
    @Description("Негативный сценарий заказа через кредитную карту с проверкой тела")
    void testSendInvalidCVVCreditReturnStatusDeclined() {
        PayStep payStep = new PayStep();
        PayRequestPojo payRequestPojo = new PayRequestPojo();
        payRequestPojo
                .setCvc(INVALID_CVV)
                .setYear(VALID_YEAR)
                .setHolder(VALID_HOLDER)
                .setNumber(VALID_CARD_NUMBER)
                .setMonth(VALID_MONTH);

        PayResponsePojo payResponsePojo = payStep.sendCreditRequest(payRequestPojo);
        Assertions.assertEquals(DECLINED_STATUS, payResponsePojo.getStatus());
    }

}
