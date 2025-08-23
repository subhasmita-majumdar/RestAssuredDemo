package CreateData;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;

public class CreateDataUsingJson {
    @Test(priority = 1)
    public static void addStudentRecordUsingJson()
    {
        JSONObject student_data=new JSONObject();
        student_data.put("name","Mark");
        student_data.put("location","Silicon Valley");
        student_data.put("phone","+21-88995566");

        String courses []={"Perl","PHP"};
        student_data.put("courses", courses);

        given()
                .contentType("application/json")
                .body(student_data.toString())
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("name",equalTo("Mark"))
                .body("location",equalTo("Silicon Valley"))
                .body("phone",equalTo("+21-88995566"))
                .body("courses[0]",equalTo("Perl"))
                .body("courses[1]",equalTo("PHP"))
                .log().all();
    }
}
