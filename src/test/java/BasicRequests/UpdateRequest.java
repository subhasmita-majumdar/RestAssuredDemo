package BasicRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateRequest {
    @Test
    public static void updateSingleUser()
    {
        given()
                .header("x-api-key","reqres-free-v1")
        .when()
                .put("https://reqres.in/api/users/1")
        .then()
                .statusCode(200)
                .log().body();
    }
}
