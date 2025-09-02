package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class PathParamters {
    @Test
    public static void pathParamTest()
    {
        given()
                .header("x-api-key","reqres-free-v1")
                .pathParams("id",2)
        .when()
                .get("https://reqres.in/api/users/{id}")
        .then()
                .statusCode(200)
                .body("data.id",equalTo(2))
                .log().body();
    }
}
