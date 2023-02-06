package request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    public static Response post(String endPoint, Object requestBody) {
        return given()
                .baseUri("http://34.229.67.67:5000")
                .body(requestBody)
                .contentType("application/json")
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
    }
}
