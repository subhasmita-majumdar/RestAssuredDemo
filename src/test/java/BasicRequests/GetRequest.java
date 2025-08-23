package BasicRequests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class GetRequest
{
    @Test(priority = 1)
    public static void getAllUsers(){
        given()
                .header("x-api-key","reqres-free-v1")
        .when()
                .get("https://reqres.in/api/users/")
        .then()
                .statusCode(200)
                .log().body();

    }
    @Test(priority = 2)
    public static void getSingleUser(){
        given()
                .header("x-api-key","reqres-free-v1")
        .when()
                .get("https://reqres.in/api/users/1")
        .then()
                .statusCode(200)
                .body("data.id",equalTo(1))
                .log().body();

    }
}
