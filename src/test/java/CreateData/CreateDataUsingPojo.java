package CreateData;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateDataUsingPojo {
    @Test
    public static void addStudentRecordUsingPojo()
    {
        StudentPojoData student_data=new StudentPojoData();
        student_data.setName("Satya Nadella");
        student_data.setLocation("Silicon Valley");
        student_data.setPhone("+21-800995566");

        String courses []={"Python","Playwright"};
        student_data.setCourses(courses);

        given()
                .contentType("application/json")
                .body(student_data)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("name",equalTo("Satya Nadella"))
                .body("location",equalTo("Silicon Valley"))
                .body("phone",equalTo("+21-800995566"))
                .body("courses[0]",equalTo("Python"))
                .body("courses[1]",equalTo("Playwright"))
                .log().all();
    }
}
