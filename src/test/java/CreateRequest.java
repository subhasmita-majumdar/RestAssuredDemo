package test.java;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class CreateRequest {
    @Test
    public static void createNewUser()
    {
        HashMap<String,String>data =new HashMap<>();
        data.put("name", "Maria Sharapova");
        data.put("gender", "female");
        data.put("email", "maria.sharapova@test.com");
        data.put("status", "active");

        given()
                .headers("Authorization","Bearer cd90ba7b6355af9986e75dd66f9af76a56a55fcd52f5579f3d56691c8d89d3c2")
                .body(data)
                .contentType("application/json")
        .when()
                .post("https://gorest.co.in/public/v2/users")
        .then()
                .statusCode(201)
                .log().body();

    }
}
