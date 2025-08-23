package CreateData;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CreateDataUsingHashMap {
    @Test(priority = 1)
    public static void addStudentRecordUsingHashMap()
    {
        HashMap<Object, Object> student_data=new HashMap<>();
        student_data.put("name","Jena");
        student_data.put("location","Amsterdam");
        student_data.put("phone","+61-626689");

        String courses []={"Java","Rest Assured"};
        student_data.put("courses", courses);
        given()
                .contentType("application/json")
                .body(student_data)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("name",equalTo("Jena"))
                .body("location",equalTo("Amsterdam"))
                .body("phone",equalTo("+61-626689"))
                .body("courses[0]",equalTo("Java"))
                .body("courses[1]",equalTo("Rest Assured"))
                .log().all();
    }
}
