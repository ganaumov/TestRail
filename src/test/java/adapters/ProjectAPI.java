package adapters;

import com.google.gson.Gson;
import io.restassured.specification.RequestSpecification;
import models.ProjectRq;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAPI {
    static Gson gson = new Gson();

    static String email = System.getProperty("email", PropertyReader.getProperty("email"));
    static String apiKey = System.getProperty("apiKey", PropertyReader.getProperty("apiKey"));

    static RequestSpecification spec = given()
            .contentType(io.restassured.http.ContentType.JSON)
            .auth()
            .preemptive()
            .basic(email, apiKey); // Используем Basic Auth

    private static final String BASE_URL = "https://bigcheesegana.testrail.io/index.php?/api/v2";

    static public int createProject(ProjectRq rq) {
        return given()
                .log().all()
                .spec(spec)
                .body(gson.toJson(rq))
                .when()
                .post(BASE_URL + "/add_project")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("id");
    }

    static public void deleteProject(Integer project_id) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .post(BASE_URL + "/delete_project/" + project_id)
                .then()
                .log().all()
                .statusCode(200);
    }

    static public void getProject(Integer project_id) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .get(BASE_URL + "/get_project/" + project_id)
                .then()
                .log().all()
                .statusCode(200);
    }
}