package request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    protected static Response post(String endPoint, Object requestBody) {
        return given()
                .body(requestBody)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
    }
    protected static Response delete(String endPoint, int id){
        return given()
                .when()
                .log().all()
                .delete(endPoint + "/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    protected  static Response getId(String endPoint, int id){
        return given()
                .when()
                .get(endPoint, id)
                .then()
                .extract().response();

    }

}
