package CreateData;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;

public class CreateDataUsingExternalJsonFile {

    @Test
    public static void addStudentDataUsingExternalJsonFile() throws FileNotFoundException {
        File f=new File("src/test/resources/student_data.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject student_data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(student_data.toString())
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all();
    }
}
