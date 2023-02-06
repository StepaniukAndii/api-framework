package baseTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod
    public static void setUp(){
        RestAssured.baseURI = "http://34.229.67.67:5000";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }
}
