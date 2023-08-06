package diploma.api.steps;

import diploma.api.pojo.request.PayRequestPojo;
import diploma.api.pojo.response.PayResponsePojo;
import diploma.utils.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreditStep {

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

}
