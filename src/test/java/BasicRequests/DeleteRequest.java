package BasicRequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteRequest {
    @Test
    public static void deleteSingleUser()
    {
        given()
             .header("x-api-key","reqres-free-v1")
        .when()
             .delete("https://reqres.in/api/users/1")
        .then()
             .statusCode(204)
             .log().body();
    }
}
