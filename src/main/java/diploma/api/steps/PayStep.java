package diploma.api.steps;

import diploma.api.pojo.request.PayRequestPojo;
import diploma.api.pojo.response.PayResponsePojo;
import diploma.utils.Endpoints;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayStep {

    @Step("Отправка запроса покупки дебетовой картой и получение тела ответа")
    public PayResponsePojo sendPayRequest(PayRequestPojo payRequestPojo) {
        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .body(payRequestPojo)
                .contentType(ContentType.JSON)
                .when()
                .post(Endpoints.PAY)
                .then()
                .extract()
                .as(PayResponsePojo.class);
    }

    @Step("Отправка запроса покупки дебетовой картой и получение статус-кода ответа")
    public int sendPayRequestReturnStatusCode(PayRequestPojo payRequestPojo) {
        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .body(payRequestPojo)
                .contentType(ContentType.JSON)
                .when()
                .post(Endpoints.PAY)
                .then()
                .extract()
                .statusCode();
    }

    @Step("Отправка запроса покупки кредитной картой и получение тела ответа")
    public PayResponsePojo sendCreditRequest(PayRequestPojo payRequestPojo) {
        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .body(payRequestPojo)
                .contentType(ContentType.JSON)
                .when()
                .post(Endpoints.CREDIT)
                .then()
                .extract()
                .as(PayResponsePojo.class);
    }

    @Step("Отправка запроса покупки кредитной картой и получение статус-кода ответа")
    public int sendCreditRequestReturnStatusCode(PayRequestPojo payRequestPojo) {
        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .body(payRequestPojo)
                .contentType(ContentType.JSON)
                .when()
                .post(Endpoints.CREDIT)
                .then()
                .extract()
                .statusCode();
    }


}
